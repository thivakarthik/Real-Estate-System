package realestateproject;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RentLand extends Frame{
	
	JComboBox l1;
	JButton b1,b2;
	JTextField t1;
	int count;
	String cost,selected;
	String lmark;
	int ref;
	Label l2,l3;
	RentLand(String city)
	{
setLayout(null);
		
l1=new JComboBox();
l1.setBounds(350,100,300,25);
add(l1);
		l2=new Label("SELECT THE LAND MARK");
		l2.setBounds(120,50,300,25);
		add(l2);
		l2.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		l3=new Label("LAND MARK");
		l3.setBounds(100,100,150,25);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(100,350,100,25);
//		add(t1);
		b1=new JButton("GET DETAILS");
		b1.setBounds(350,200,150,25);
		add(b1);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
			String query="select count(refid) as \"count\" from rentdetails where city=\""+city+"\"";
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				count=rs.getInt("count");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"No landmark found ");
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
			String query="select lmark,refid from rentdetails where city=\""+city+"\"";
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs1=stmt.executeQuery();
			for(int m=0;m<count;m++)
			{
			while(rs1.next())
			{
				
					String lmark=rs1.getString("lmark");
					String refid=rs1.getString("refid");
					l1.addItem(lmark+"("+refid+")");
//					l1.add(refid);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null,"No Properties added ");
		}
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aee34)
			{
				ref=0;
				lmark="";
				selected=l1.getSelectedItem().toString();
				for(int i=0;i<selected.length();i++)
				{
					if ( ((selected.charAt(i)>='a') && (selected.charAt(i)<='z')) || ((selected.charAt(i)>='A') && (selected.charAt(i)<='Z')) )
					{
						lmark=lmark+selected.charAt(i);
					}
					else if(selected.charAt(i)=='(')
					{
						ref=Character.getNumericValue(selected.charAt(i+1));
						 if(Character.getNumericValue(selected.charAt(i+2))>=0 && Character.getNumericValue(selected.charAt(i+2))<=9)
							{
								 ref=(ref*10)+Character.getNumericValue(selected.charAt(i+2));
							}
					}
					else if(selected.charAt(i)==' ')
					{
						lmark=lmark+selected.charAt(i);
					}
				}
				new RentDetails(city,lmark,ref);
			}
		});
		b2=new JButton("BACK");
		b2.setBounds(100,200,100,25);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aeee)
			{
				dispose();
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we1)
			{
				dispose();
			}
		});
		

		setVisible(true);
		setResizable(true);
		setSize(1000,1000);
		setBackground(Color.gray);
		setFont(new Font("TimesNewRoman",Font.BOLD,13));
		
	}

}
