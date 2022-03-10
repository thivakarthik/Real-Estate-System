package realestateproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SellerAdd2 extends Frame implements ItemListener{
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	    ButtonGroup bg;
	    JRadioButton r1,r2;
	    JComboBox cb1,cb2,cb3,cb4;
	    JButton b,b1;
//	    Container co;
	    String btype="";
	
	
	SellerAdd2(String id)
	{
//		co=getContentPane();
	       System.out.print(id);
	       
	        l1=new JLabel("Seller's Id");
	        l2=new JLabel("Land Type");
	        l3=new JLabel("Building Type");
	        l4=new JLabel("Area Type");
	        l5=new JLabel("Area(cent)");
	        l6=new JLabel("City");
	        l7=new JLabel("Land Mark");
	        l8=new JLabel("Maximum Price");
	        l9=new JLabel("Minimum Price");
	        l10=new JLabel("Seller's Name");
	        l11=new JLabel("Seller's Address");
	        l12=new JLabel("Contact no");      
	        t1=new JTextField();
	        t2=new JTextField();
	        t3=new JTextField();
	        t4=new JTextField();
	        t5=new JTextField();
	        t6=new JTextField();
	        t7=new JTextField();
	        t8=new JTextField();
	       

	        bg=new ButtonGroup();

	        r1=new JRadioButton("Flats");
	        r2=new JRadioButton("Banglow");
	       
	        bg.add(r1);
	        bg.add(r2);
	        
	        cb1=new JComboBox();

	        cb1.addItem("--Select--");
	        cb1.addItem("Coimbatore");
	        cb1.addItem("Chennai");
	        cb1.addItem("Salem");
	        cb1.addItem("Bangalore");
	        cb1.addItem("Ooty");
	        cb1.addItem("Trichy");
	       
	        cb2=new JComboBox();

	        cb2.addItem("--Select--");
	        cb2.addItem("Plot");
	        cb2.addItem("Built");
	        cb2.addItem("Semi-Built");
	       
	        cb3=new JComboBox();
	        cb3.addItem("--Select--");
	        cb3.addItem("Residential");
	        cb3.addItem("Commertial");
	        cb3.addItem("Industrial");
	       
	             
	        b=new JButton("submit");
	        b1=new JButton("back");
	        
	        l1.setBounds(100, 100, 120, 25);
	        l2.setBounds(100, 150, 120, 25);
	        l3.setBounds(100, 200, 120, 25);
	        l4.setBounds(100, 250, 120, 25);
	        l5.setBounds(100, 300, 120, 25);
	        l6.setBounds(100, 350, 120, 25);
	        l7.setBounds(100, 400, 120, 25);
	        l8.setBounds(100, 450, 120, 25);
	        l9.setBounds(100, 500, 120, 25);
	        l10.setBounds(100, 550, 120, 25);
	        l11.setBounds(100, 600, 150, 25);
	        l12.setBounds(100, 650, 120, 25);

	        b.setBounds(100, 700, 80, 25);
	        b1.setBounds(200, 700, 80, 25);


	       
	        t1.setBounds(300, 100, 200, 25);
	        cb2.setBounds(300, 150, 120, 25);
	               
	        r1.setBounds(300, 200, 60, 25);
	        r2.setBounds(360, 200, 100, 25);
	        cb3.setBounds(300, 250, 120, 25);
	        t2.setBounds(300, 300, 200, 25);
	        cb1.setBounds(300, 350, 120, 25);
	       

	        t3.setBounds(300, 400, 200, 25);
	        t4.setBounds(300, 450, 200, 25);
	        t5.setBounds(300, 500, 200, 25);
	        t6.setBounds(300, 550, 200, 25);
	        t7.setBounds(300, 600, 200, 25);
	        t8.setBounds(300, 650, 200, 25);

	        add(l1);
	        add(l2);
	        add(l3);
	        add(l4);
	        add(l5);
	        add(l6);
	        add(l7);
	        add(l8);
	        add(l9);
	        add(l10);
	        add(l11);
	        add(l12);

	        add(b);
	        add(b1);

	       
	        add(t1);
	        add(t2);
	        add(r1);
	        add(r2);
	        add(cb1);
	        add(cb2);
	        add(cb3);
	        add(t3);
	        add(t4);
	        add(t5);
	        add(t6);
	        add(t7);
	        add(t8);
	        
	        setBackground(Color.cyan);
	        r1.setBackground(Color.cyan);
	        r2.setBackground(Color.cyan);   
	         bg.addItemListener(new ItemListener() {
	       	 public void itemStateChanged(ItemEvent ie){

	                ItemSelectable itemselected=ie.getItemSelectable();

	                if(itemselected==r1){
	                        btype="Flats";
	                }
	                else if(itemselected==r2){
	                        btype="Banglow";
	                }
	            }

	});

}
}
