/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleserver;

import java.awt.BorderLayout;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import saleconnectionimpl.SaleConnectionImpl;
import sales.Sales;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public class SaleServer extends SaleConnectionImpl {

    public SaleServer() {

    }

    public static void main(String[] args) {

        try {
            // Instantiating the implementation class
            SaleConnectionImpl obj = new SaleConnectionImpl();

         // Exporting the object of sale connection class (
            //here we are exporting the remote object to the sale) 
            Sales sale = (Sales) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry 
            Registry registry = LocateRegistry.getRegistry("localhost", 9000);

            registry.bind("Sales", sale);
            System.err.println("The server is ready");
        } catch (Exception e) {
            System.out.println("Server exception" + e.toString());
                    
        }
        }
    }
