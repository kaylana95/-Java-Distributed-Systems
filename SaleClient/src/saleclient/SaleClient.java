/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saleclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import sales.Province;
import sales.Sales;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public class SaleClient {

   
    public static void main(String[] args)  {
        
        try{
        Registry registry = LocateRegistry.createRegistry(9000); 
    
         // Looking up the registry for the remote object 
         Sales sale = (Sales) registry.lookup("Sale"); 
         registry.bind("Sales", sale);
    
         // Calling the remote method using the obtained object 
         List<Province> list = (List)sale.getProvince(); 
         for (Province pro:list){ 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("ID: " + pro.getId()); 
            System.out.println("provinceName: " + pro.getProvinceName());
            System.out.println("litres: " + pro.getLitres());
          
         }  
    } catch(Exception e){
            System.out.println("Client exception " + e.toString());
    }
    }
}
