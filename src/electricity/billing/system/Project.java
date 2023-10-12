package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{

    String atype, meter;
    private JPanel panel,s;
    ImageIcon icon4;
    JButton up,det,newcusto,detv,cal,vw,py,de,ge,ca,nt,ex;
    JLabel lblname5,lblname6,lblname7;
    Project(String name,String atype, String meter) {
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        
        JLabel l1 = new JLabel("Electricity Billing System");
	l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 65));
	l1.setBounds(450, 60, 1000, 100);
	NewLabel.add(l1);
        
        /*               --------------admin page buttons----------                  */
       
        s=new JPanel();
        s.setLayout(null);
        s.setBackground(Color.BLACK);
       
        s.setLocation(100,200);
        NewLabel.add(s);
        
        
        
        JLabel heading = new JLabel("ADMIN PAGE");
        heading.setBounds(15, 10, 200, 20);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        
        JLabel headingk = new JLabel("Hi,"+name);
        headingk.setBounds(10, 10, 200, 20);
        headingk.setForeground(Color.white);
        headingk.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        
        JLabel lblname = new JLabel("NEW CUSTOMER:");
        lblname.setBounds(35, 10, 200, 50);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        
        newcusto = new JButton("ADD");
        newcusto.setBounds(50, 60, 200, 50);
        newcusto.setForeground(Color.BLACK);
        newcusto.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcusto.setIcon(new ImageIcon(image1));
        newcusto.addActionListener(this);
       
        
        JLabel lblname2 = new JLabel("CUSTOMER DETAILS:");
        lblname2.setBounds(35, 115, 200, 50);
        lblname2.setForeground(Color.white);
        lblname2.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        det = new JButton("VIEW");
        det.setBounds(50, 165, 200,50);
        det.setForeground(Color.BLACK);
        det.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        det.setIcon(new ImageIcon(image2));
        det.addActionListener(this);   
        
        JLabel lblname3 = new JLabel("DEPOSIT DETAILS:");
        lblname3.setBounds(35, 330, 200, 50);
        lblname3.setForeground(Color.white);
        lblname3.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        detv = new JButton("VIEW");
         detv.setBounds(50, 380, 200,50);
        detv.setForeground(Color.BLACK);
        detv.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        detv.setIcon(new ImageIcon(image3));
        detv.addActionListener(this);
        
        JLabel lblname4 = new JLabel("CALCULATE BILL:");
        lblname4.setBounds(35, 225, 200, 50);
        lblname4.setForeground(Color.white);
        lblname4.setFont(new Font("Tahoma", Font.BOLD, 18));
     
        
        cal = new JButton("CALCULATE");
        cal.setBounds(50, 275, 200,50);
        cal.setForeground(Color.BLACK);
        cal.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cal.setIcon(new ImageIcon(image4));
        cal.addActionListener(this);
       
        /*                                         --------user page---------------                      */
        
        lblname5 = new JLabel("PROFILE:");
        lblname5.setBounds(40, 10, 200, 50);
        lblname5.setForeground(Color.WHITE);
        lblname5.setFont(new Font("Tahoma", Font.BOLD, 18));
          
        up = new JButton("UPDATE");
        up.setBounds(50, 60, 200,50);
        up.setForeground(Color.BLACK);
        up.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        up.setIcon(new ImageIcon(image5));
        up.addActionListener(this);
        
        vw = new JButton("VIEW   ");
        vw.setBounds(50, 115, 200,50);
        vw.setForeground(Color.BLACK);
        vw.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image image6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        vw.setIcon(new ImageIcon(image6));
        vw.addActionListener(this);
        
        lblname6 = new JLabel("BILL:");
        lblname6.setBounds(40, 175, 200, 50);
        lblname6.setForeground(Color.WHITE);
        lblname6.setFont(new Font("Tahoma", Font.BOLD, 18));
          
        py = new JButton("PAY");
        py.setBounds(50,225, 200,50);
        py.setBackground(Color.WHITE);
        py.setForeground(Color.BLACK);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        py.setIcon(new ImageIcon(image7));
        py.addActionListener(this);
        
        de = new JButton("DETAILS");
        de.setBounds(50, 280, 200,50);
        de.setForeground(Color.BLACK);
        de.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        de.setIcon(new ImageIcon(image8));
        de.addActionListener(this);
        
        ge = new JButton("GENERATE");
        ge.setBounds(50, 335, 200,50);
        ge.setForeground(Color.BLACK);
        ge.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ge.setIcon(new ImageIcon(image9));
        ge.addActionListener(this);
        
        nt = new JButton("NOTEPAD");
        nt.setBounds(1350, 700, 150,50);
        nt.setForeground(Color.BLACK);
        nt.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        nt.setIcon(new ImageIcon(image10));
        nt.addActionListener(this);
        
        ca = new JButton("CALCULATOR");
        ca.setBounds(1150, 700, 150,50);
        ca.setForeground(Color.BLACK);
        ca.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ca.setIcon(new ImageIcon(image11));
        ca.addActionListener(this);
        
        ex = new JButton("LOG OUT");
        ex.setBounds(1400, 10, 130,50);
        ex.setForeground(Color.BLACK);
        ex.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image12));
        ex.addActionListener(this);
        
        if (atype.equals("Admin")) {
          
            NewLabel.add(heading);
            s.setSize(300,475);
            s.add(lblname);
            s.add(newcusto);
            s.add(lblname2);
            s.add(det);
            s.add(lblname3);
            s.add(detv);
            s.add(lblname4);
            s.add(cal);
           
        } else {
           NewLabel.add(headingk);
             s.setSize(300,430);
            s.add(lblname5);
            s.add(up);
            s.add(vw);
            s.add(lblname6);
            s.add(py);
            s.add(de);
            s.add(ge);
        }
        NewLabel.add(ca);
        NewLabel.add(nt);
        NewLabel.add(ex);
        
       
       
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if(ae.getSource()==newcusto)
         { new NewCustomer(); }
        else if(ae.getSource()==det)
              new CustomerDetails();
        else if(ae.getSource()==detv)
              new DepositDetails();
        else if(ae.getSource()==cal)
             new CalculateBill();
        else if(ae.getSource()==up)
          new UpdateInformation(meter);
        else if(ae.getSource()==vw)
          new ViewInformation(meter);
         else if(ae.getSource()==de)
          new BillDetails(meter);
         else if(ae.getSource()==py)
           new PayBill(meter);
        else if(ae.getSource()==ge)
           new GenerateBill(meter);
        else if(ae.getSource()==nt){
           try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }}
        else if(ae.getSource()==ca)
        {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==ex)
        { setVisible(false);
            new Login();
        }
         
      
    }

    public static void main(String[] args) {
        new Project("","", "");
        
    }
}
