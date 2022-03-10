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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import realestateproject.RealEstate.Entry;

class Registration extends Frame
{
	JLabel l1,l2,l3,l4,l5,l6;
	Label l7;
	JTextField t1,t2,t3,t4,t5;
	JComboBox ch1,ch2,ch3;
	JButton b1,b2;
	int ref=0;
	String fname,lname,address,phone,date,month,year,password,rid;
	int z,y;
	Registration()
	{
		setLayout(null);
		l1=new JLabel("FIRST NAME");
		l1.setBounds(300,200,100,25);
		add(l1);
		
		l2=new JLabel("LAST NAME");
		l2.setBounds(300,250,100,25);
		add(l2);
		
		l3=new JLabel("ADDRESS");
		l3.setBounds(300,300,100,25);
		add(l3);
		
		l4=new JLabel("PHONE NO");
		l4.setBounds(300,350,100,25);
		add(l4);
		
		l5=new JLabel("DATE OF BIRTH");
		l5.setBounds(300,400,150,25);
		add(l5);
		
		l6=new JLabel("CREATE NEW PASSWORD");
		l6.setBounds(300,450,150,25);
		add(l6);
		
		l7=new Label("REGISTRATION PAGE");
		l7.setBounds(400,100,225,25);
		add(l7);
		l7.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		
		t1=new JTextField();
		t1.setBounds(500,200,200,25);
		add(t1);
		
		t2=new JTextField();
		t2.setBounds(500,250,200,25);
		add(t2);

		t3=new JTextField();
		t3.setBounds(500,300,200,25);
		add(t3);
		
		t4=new JTextField();
		t4.setBounds(500,350,200,25);
		add(t4);
		
		ch1=new JComboBox();
		ch1.setBounds(500,400,100,25);
		add(ch1);
		ch1.addItem("DATE");
		ch1.addItem("01");
		ch1.addItem("02");
		ch1.addItem("03");
		ch1.addItem("04");
		ch1.addItem("05");
		ch1.addItem("06");
		ch1.addItem("07");
		ch1.addItem("08");
		ch1.addItem("09");
		for(int i=10;i<=31;i++)
		{
			ch1.addItem(""+i+"");
		}
		ch2=new JComboBox();
		ch2.setBounds(600,400,100,25);
		add(ch2);
		ch2.addItem("MONTH");
		ch2.addItem("01");
		ch2.addItem("02");
		ch2.addItem("03");
		ch2.addItem("04");
		ch2.addItem("05");
		ch2.addItem("06");
		ch2.addItem("07");
		ch2.addItem("08");
		ch2.addItem("09");
		ch2.addItem("10");
		ch2.addItem("11");
		ch2.addItem("12");
		ch3=new JComboBox();
		ch3.setBounds(700,400,100,25);
		add(ch3);
		ch3.addItem("YEAR");
		for(int k=1950;k<=2021;k++)
		{
			ch3.addItem(""+k+"");
		}
		
		t5=new JTextField();
		t5.setBounds(500,450,200,25);
		add(t5);
		
		
		b1=new JButton("BACK");
		b1.setBounds(300,550,100,25);
		add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		b2=new JButton("CREATE");
		b2.setBounds(600,550,100,25);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae24)
			{
				fname=t1.getText();
				lname=t2.getText();
				address=t3.getText();
				phone=t4.getText();
				date=ch1.getSelectedItem().toString();
				month=ch2.getSelectedItem().toString();
				year=ch3.getSelectedItem().toString();
				password=t5.getText();
				z=0;
				y=0;
				if(year=="YEAR") {
					JOptionPane.showMessageDialog(null, "Please select year");
					ch3.setBackground(Color.red);
					z++;
				} else {
					ch3.setBackground(Color.white);
//					ref++;
				}
				if(month=="MONTH") {
					JOptionPane.showMessageDialog(null, "Please select Month");
					ch2.setBackground(Color.red);
					z++;
				} else {
					ch2.setBackground(Color.white);
//					ref++;
				}
				if(date=="DATE") {
					JOptionPane.showMessageDialog(null, "Please select Date");
					ch1.setBackground(Color.red);
					z++;
				} else {
					ch1.setBackground(Color.white);
//					ref++;
				}
				if(Pattern.matches("[a-zA-Z]*$",fname)  )
				{
					t1.setBackground(Color.white);
//					ref++;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "First Name is mandatory");
					t1.setBackground(Color.red);
					z++;
					
				}
				if(Pattern.matches("[a-zA-Z]*$",lname)  )
				{
					t2.setBackground(Color.white);
//					ref++;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Last Name is mandatory");
					t2.setBackground(Color.red);
					z++;
				}
//				if(Pattern.matches("[a-zA-Z]*$",address)  )
//				{
//					t3.setBackground(Color.white);
//					ref++;
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null, "Address is mandatory");
//					t3.setBackground(Color.red);
//					z++;
//				}
				if(Pattern.matches("[a-zA-Z]*$",password)  )
				{
					t5.setBackground(Color.white);
//					ref++;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Password is mandatory");
					t5.setBackground(Color.red);
					z++;
				}
				if(Pattern.matches("[0-9]{10}", phone))
				{
					t4.setBackground(Color.white);
//					ref++;
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Enter mobile number correctly");
				t4.setBackground(Color.red);
				z++;
				}
				
				try {
					
					if(z==0)
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
					Statement stmt=con.createStatement();
					String query="insert into details(fname,lname,address,phone,dob,password)values(\""+fname +"\",\""+lname+"\",\""+address+"\",\""+phone+"\",\"" +year+"-"+month+"-"+date+"\",\""+password+"\")" ; 
					stmt.executeUpdate(query );
					con.close();
					JOptionPane.showMessageDialog(null,"Registered Successfully for"+fname);
					new Entry(rid);
					}
					else {
						y++;
//						JOptionPane.showMessageDialog(null,"Registration not successful Enter all the required fields");
						
					}
				}
					catch(Exception e10)
					{
						e10.printStackTrace();
						if(y!=0)
						JOptionPane.showMessageDialog(null,"Registration not successful Enter all the required fields");

					}	

					
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
					String query="select id from details where fname=\""+fname+"\" and password=\""+password+"\"";
					PreparedStatement stmt=con.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					
					while(rs.next())
					{
						rid=rs.getString("id");
						
					}
					JOptionPane.showMessageDialog(null, "Login Success");
//					new Entry(rid);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Account not found");
				}
				
					
				
				}
				
			});
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent wee)
			{
				dispose();
			}
		});
		setSize(1000,1000);
		setBackground(Color.gray);
		setVisible(true);
		setResizable(true);
		}
}
