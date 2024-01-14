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
public class TheThread extends Thread{
  String name;
Task task = new Task();
    public TheThread(String name) {
        this.name = name;
    }
  @Override
    public void run()
    {
       if (this.name.equals("multi3"))
       {
           task.multi3();
           
       }
        if (this.name.equals("multi2"))
       {
           task.multi2();
           
       }
         if (this.name.equals("multi4"))
       {
           task.multi4();
           
       }
    }
  
}
