package realestateproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

class Rent extends Frame
{
	JButton b1,b2,b3,b4,b5;
	JLabel l1;
	Rent(String id)
	{
		setLayout(null);
		l1=new JLabel("RENT PAGE");
		l1.setBounds(435,100,550,55);
		add(l1);
		l1.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
		
		b1=new JButton("ADD PROPERTY");
		b1.setBounds(350,200,300,55);
		add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aee1)
			{
				new AddRent(id);
			}
		});
		b2=new JButton("UPDATE PROPERTY");
		b2.setBounds(350,300,300,55);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aeee3)
			{
				new RentUpdate(id);
			}
		});
		b3=new JButton("DELETE PROPERTY");
		b3.setBounds(350,400,300,55);
		add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aeee)
			{
				new RentDelete(id);
			}
		});
		b4=new JButton("VIEW PROPERTY");
		b4.setBounds(350,500,300,55);
		add(b4);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aeee2)
			{
				new RentView(id);
			}
		});
		b5=new JButton("BACK");
		b5.setBounds(450,650,100,35);
		add(b5);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae5)
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
		
		setSize(1000,1000);
		setResizable(true);
		setVisible(true);
		setBackground(Color.gray);
	}
}