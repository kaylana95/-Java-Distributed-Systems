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
public class Task {
    
    int count;
    public void multi3()
    {
       for (count = 3;count<=15;count+=3) 
       {
           System.out.println("Multiple of 3   "+ count);
       }
    }
    public void multi4()
    {
     for (count = 4;count<=15;count+=4) 
       {
           System.out.println("Multiple of 4  "+ count);
       }   
    }
    public void multi2()
    {
        for (count = 2;count<=15;count+=2) 
       {
           System.out.println("Multiple of 2  "+ count);
       }
    }
}
