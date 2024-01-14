package question4client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
*
* @author mpumi
*/
public class Question4Client {

    Scanner sc = new Scanner(System.in);

    public Question4Client() throws IOException {
        Socket soc = new Socket("localhost", 8000);
        
        DataInputStream input = new DataInputStream(soc.getInputStream());
        
        DataOutputStream output = new DataOutputStream(soc.getOutputStream());
        
        String client = " ";
        
        while(!client.equalsIgnoreCase("Stop")){
            System.out.println("" + input.readUTF());
            client = sc.next();
            output.writeUTF(client);
            System.out.println("" + input.readUTF());
        }
        System.out.println("Thank you for playing, good bye!");

    }

    public static void main(String[] args) throws IOException {
       new Question4Client();
    }

}
