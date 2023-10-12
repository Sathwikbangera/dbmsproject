/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
        String username,user, meter;
	int s;
	Thread th;

	public static void main(String[] args) {
            new Loading("","","").setVisible(true);
	}

	public void setUploading() {
            setVisible(false);
            th.start();
	}

	public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        i = 201;
                        setVisible(false);
                        new Project(username,user, meter);
                        //new Home(username).setVisible(true);
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading(String username,String user,String meter) {
            this.username = username;
            this.user=user;
            this.meter=meter;
            th = new Thread((Runnable) this);

            setBounds(600, 300, 600, 400);
            contentPane = new JPanel();
            contentPane.setBackground(Color.black);
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lbllibraryManagement = new JLabel("Welcome to");
            lbllibraryManagement.setForeground(Color.blue);
            lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            lbllibraryManagement.setBounds(200, 6, 600, 35);
            contentPane.add(lbllibraryManagement);
	 
            JLabel lbllibraryManagement1 = new JLabel("Electricity Billing Application");
            lbllibraryManagement1.setForeground(Color.red);
            lbllibraryManagement1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            lbllibraryManagement1.setBounds(95, 50, 600, 40);
            contentPane.add(lbllibraryManagement1);
            
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true);
            progressBar.setBounds(130, 135, 300, 25);
            contentPane.add(progressBar);

            JLabel lblNewLabel_2 = new JLabel("Please Wait....");
            lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            lblNewLabel_2.setForeground(new Color(160, 82, 45));
            lblNewLabel_2.setBounds(200, 165, 150, 20);
            contentPane.add(lblNewLabel_2);
            
            JLabel lbllibraryManagement2 = new JLabel("BHAARATH POWER LIMITED");
            lbllibraryManagement2.setForeground( Color.black);
            lbllibraryManagement2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            lbllibraryManagement2.setBounds(145, 250, 600, 40);
            contentPane.add(lbllibraryManagement2);
            
            JLabel lbllibraryManagement3 = new JLabel("MANGALORE");
            lbllibraryManagement3.setForeground( Color.blue);
            lbllibraryManagement3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            lbllibraryManagement3.setBounds(240, 290, 600, 40);
            contentPane.add(lbllibraryManagement3);
            


            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBounds(10, 10, 580, 380);
            contentPane.add(panel);
              
            setUndecorated(true);
            setUploading();
	}
}