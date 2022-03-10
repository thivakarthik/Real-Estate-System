package realestateproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//import realestateproject.RealEstate.Rent;
//import realestateproject.RealEstate.Seller;

class Entry extends Frame
{
	JButton b1,b2,b3,b4;
	JButton b7;
	Label l1;
	Entry(String id)
	{
		setLayout(null);
		l1=new Label("WELCOME TO REAL ESTATE HOME PAGE");
		l1.setBounds(300,100,550,25);
		add(l1);
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		Icon icon2=new ImageIcon("C:/Users/Dhiva/Pictures/buy.jpg");
		b1=new JButton(icon2);
		b1.setBounds(400,200,200,100);
		add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aee2)
			{
				new Buyer(id);
			}
		});
		Icon icon = new ImageIcon("C:/Users/Dhiva/Pictures/selling.jpg");
		b2=new JButton(icon);
		b2.setBounds(400,310,200,100);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae2)
			{
				new Seller(id);
			}
		});
		
		Icon icon3=new ImageIcon("C:/Users/Dhiva/Pictures/rent final image.jpg");
		b3=new JButton(icon3);
		b3.setBounds(400,420,200,100);
		add(b3);
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae4)
			{
				new Rent(id);
			}
		});
		
		b4=new JButton("BACK");
		b4.setBounds(450,560,100,35);
		add(b4);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1)
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

		setBackground(Color.gray);
		setVisible(true);
		setResizable(true);
		setSize(1000,1000);
	}
}
