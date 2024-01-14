package question1client;

import java.io.*;
import java.net.*;

/**
 *
 * @author mpumi
 */
public class Question1Client {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for(int i=0; i<5;i++){
            
            socket = new Socket(host.getHostName(), 8000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)oos.writeObject("exit");
            else oos.writeObject(""+i);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
}
    