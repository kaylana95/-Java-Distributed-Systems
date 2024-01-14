/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mathinterface.MathInterface;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public class MathClient extends JFrame implements ActionListener {
//USES THE INTERFACE CLASS

    int num1, num2, results = 0;
    String[] mathSymbols = {"+", "-", "*", "/"};
    
    JLabel lab1 = new JLabel("Edureka Calculator App V1.0");
    JLabel lab2 = new JLabel("Developer: N.A.K.A Mtshatsheni");
    JLabel lab3 = new JLabel("Input 1st Number: ");
    JLabel lab4 = new JLabel("Choose Symbols: ");
    JComboBox<String> mathCalc = new JComboBox<>(mathSymbols);
    JLabel lab5 = new JLabel("Input 2st Number: ");
    JButton btn = new JButton("Calculate");
    JTextField txt1 = new JTextField(20);
    JTextField txt2 = new JTextField(20);
    JTextField txt3 = new JTextField(20);
    
    public MathClient() {
        super("Edureka Calculator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(450, 250);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        panel.add(lab1);
        panel.add(lab2);
        
        panel.add(lab3);
        panel.add(txt1);
        
        panel.add(lab4);
        panel.add(mathCalc);
        
        panel.add(lab5);
        panel.add(txt2);
        
        panel.add(btn);
        panel.add(txt3);
        
        setVisible(true);
        add(panel);
        
        btn.addActionListener(this);
    }

    public static void main(String[] args) {
        new MathClient();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object calc = ae.getSource();
        if (calc.equals(btn)) {
            if ("".equals(txt1.getText()) && "".equals(txt2.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter number first", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Registry reg = LocateRegistry.getRegistry("localhost", 8080);
                    MathInterface math = (MathInterface) reg.lookup("MathInterface");
                    
                    num1 = Integer.parseInt(txt1.getText());
                    num2 = Integer.parseInt(txt2.getText());
                    if (mathCalc.getSelectedItem().equals("+")) {
                        txt3.setText("" + math.add(num1, num2));
                    } else if (mathCalc.getSelectedItem().equals("-")) {
                        txt3.setText("" + math.subtract(num1, num2));
                    } else if (mathCalc.getSelectedItem().equals("*")) {
                        txt3.setText("" + math.multiply(num1, num2));
                    } else if (mathCalc.getSelectedItem().equals("/")) {
                        txt3.setText("" + math.divide(num1, num2));
                    }
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(MathClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(MathClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
