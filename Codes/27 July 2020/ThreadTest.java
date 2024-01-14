/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

/**
 *
 * @author UMAPAND
 */
public class ThreadTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread t1 = new Thread(new TheThread("multi4"));
        Thread t2 = new Thread(new TheThread("multi2"));
         Thread t3 = new Thread(new TheThread("multi3"));
         t1.start();
         t2.start();
         t3.start();
    }
    
}
