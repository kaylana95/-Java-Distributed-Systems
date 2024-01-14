package question5b;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author mpumi
*/

public class Question5B {
    String productName;
    String productType;
    double productPrice;
    Scanner sc = new Scanner(System.in);
    static boolean isStop = true;
    Socket soc = new Socket("localhost", 8000);
    DataOutputStream output;
    DataInputStream in;

    public Question5B() throws IOException {
        output = new DataOutputStream(soc.getOutputStream());
        output.writeUTF(productName + "#" + productType + "#" + productPrice);

        in = new DataInputStream(soc.getInputStream());
        System.out.println("Server says : " + in.readUTF());
        captureDetails();
    }
    public void captureDetails() throws IOException {
        System.out.println("Welcome to Checkers Stock Taking App");
        System.out.println("Enter the product name: ");
        productName = sc.next();
        if (productName.equalsIgnoreCase("Stop")) {
            System.out.println("Exiting Checkers Stock Taling App");
            output.writeUTF("Stop");
            //break;
        }
        System.out.println("Enter Product Type: ");
        productType = sc.next();
        System.out.println("Enter Product Price: ");
        try {
            productPrice = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect decimal number");
        }
    }
    public String readScannerInput() throws IOException {
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            System.out.println("" + in.readUTF());
            input = sc.nextLine();
            output.writeUTF(input);
            System.out.println("" + in.readUTF());
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        new Question5B();

    }

}
