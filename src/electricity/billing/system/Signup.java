package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends JFrame implements ActionListener{

    JButton create, back;private JComboBox comboBox; private JTextField textField_3;
    JPanel contentPane;
     JPanel panel;
     JLabel re;
    Choice accountType;
    JTextField meter, username, name, password;
    Signup(){
        
        setBounds(450, 200, 700, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        panel = new JPanel();
        panel.setBounds(30, 30, 650, 400);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);
        
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);
        
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.BLACK);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);
        
        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.BLACK);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);
        
        
        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
	comboBox.setBounds(265, 250, 148, 20);
	panel.add(comboBox);

	JLabel lblSecurityQuestion = new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.BLACK);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(99, 250, 140, 26);
	panel.add(lblSecurityQuestion);
        
        JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.BLACK);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAnswer.setBounds(99, 290, 92, 26);
	panel.add(lblAnswer);
        
        textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 290, 148, 20);
	panel.add(textField_3);
        
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 360, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 360, 120, 25);
        back.addActionListener(this);
        panel.add(back);
        
        re = new JLabel("* Password should be of size 8-20 characters consisting each of [A-Z], [a-z], [0-9], [@#$%]");
	re.setForeground(Color.red);
	re.setFont(new Font("Tahoma", Font.BOLD, 12));
	re.setBounds(15, 320, 600, 26);
	 panel.add(re);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);
       
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
            boolean validPassword = isValidPassword(spassword,regex);
            String smeter = meter.getText();
            String sques =  (String) comboBox.getSelectedItem();
            String sans = textField_3.getText();
            if(susername!=" "){
            try {
                Conn c = new Conn();
                 
                if(validPassword==true){
                String query = null;
               
                if (atype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"', '"+sques+"','"+sans+"')";
                } else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"', ques = '"+sques+"', ans = '"+sname+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                 setVisible(false);
                new Login();
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Enter valid Details"); 
                   setVisible(true);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
                {
                  JOptionPane.showMessageDialog(null, "Enter all fileds ");
                // setVisible(true);
                 
                
                }
        } else if (ae.getSource() == back) {
            setVisible(false);
            
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
    public static boolean isValidPassword(String password,String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
