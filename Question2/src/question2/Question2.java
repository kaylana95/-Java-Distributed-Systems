package question2;
import java.io.*;
import java.net.*;

/**
 *
 * @author mpumi
 */

public class Question2 {

    public Question2() throws IOException {
        ServerSocket serveSoc = new ServerSocket(9000);
        Socket soc = serveSoc.accept();
        DataInputStream input = new DataInputStream(soc.getInputStream());
        DataOutputStream output = new DataOutputStream(soc.getOutputStream());
        System.out.println("Server is starting...");
        String text = " ", text2 = "Server says goodbye!";
        
        while(true){
            text = input.readUTF();
           System.out.println("Message received from client :  " + text);
           if(text.equals("Hello, I study ITJA321 at PIHE")){
               break;
           }
        }

        output.writeUTF(text2);
        input.close();
        soc.close();
        
        
    }

    public static void main(String[] args) throws IOException {
        new Question2();
    }

}
