package question4server;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 *
 * @author mpumi
 */

public class Question4Server {

    public Question4Server() throws IOException {
        ServerSocket serveSoc = new ServerSocket(8000);
        System.out.println("The server is starting...");
        Socket soc = serveSoc.accept();

        int answer = 0;
        Random random = new Random();
        Random calcNumbers = new Random();

        char[] symbols = {'+', '*', '-', '/'};
        boolean isStop = false;

        DataInputStream input = new DataInputStream(soc.getInputStream());
        DataOutputStream output = new DataOutputStream(soc.getOutputStream());
        
        output.writeUTF("Welcome to  Edureka Trivia Game");
        
        while(!isStop){
            char mathOp = (symbols[random.nextInt(symbols.length)]);
            int numberA = calcNumbers.nextInt(10);
            int numberB = calcNumbers.nextInt(10);
            
            String calcRandom = numberA + " " + mathOp + " " + numberB;
            
            
            output.writeUTF("Question from the server : What is " + calcRandom + " ? ");
            String clientResponse = input.readUTF();
            isStop = clientResponse.equalsIgnoreCase("Stop");
            System.out.println("The answer from Client : " + clientResponse);
            
            
            switch(mathOp){
                case '+':
                    answer = numberA + numberB;
                    break;
                case '-':
                    answer = numberB - numberA;
                    break;
                case '*':
                    answer = numberA * numberB;
                    break;
                case '/':
                    answer = Math.round(numberB / numberA);
                    break;
                   
                
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Question4Server();
    }

}
