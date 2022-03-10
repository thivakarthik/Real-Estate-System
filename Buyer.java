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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Buyer extends Frame {

	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	String text;
	String type;
	JComboBox ch;
	Label l3;
	Buyer(String id)
	{
		setLayout(null);
		
		l3=new Label("SELECT THE PROPERTY TYPE AND CITY");
		l3.setBounds(120,50,300,25);
		add(l3);
		l3.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		l2=new JLabel("Choose the type");
		l2.setBounds(100,100,100,25);
		add(l2);
		ch=new JComboBox();
		ch.addItem("RENT");
		ch.addItem("BUY");
		
		ch.setBounds(300,100,200,25);
		add(ch);
		
		l1=new JLabel("ENTER THE CITY");
		l1.setBounds(100,200,200,25);
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(300,200,200,25);
		add(t1);
		
//		Icon icon=new ImageIcon("C:/Users/Dhiva/Pictures/search.png");
		b1=new JButton("SEARCH");
		b1.setBounds(400,260,100,25);
		add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aee1)
			{
				text=t1.getText();
				
				type=ch.getSelectedItem().toString();
				if(type=="BUY")
				{
					new BuyerLand(text);
				}
				else if(type=="RENT")
				{
					new RentLand(text);
				}
				
			}
		});
		
		b2=new JButton("BACK");
		b2.setBounds(200,260,100,25);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aeee)
			{
				dispose();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent wee34)
			{
				dispose();
			}
		});
		
		setBackground(Color.gray);
		setVisible(true);
		setResizable(true);
		setSize(1000,1000);
		setFont(new Font("TimesNewRoman",Font.BOLD,13));
	}
}
