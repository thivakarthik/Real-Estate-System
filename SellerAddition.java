package realestateproject;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SellerAddition extends Frame{
	 Label l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l1;
	 JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	 JComboBox c1;
	 JComboBox cb1,cb2,cb3;
	 JButton b,b1;
	 String btype="";

	SellerAddition(String id)
	{
		
		setLayout(null);
		
		l1=new Label("PROPERTY DETAILS");
		l1.setBounds(400,100,250,25);
		add(l1);
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		l2=new Label("LAND TYPE");
        l3=new Label("BUILDING TYPE");
        l4=new Label("AREA TYPE");
        l5=new Label("AREA(CENT)");
        l6=new Label("CITY");
        l7=new Label("LAND MARK");
        l8=new Label("PRICE AMOUNT OF THE LAND YOU SALE");
//        l9=new JLabel("MINIMUM PRICE");
        l10=new Label("SELLER's NAME");
        l11=new Label("ADDRESS OF THE LAND YOU SALE");
        l12=new Label("CONTACT NO"); 
        
        l2.setBounds(100, 150, 120, 25);
        l3.setBounds(100, 200, 120, 25);
        l4.setBounds(100, 250, 120, 25);
        l5.setBounds(100, 300, 120, 25);
        l6.setBounds(100, 350, 120, 25);
        l7.setBounds(100, 400, 120, 25);
        l8.setBounds(100, 450, 350, 25);
//        l9.setBounds(100, 500, 120, 25);
        l10.setBounds(100, 500, 120, 25);
        l11.setBounds(100, 550, 350, 25);
        l12.setBounds(100, 600, 120, 25);
        
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
//        add(l9);
        add(l10);
        add(l11);
        add(l12);
        
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
//        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();
        
        t2.setBounds(450, 300, 200, 25);
        t3.setBounds(450, 400, 200, 25);
        t4.setBounds(450, 450, 200, 25);
//        t5.setBounds(300, 500, 200, 25);
        t6.setBounds(450, 500, 200, 25);
        t7.setBounds(450, 550, 200, 25);
        t8.setBounds(450, 600, 200, 25);
        
        add(t2);
        add(t3);
        add(t4);
//        add(t5);
        add(t6);
        add(t7);
        add(t8);
        
       c1=new JComboBox();
       c1.addItem("FLATS");
       c1.addItem("BUNGALOW");
       c1.setBounds(450, 200, 120, 25);
       add(c1);
       
       cb1=new JComboBox();
       cb1.addItem("--SELECT--");
       cb1.addItem("COIMBATORE");
       cb1.addItem("CHENNAI");
       cb1.addItem("SALEM");
       cb1.addItem("BANGALORE");
       cb1.addItem("OOTY");
       cb1.addItem("TRICHY");
       cb1.setBounds(450, 350, 120, 25);
       add(cb1);
       
       cb2=new JComboBox();
       cb2.addItem("--SELECT--");
       cb2.addItem("PLOT");
       cb2.addItem("BUILT");
       cb2.addItem("SEMI-BUILT");
       cb2.setBounds(450, 150, 120, 25);
       add(cb2);

       cb3=new JComboBox();
       cb3.addItem("--SELECT--");
       cb3.addItem("RESIDENTIAL");
       cb3.addItem("COMMERCIAL");
       cb3.addItem("INDUSTRIAL");
       cb3.setBounds(450, 250, 120, 25);
       add(cb3);
       
       b=new JButton("SUBMIT");
       b.setBounds(200, 700, 80, 25);
       add(b);
       b.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ae45)
    	   {
    		   btype=c1.getSelectedItem().toString();
    		   int y=0;
               int z=0;
               String acent=t2.getText();
               String city=cb1.getSelectedItem().toString();
               String ltype=cb2.getSelectedItem().toString();
               String atype=cb3.getSelectedItem().toString(); 
               String lmark=t3.getText();
               String price=t4.getText();
//               String minprice=t5.getText();
               String sname=t6.getText();
               String saddress=t7.getText();
               String contact=t8.getText();
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
                   t2.setBackground(Color.white);
                   
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Please fill the Area(cent) correctly");
                   t2.setBackground(Color.green);
                   z++;
               }              
               if(Pattern.matches("[0-9]*$", price))
               {
                   t4.setBackground(Color.white);
                   
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Please enter Maximum Price correctly");
                   t4.setBackground(Color.green);
                   z++;
               }
//               if(Pattern.matches("[0-9]*$", minprice))
//               {
//                   t5.setBackground(Color.white);
//                 
//               }
//               else
//               {
//                   JOptionPane.showMessageDialog(null, "Please fill the Minimum price correctly");
//                   t5.setBackground(Color.green);
//                   z++;
//               }
               if(Pattern.matches("[a-zA-Z]*$", sname))
               {
                   t6.setBackground(Color.white);
                 
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Please fill the Purchaser's Name correctly");
                   t6.setBackground(Color.green);
                   z++;
               }
               if(Pattern.matches("[0-9]{10}", contact))
               {
                   t8.setBackground(Color.white);
                
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Please fill the vaild contact number");
                   t8.setBackground(Color.green);
                   z++;
               }
               try{
                   if(z==0)
                   {

                   	Class.forName("com.mysql.cj.jdbc.Driver");
                   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","root");
                   	Statement stmt=con.createStatement();
                   	String query="insert into sellerdetails(id,ltype,btype,atype,acent,city,lmark,maxprice,sname,saddress,contact) values('"+id+"','"+ltype+"','"+btype+"','"+atype+"','"+acent+"','"+city+"','"+lmark+"','"+price+"','"+sname+"','"+saddress+"','"+contact+"')";
                   	stmt.executeUpdate(query );
                   	con.close();
                    JOptionPane.showMessageDialog(null, "Registration Success!");
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
       
       b1=new JButton("BACK");
       b1.setBounds(400, 700, 80, 25);
       add(b1);
       b1.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ae34)
    	   {
    		   dispose();
    	   }
       });
     
        
        
       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e)
           {
               System.exit(0);
           }
       });
        setBackground(Color.gray);
        setVisible(true);
        setResizable(true);
        setSize(1000,1000);
        setFont(new Font("TimesNewRoman",Font.BOLD,12));

	}

}
