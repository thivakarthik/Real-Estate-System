package realestateproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class ForgotPassword extends Frame
{
	JTextField t1,t2,t3;
	JLabel l1,l2;
	JButton b1,b2;
	Label l3;
	String fname,phone,password;
	ForgotPassword()
	{
		setLayout(null);
		
		l1=new JLabel("USERNAME (FIRST NAME)");
		l2=new JLabel("PHONE NUMBER");
		l1.setBounds(200,200,150,25);
		l2.setBounds(200,250,100,25);
		add(l1);
		add(l2);
		
		l3=new Label("FORGOT PASSWORD PAGE");
		l3.setBounds(300,100,275,25);
		add(l3);
		l3.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		t1=new JTextField();
		t2=new JTextField();
		t1.setBounds(450,200,200,25);
		t2.setBounds(450,250,200,25);
		add(t1);
		add(t2);
		
		b1=new JButton("GET PASSWORD");
		b1.setBounds(350,350,150,30);
		add(b1);
		
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae2)
			{
				fname=t1.getText();
				phone=t2.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
					String query="select password from details where fname=\""+fname+"\" and phone=\""+phone+"\"";
					PreparedStatement stmt=con.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					
					while(rs.next())
					{
						password=rs.getString("password");
						
						
//						t3=new TextField(""+password+"");
//						t3.setBounds(200,300,100,25);
//						add(t3);
					}
					JOptionPane.showMessageDialog(null, "PASSWORD IS "+password);
					System.out.println(password);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"ACCOUNT NOT FOUND");
				}
			}
		});
		
		b2=new JButton("BACK");
		b2.setBounds(200,350,100,30);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		
		setSize(1000,1000);
		setBackground(Color.gray);
		setVisible(true);
		setResizable(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we1)
			{
				dispose();
			}
		});
	}
}
