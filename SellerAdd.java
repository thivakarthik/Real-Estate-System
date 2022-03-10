package realestateproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;


public class SellerAdd extends JFrame implements ActionListener,ItemListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    ButtonGroup bg;
    JRadioButton r1,r2;
    JComboBox cb1,cb2,cb3,cb4;
    JButton b,b1;
    Container co;
    String btype="";
    String id;

    public SellerAdd(String id){

        co=getContentPane();
//       System.out.print(id);
       
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
        t1.disable();
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


       
        co.add(l1);
        co.add(l2);
        co.add(l3);
        co.add(l4);
        co.add(l5);
        co.add(l6);
        co.add(l7);
        co.add(l8);
        co.add(l9);
        co.add(l10);
        co.add(l11);
        co.add(l12);

        co.add(b);
        co.add(b1);

       
        co.add(t1);
        co.add(t2);
        co.add(r1);
        co.add(r2);
        co.add(cb1);
        co.add(cb2);
        co.add(cb3);
        co.add(t3);
        co.add(t4);
        co.add(t5);
        co.add(t6);
        co.add(t7);
        co.add(t8);
        
        co.setBackground(Color.cyan);
        r1.setBackground(Color.cyan);
        r2.setBackground(Color.cyan);   
        
        setLayout(null);
        setFont(new Font("Times New Roman ", Font.BOLD, 12));
        setSize(900, 900);
        setVisible(true);
         
       
    }

    @Override
    public void itemStateChanged(ItemEvent ie){

        ItemSelectable itemselected=ie.getItemSelectable();

        if(itemselected==r1){
                btype="Flats";
        }
        else if(itemselected==r2){
                btype="Banglow";
        }
    }
  
    public void actionPerformed(ActionEvent e){

        Object obj=e.getSource();

        if(obj==b){
            int y=0;
            int z=0;
            String sid=t1.getText();
            String acent=t2.getText();
            String city=cb1.getSelectedItem().toString();
            String ltype=cb2.getSelectedItem().toString();
            String atype=cb3.getSelectedItem().toString();      
            String lmark=t3.getText();
            String maxprice=t4.getText();
            String minprice=t5.getText();
            String sname=t6.getText();
            String saddress=t7.getText();
            String contact=t8.getText();
            
            System.out.print(acent);
            System.out.print(city);
            System.out.print(ltype);
            System.out.print(atype);
            System.out.print(lmark);
            System.out.print(maxprice);
            System.out.print(minprice);
            System.out.print(sname);
            System.out.print(saddress);
            System.out.print(contact);
            if(atype=="--Select--")
                {
                    JOptionPane.showMessageDialog(null, "Please select Area Type");
                    cb3.setBackground(Color.green);
                    z++;
                }
                else
                {
                    cb3.setBackground(Color.white);
                }
                if(ltype=="--Select--")
                {
                    JOptionPane.showMessageDialog(null, "Please select Land Type");
                    cb2.setBackground(Color.green);
                    z++;
                }
                else
                {
                    cb2.setBackground(Color.white);
                }
                if(city=="--Select--")
                {
                    JOptionPane.showMessageDialog(null, "Please select city");
                    cb1.setBackground(Color.green);
                    z++;
                }
                else
                {
                    cb1.setBackground(Color.white);
                }
               
                if(r1==null&&r2==null)
                {
                    JOptionPane.showMessageDialog(null, "Please select Building Type");
                    z++;
                }
               
               
//                if(Pattern.matches("[0-9]{6}", sid))
//                {
//                    t1.setBackground(Color.white);
//                }
//                else
//                {
//                    JOptionPane.showMessageDialog(null, "Please fill the Purchase Id correctly");
//                    t1.setBackground(Color.green);
//                    z++;
//                }
                if(Pattern.matches("[0-9]{2}", acent))
                {
                    t2.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Area(cent) correctly");
                    t2.setBackground(Color.green);
                    z++;
                }              
                if(Pattern.matches("[0-9]*$", maxprice))
                {
                    t4.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter Maximum Price correctly");
                    t4.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[0-9]*$", minprice))
                {
                    t5.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Minimum price correctly");
                    t5.setBackground(Color.green);
                    z++;
                }
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
                    	String query="insert into sellerdetails(id,ltype,btype,atype,acent,city,lmark,maxprice,minprice,sname,saddress,contact) values('"+id+"','"+ltype+"','"+btype+"','"+atype+"','"+acent+"','"+city+"','"+lmark+"','"+maxprice+"','"+minprice+"','"+sname+"','"+saddress+"','"+contact+"')";
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
                JOptionPane.showMessageDialog(this, ex.toString());
            }

        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
       
    }

//    public static void main(String args[]){
//        new SellerAdd();
//    }
}
