package realestateproject;

import java.awt.Button;

import java.awt.Choice;
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
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.lang.*;

public class RealEstate extends Frame{
	
	TextField t1;
	TextField t2;
	JLabel l1,l2;
	Label l3;
	JButton b1,b2,b3;
	String uname,password,rpassword,rid;
	int z=0;
	RealEstate()
	{
		
		setLayout(null);
		
		l3=new Label("LOGIN PAGE");
		l3.setBounds(375,100,150,25);
		add(l3);
		l3.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		l1=new JLabel("USERNAME (FIRST NAME)");
		l2=new JLabel("PASSWORD");
		l1.setBounds(200,200,150,25);
		l2.setBounds(200,250,150,25);
		add(l1);
		add(l2);
		
		t1=new TextField();
		t2=new TextField();
		t1.setBounds(400,200,250,25);
		t2.setBounds(400,250,250,25);
		
		add(t1);
		add(t2);
		t2.setEchoChar('*');
		
		b1=new JButton("FORGOT PASSWORD");
		b1.setBounds(200,400,175,30);
		add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1)
			{
				new ForgotPassword();
			}
		});
		
		b2=new JButton("CREATE NEW ACCOUNT");
		b2.setBounds(475,400,175,30);
		add(b2);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae2) {
				new Registration();
				
			}
		});
		
//		Icon icon=new ImageIcon("C:/Users/Dhiva/Pictures/login (2).jpg");
		b3=new JButton("LOGIN");
		b3.setBounds(375,325,100,30);
		add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae3)
			{
				uname=t1.getText();
				password=t2.getText();
//				if(uname==null)
//				{
//					JOptionPane.showMessageDialog(null, "Enter the Name");
//					z++;
//				}
//				else
//				{
//					z--;
//				}
//				if(password==null)
//				{
//					JOptionPane.showMessageDialog(null, "Enter the Password");
//					z++;
//				}
//				else
//				{
//					z--;
//				}
//				if(z==0)
//				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
					String query="select * from details where fname=\""+uname+"\" and password=\""+password+"\"";
					PreparedStatement stmt=con.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					
					while(rs.next())
					{
//						rpassword=rs.getString("password");
						rid=rs.getString("id");
						JOptionPane.showMessageDialog(null, "Login Success");
						new Entry(rid);
						
						
					}
//					JOptionPane.showMessageDialog(null, "Login Success");
//					new Entry(rid);
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Account not found");
				}
				}
				
//			}
		});
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		
		setBackground(Color.gray);
		setSize(1000,1000);
		setResizable(true);
		setVisible(true);
		
	}
	
	public static void main(String args[])
	{
		new RealEstate();
	}

}
