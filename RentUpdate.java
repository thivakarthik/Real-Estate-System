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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RentUpdate extends Frame {

	int i;
	int z=0;
	JComboBox l;
	int count=0;
	JTextField t1;
	JLabel l1;
	Label l2;
	JButton b1,b2;
	String text;
	String selected="";
	String lmark;
	int ref;
	RentUpdate(String id)
	{
		setLayout(null);
		l=new JComboBox();
		l.setBounds(400,250,200,30);
		add(l);
		
		 
		
		l1=new JLabel("SELECT THE LAND MARK");
		l1.setBounds(200,250,200,25);
		add(l1);
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,12));
		
		l2=new Label("UDPATE PROPERTY");
		l2.setBounds(400,100,200,25);
		add(l2);
		l2.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		t1=new JTextField();
		t1.setBounds(100,300,150,25);
//		add(t1);
		
		b1=new JButton("SEARCH");
		b1.setBounds(400,350,100,25);
		add(b1);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
			String query="select count(refid) as \"count\" from rentdetails where id=\""+id+"\"";
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				count=rs.getInt("count");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"No id found ");
		}
//		System.out.print(count);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
				String query="select lmark,refid from rentdetails where id=\""+id+"\"";
				PreparedStatement stmt=con.prepareStatement(query);
				ResultSet rs1=stmt.executeQuery();
				for(int m=0;m<count;m++)
				{
				while(rs1.next())
				{
					
						String rlmark=rs1.getString("lmark");
						String refid=rs1.getString("refid");
						l.addItem(rlmark+'('+refid+')');
//						rlmark=rs.getString("lmark");
//						rmaxprice=rs.getString("maxprice");
//						l.add("rlmark");
//						l.add("rmaxprice");
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"No Properties added ");
			}
			
			
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent aee)
				{
					ref=0;
					lmark="";
					selected=l.getSelectedItem().toString();
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

					new RentUpdate2(lmark,id,ref);
				}
			});
			
			b2=new JButton("BACK");
			b2.setBounds(200,350,100,25);
			add(b2);
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent aee)
				{
					dispose();
				}
			});
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we45)
				{
					dispose();
				}
			});
			setBackground(Color.gray);
			setVisible(true);
			setResizable(true);
			setSize(1000,1000);
			
	}
}
