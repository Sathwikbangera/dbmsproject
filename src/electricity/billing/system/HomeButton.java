
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class HomeButton extends JFrame implements ActionListener{
    
    JButton newcusto,det,detv,up,cal;
    HomeButton(String atype){
        setSize(1800,200);
        setLocation(0,500);
        
        JPanel s=new JPanel();
        s.setLayout(null);
        s.setBackground(Color.WHITE);
        
        
        JPanel k=new JPanel();
        k.setLayout(null);
        k.setBackground(Color.WHITE);
        
       if (atype.equals("Admin")) {
            add(s);
       }else
            add(k);
        
        
        JLabel heading = new JLabel("----MASTER----");
        heading.setBounds(800, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        s.add(heading);
        
        JLabel headingk = new JLabel("----USER----");
        headingk.setBounds(800, 10, 200, 20);
        headingk.setFont(new Font("Tahoma", Font.PLAIN, 20));
        k.add(headingk);
        
        JLabel lblname = new JLabel("New Customer ");
        lblname.setBounds(100, 30, 100, 20);
        s.add(lblname);
        
        newcusto = new JButton("ADD");
        newcusto.setBounds(100, 60, 100,25);
        newcusto.setBackground(Color.BLACK);
        newcusto.setForeground(Color.WHITE);
        newcusto.addActionListener(this);
        s.add(newcusto);
        
        JLabel lblname2 = new JLabel("Customer Details");
        lblname2.setBounds(250, 30, 100, 20);
        s.add(lblname2);
        
        det = new JButton("VIEW");
        det.setBounds(250, 60, 100,25);
        det.setBackground(Color.BLACK);
        det.setForeground(Color.WHITE);
        det.addActionListener(this);
        s.add(det);
        
        JLabel lblname3 = new JLabel("Deposit Details");
        lblname3.setBounds(400, 30, 100, 20);
        s.add(lblname3);
        
        detv = new JButton("VIEW");
        detv.setBounds(400, 60, 100,25);
        detv.setBackground(Color.BLACK);
        detv.setForeground(Color.WHITE);
        detv.addActionListener(this);
        s.add(detv);
        
        JLabel lblname4 = new JLabel("Calculate Bill");
        lblname4.setBounds(550, 30, 100, 20);
        s.add(lblname4);
        
        cal = new JButton("Calculate");
        cal.setBounds(550, 60, 100,25);
        cal.setBackground(Color.BLACK);
        cal.setForeground(Color.WHITE);
        cal.addActionListener(this);
        s.add(cal);
        
        JLabel lblname5 = new JLabel("INFORMATION");
        lblname5.setBounds(700, 30, 100, 20);
        s.add(lblname5);
        
        
        
        JButton up = new JButton("UPDATE");
        up.setBounds(700, 60, 100,25);
        up.setBackground(Color.BLACK);
        up.setForeground(Color.WHITE);
        up.addActionListener(this);
        s.add(up);
        //setUndecorated(true);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==newcusto)
         {
              new NewCustomer();
         }
         if(ae.getSource()==det)
              new CustomerDetails();
         if(ae.getSource()==detv)
              new DepositDetails();
         if(ae.getSource()==cal)
             new CalculateBill();
     }
    public static void main(String[] args){
        new HomeButton("");
    }
}
