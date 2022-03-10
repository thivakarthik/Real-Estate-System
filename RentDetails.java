package realestateproject;

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

public class RentDetails extends Frame {
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	Label l12;
	JButton b1,b2;
	String rltype;
	String rbtype;
	String ratype;
	String racent;
	String rcity;
	String rmaxprice;
	String rlmark;
//	String rminprice;
	String rsname;
	String rsaddress;
	String rcontact;
	RentDetails(String city,String lmark,int refid)
	{
setLayout(null);
		
//		System.out.print(lmark);
//		System.out.println();
//		System.out.println(refid);
		

l12=new Label("DETAILS OF THE LAND");
l12.setBounds(300,50,225,25);
add(l12);
l12.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
//			String query="select * from sellerdetails where city=\""+city+"\" and lmark=\""+lmark+"\" and refid="+refid;
			String query="select * from rentdetails where lmark=\""+lmark+"\" and refid=\""+refid+"\"";
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				 rltype=rs.getString("ltype");
				 rbtype=rs.getString("btype");
				 ratype=rs.getString("atype");
			     racent=rs.getString("acent");
				 rcity=rs.getString("city");
				 rmaxprice=rs.getString("price");
				 rlmark=rs.getString("lmark");
//				 rminprice=rs.getString("minprice");
				 rsname=rs.getString("sname");
				 rsaddress=rs.getString("saddress");
				 rcontact=rs.getString("contact");
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"No id found ");
		}
		
		l1=new JLabel("LAND TYPE");
		l2=new JLabel("BUILDING TYPE");
		l3=new JLabel("AREA TYPE");
		l4=new JLabel("AREA (CENT)");
		l5=new JLabel("CITY");
		l6=new JLabel("PRICE AMOUNT YOU HAVE ADDED");
		l7=new JLabel("LAND MARK");
//		l8=new JLabel("MINPRICE");
		l9=new JLabel("SELLER's NAME");
		l10=new JLabel("ADDRESS ADDED BY YOU");
		l11=new JLabel("CONTACT");
		
		l1.setBounds(100,100,120,25);
		l2.setBounds(100,150,120,25);
		l3.setBounds(100,200,120,25);
		l4.setBounds(100,250,120,25);
		l5.setBounds(100,300,120,25);
		l6.setBounds(100,350,350,25);
		l7.setBounds(100,400,300,25);
//		l8.setBounds(100,450,100,25);
		l9.setBounds(100,450,120,25);
		l10.setBounds(100,500,350,25);
		l11.setBounds(100,550,120,25);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
//		add(l8);
		add(l9);
		add(l10);
		add(l11);
		
		t1=new TextField(""+rltype+"");
		t2=new TextField(""+rbtype+"");
		t3=new TextField(""+ratype+"");
		t4=new TextField(""+racent+"");
		t5=new TextField(""+rcity+"");
		t6=new TextField(""+rmaxprice+"");
		t7=new TextField(""+rlmark+"");
//		t8=new JTextField(""+rminprice+"");
		t9=new TextField(""+rsname+"");
		t10=new TextField(""+rsaddress+"");
		t11=new TextField(""+rcontact+"");
		
		t1.setBounds(450,100,200,25);
		t2.setBounds(450,150,200,25);
		t3.setBounds(450,200,200,25);
		t4.setBounds(450,250,200,25);
		t5.setBounds(450,300,200,25);
		t6.setBounds(450,350,200,25);
		t7.setBounds(450,400,200,25);
//		t8.setBounds(200,450,200,25);
		t9.setBounds(450,450,200,25);
		t10.setBounds(450,500,200,25);
		t11.setBounds(450,550,200,25);
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
//		add(t8);
		add(t9);
		add(t10);
		add(t11);
		
//		t1.disable();
//		t2.disable();
//		t3.disable();
//		t4.disable();
//		t5.disable();
//		t6.disable();
//		t7.disable();
////		t8.disable();
//		t9.disable();
//		t10.disable();
//		t11.disable();
		
		b1=new JButton("OK");
		b1.setBounds(400,650,100,25);
		add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aee2)
			{
				dispose();
			}
		});
		
		b2=new JButton("BACK");
		b2.setBounds(250,650,100,25);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a)
			{
				dispose();
			}
		});
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});

//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent we1)
//			{
//				dispose();
//			}
//		/
		setBackground(Color.gray);
		setSize(1000,1000);
		setResizable(true);
		setVisible(true);
		setFont(new Font("TimesNewRoman", Font.BOLD, 13));
	}

}
