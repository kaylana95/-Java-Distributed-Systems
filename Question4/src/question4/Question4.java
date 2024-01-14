/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package question4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.*;

/**
 *
 * @author Nompumelelo Mtshatsheni
 */
public class Question4 extends JFrame implements ActionListener{

    JLabel lab = new JLabel("Welcome to Luthando High School Registration App");
    JLabel lab1 = new JLabel("Enter Pupil Name: ");
    JTextField txt = new JTextField(20);
    JButton btn1 = new JButton("Register Pupil");
    JButton btn2 = new JButton("Show All Registrations");
   
    public Question4(){
        
        super(" Luthando High School Registration App");
        setSize(410, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        JPanel panel = new JPanel();
        panel.add(lab);
        panel.add(lab1);
        panel.add(txt);
        panel.add(btn1);
        panel.add(btn2);
       
        getContentPane().add(panel);
        setVisible(true);
        pack();
    
    }
    
    
    public static void main(String[] args) {
        Question4 q4 = new Question4();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
