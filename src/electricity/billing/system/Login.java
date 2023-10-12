package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{

    JButton login, cancel, signup;	
   private JPanel panel; 
   private JButton b3;
    TextField username, password;
    Choice logginin;
    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);
        
        username = new TextField();
        username.setBounds(400, 20, 150, 20);
        add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);
        
        password = new TextField(15);
        password.setEchoChar('*');
        password.setBounds(400, 60, 150, 20);
       
        add(password);
        
        
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(300, 100, 100, 20);
        add(loggininas);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(380,200, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(450, 160, 100, 20);
        signup.addActionListener(this);
        add(signup);
        
        b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(350, 231, 179, 25);
	panel.add(b3);
        
        JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(220, 235, 130, 20);
	panel.add(l5);

        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spassword = password.getText();
            String user = logginin.getSelectedItem();
            
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Loading(susername,user ,meter).setVisible(true);
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login\nENTER VALID DETAILS");
                    username.setText("");
                    password.setText("");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }else if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
         }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
