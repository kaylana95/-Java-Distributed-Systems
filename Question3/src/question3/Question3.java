package question3;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author mpumi
 */

public class Question3 {

    public Question3() throws IOException {
        Socket soc = new Socket("localhost", 9000);
        DataInputStream input = new DataInputStream(soc.getInputStream());
        DataOutputStream output = new DataOutputStream(soc.getOutputStream());
        //inputing the message
        BufferedReader dr = new BufferedReader(new InputStreamReader(System.in));
        String message = "", req = "";

        do {
            message = dr.readLine();
            output.writeUTF(message);
            req = input.readUTF();
            System.out.println("Server say : " + req);

        } while (!req.equals("Bye!"));
        soc.close();
        //output.writeUTF("Hello, I study ITJA321 at PIHE!");
        //System.out.println("Message will be received by the server : " + input.readUTF());
    }

    public static void main(String[] args) throws IOException {
        new Question3();
    }
}
