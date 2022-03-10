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
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RentUpdate2 extends Frame {
	
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
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
	JComboBox cb1,cb2,cb3,c1;
	String btype="";
	RentUpdate2(String lmark,String id,int refid)
	{
setLayout(null);
		
l12=new Label("CHECK THE DETAILS");
l12.setBounds(300,50,225,25);
add(l12);
l12.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
			String query="select * from rentdetails where id=\""+id+"\" and lmark=\""+lmark+"\" and refid=\""+refid+"\"";
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
//		 cb3=new Choice();
//	       cb3.add("--Select--");
//	       cb3.add("Residential");
//	       cb3.add("Commertial");
//	       cb3.add("Industrial");
//	       cb3.setBounds(100, 200, 10, 25);
//	       add(cb3);
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
		
//		t1=new JTextField(""+rltype+"");
		cb2=new JComboBox();
//	       cb2.add("--Select--");
		cb2.addItem(rltype);
		if(rltype=="PLOT")
		{
			
		}
		else
		{
	       cb2.addItem("PLOT");
		}
		if(rltype=="BUILT")
		{
			
		}
		else
		{
			cb2.addItem("BUILT");
		}
		if(rltype=="SEMI-BUILT")
		{
			
		}
		else
		{
	       cb2.addItem("SEMI-BUILT");
		}
		cb2.setBounds(450,100,200,25);
	       add(cb2);
//		t2=new JTextField(""+rbtype+"");
	       c1=new JComboBox();
	       c1.addItem(rbtype);
	       if(rbtype=="FLATS")
	       {
	    	   
	       }
	       else
	       {
	    	   c1.addItem("FLATS");
	       }
	      if(rbtype=="BUNGALOW")
	      {
	    	  
	      }
	      else
	      {
	       c1.addItem("BUNGALOW");
	      }
	      c1.setBounds(450,150,200,25);
	       add(c1);
//		t3=new JTextField(""+ratype+"");
		 cb3=new JComboBox();
//	       cb3.add("--Select--");
		 cb3.addItem(ratype);
		 if(ratype=="RESIDENTIAL")
		 {
			 
		 }
		 else
		 {
	       cb3.addItem("RESIDENTIAL");
		 }
		 if(ratype=="COMMERCIAL")
		 {
			 
		 }
		 else
		 {
	       cb3.addItem("COMMERCIAL");
		 }
		 if(ratype=="INDUSTRIAL")
		 {
			 
		 }
		 else
		 {
	       cb3.addItem("INDUSTRIAL");
		 }
		 cb3.setBounds(450,200,200,25);
	       add(cb3);
		t4=new JTextField(""+racent+"");
//		t5=new JTextField(""+rcity+"");
		cb1=new JComboBox();
//	       cb1.add("--Select--");
		cb1.addItem(rcity);
		if(rcity=="COIMBATORE")
		{
			
		}
		else
		{
	       cb1.addItem("COIMBATORE");
		}
		if(rcity=="CHENNAI")
		{
			
		}
		else
		{
	       cb1.addItem("CHENNAI");
		}
		if(rcity=="SALEM")
		{
			
		}
		else
		{
	       cb1.addItem("SALEM");
		}
		if(rcity=="BANGALORE")
		{
			
		}
		else
		{
	       cb1.addItem("BANGALORE");
		}
		if(rcity=="OOTY")
		{
			
		}
		else
		{
	       cb1.addItem("OOTY");
		}
		if(rcity=="TRICHY")
		{
			
		}
		else
		{
	       cb1.addItem("TRICHY");
		}
		cb1.setBounds(450,300,200,25);
	       add(cb1);
		t6=new JTextField(""+rmaxprice+"");
		t7=new JTextField(""+rlmark+"");
//		t8=new JTextField(""+rminprice+"");
		t9=new JTextField(""+rsname+"");
		t10=new JTextField(""+rsaddress+"");
		t11=new JTextField(""+rcontact+"");
		
//		t1.setBounds(200,100,100,25);
//		t2.setBounds(200,150,100,25);
//		t3.setBounds(200,200,100,25);
		t4.setBounds(450,250,200,25);
//		t5.setBounds(200,300,100,25);
		t6.setBounds(450,350,200,25);
		t7.setBounds(450,400,200,25);
		t7.disable();
//		t8.setBounds(200,450,100,25);
		t9.setBounds(450,450,200,25);
		t10.setBounds(450,500,200,25);
		t11.setBounds(450,550,200,25);
		
//		add(t1);
//		add(t2);
//		add(t3);
		add(t4);
//		add(t5);
		add(t6);
		add(t7);
//		add(t8);
		add(t9);
		add(t10);
		add(t11);
		
		b1=new JButton("UPDATE");
		b1.setBounds(400,650,100,25);
		add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aee2)
			{
				 btype=c1.getSelectedItem().toString();
	    		   int y=0;
	               int z=0;
	               String acent=t4.getText();
	               String city=cb1.getSelectedItem().toString();
	               String ltype=cb2.getSelectedItem().toString();
	               String atype=cb3.getSelectedItem().toString(); 
//	               String lmark=t7.getText();
	               String maxprice=t6.getText();
//	               String minprice=t8.getText();
	               String sname=t9.getText();
	               String saddress=t10.getText();
	               String contact=t11.getText();
	               
	               
	               if(btype=="--SELECT--")
	               {
	                   JOptionPane.showMessageDialog(null, "Please select Building Type");
	                   c1.setBackground(Color.green);
	                   z++;
	               }
	               else
	               {
	                   c1.setBackground(Color.white);
	             
	               }
//	               
//	               if(lmark==null)
//	               {
//	            	   JOptionPane.showMessageDialog(null,"Please enter landmark");
//	            	   t7.setBackground(Color.green);
//	            	   z++;
//	               }
//	               else
//	               {
//	            	   t7.setBackground(Color.white);
//	               }
	               
	               
	               if(atype=="--SELECT--")
	               {
	                   JOptionPane.showMessageDialog(null, "Please select Area Type");
	                   cb3.setBackground(Color.green);
	                   z++;
	               }
	               else
	               {
	                   cb3.setBackground(Color.white);
	             
	               }
	               if(ltype=="--SELECT--")
	               {
	                   JOptionPane.showMessageDialog(null, "Please select Land Type");
	                   cb2.setBackground(Color.green);
	                   z++;
	               }
	               else
	               {
	                   cb2.setBackground(Color.white);
	                 
	               }
	               if(city=="--SELECT--")
	               {
	                   JOptionPane.showMessageDialog(null, "Please select city");
	                   cb1.setBackground(Color.green);
	                   z++;
	               }
	               else
	               {
	                   cb1.setBackground(Color.white);
	                  
	               }
	              
	               if(c1==null)
	               {
	                   JOptionPane.showMessageDialog(null, "Please select Building Type");
	                   z++;
	               }
	               else
	               {
	            	 
	               }
	               if(Pattern.matches("[0-9]*$", acent))
	               {
	                   t4.setBackground(Color.white);
	                   
	               }
	               else
	               {
	                   JOptionPane.showMessageDialog(null, "Please fill the Area(cent) correctly");
	                   t4.setBackground(Color.green);
	                   z++;
	               }              
	               if(Pattern.matches("[0-9]*$", maxprice))
	               {
	                   t6.setBackground(Color.white);
	                   
	               }
	               else
	               {
	                   JOptionPane.showMessageDialog(null, "Please enter Maximum Price correctly");
	                   t6.setBackground(Color.green);
	                   z++;
	               }
//	               if(Pattern.matches("[0-9]*$", minprice))
//	               {
//	                   t8.setBackground(Color.white);
//	                 
//	               }
//	               else
//	               {
//	                   JOptionPane.showMessageDialog(null, "Please fill the Minimum price correctly");
//	                   t8.setBackground(Color.green);
//	                   z++;
//	               }
	               if(Pattern.matches("[a-zA-Z]*$", sname))
	               {
	                   t9.setBackground(Color.white);
	                 
	               }
	               else
	               {
	                   JOptionPane.showMessageDialog(null, "Please fill the Purchaser's Name correctly");
	                   t9.setBackground(Color.green);
	                   z++;
	               }
	               if(Pattern.matches("[0-9]{10}", contact))
	               {
	                   t11.setBackground(Color.white);
	                
	               }
	               else
	               {
	                   JOptionPane.showMessageDialog(null, "Please fill the vaild contact number");
	                   t11.setBackground(Color.green);
	                   z++;
	               }
	               try{
	                   if(z==0)
	                   {

	                   	Class.forName("com.mysql.cj.jdbc.Driver");
	                   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
	                   	Statement stmt=con.createStatement();
	                   	String query="update rentdetails set ltype=\""+ltype+"\",btype=\""+btype+"\",atype=\""+atype+"\",acent=\""+acent+"\",city=\""+city+"\",price=\""+maxprice+"\",sname=\""+sname+"\",saddress=\""+saddress+"\",contact=\""+contact+"\" where id=" +id+" and lmark=\""+lmark+"\" and refid=\""+refid+"\"" ;
	                   	stmt.executeUpdate(query );
	                   	con.close();
	                    JOptionPane.showMessageDialog(null, "Updation Success!");
	                   }
	                   else
	                   {
	                       y++;
	                       JOptionPane.showMessageDialog(null, "Please enter all the required fields correctly");
	                   }


	               }
	               catch(Exception ex){
	               	ex.printStackTrace();
	               JOptionPane.showMessageDialog(null, "Not Added Successfully");
	           }
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
		setSize(1000,1000);
		setBackground(Color.gray);
		setVisible(true);
		setResizable(true);
	}

}
