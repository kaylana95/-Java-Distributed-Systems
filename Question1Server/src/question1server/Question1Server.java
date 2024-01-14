package question1server;

import java.io.*;
import java.net.*;

/**
 *
 * @author mpumi
 */
public class Question1Server {

    //The server will run on a specific pc and has a socket that is defiantly 
    //bound to a specific port number. Yet the server will wait and listens 
    //to the socket from the client to make a connection request. 
    //Once everything goes according to plan when establishing the connection. 
    //The server will accept the connection. Upon acceptance of the connection, 
    //the server will get a new socket bound to a different port. 
    
    //It needs a new socket (consequently a different port number) so that 
    //it can continue to listen to the original socket for connection requests 
    //while serving the connected client.

    private static ServerSocket serv;
    private static int port = 8000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serv = new ServerSocket(port);
        while (true) {
            System.out.println("Waiting for the client request");
            Socket socket = serv.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi Client " + message);
            ois.close();
            oos.close();
            socket.close();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }
        System.out.println("Shutting down Socket server!!");
 
        serv.close();
    }

}


    

