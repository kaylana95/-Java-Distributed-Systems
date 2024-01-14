package question5a;

import java.io.*;
import java.net.*;
import java.sql.*;

/**
 *
 * @author mpumi
 */
public class Question5A {
    Connection conn;
    static boolean isStop = true;

    public Question5A() throws IOException, ClassNotFoundException, SQLException {
        ServerSocket serveSoc = new ServerSocket(8000);
        Socket soc = serveSoc.accept();
    
        DataInputStream input = new DataInputStream(soc.getInputStream());
        DataOutputStream output = new DataOutputStream(soc.getOutputStream());
        
        System.out.println("Server is starting...");
        System.out.println("Welcome to Checkers Stock Taking App");      
        String text = input.readUTF();
        while(!isStop){
            String[] recievedMessage = text.split("#");
            System.out.print("Server received product details ");
            System.out.print(" " + recievedMessage[0]);
            System.out.print(" " + recievedMessage[1]);
            System.out.println(" " + recievedMessage[2]);
            dbConnection();
            conn.createStatement().execute("INSERT INTO `products` ( `prodName`, `prodType`, `prodPrice`) VALUES('" + recievedMessage[0] + "','" + recievedMessage[1] + "','" + recievedMessage[2] + "');");
            output.writeUTF("Server says : Product has been added");
        }
    }
    public void dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/checkersproducts", "root", "");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        new Question5A();
    }
}
