/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public interface MathInterface extends Remote{
    
    
 public int add(int num1, int num2) throws RemoteException;

    public int subtract(int num1, int num2) throws RemoteException;

    public int multiply(int num1, int num2) throws RemoteException;

    public int divide(int num1, int num2) throws RemoteException;
   
    
}
