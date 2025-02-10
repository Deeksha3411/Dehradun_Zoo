package com.pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class home extends JFrame  implements ActionListener
{
	JPanel jp1,jp2,jp3;
	Button b1,b2,b3,b4,b5,b6;
	JLabel jl1,jl2;
	
	home()	
	{
		jp1=new JPanel();
		jp1.setBackground(new Color(174, 214, 241 ));
		jp1.setBounds(0,0,1500,130);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		jl1=new JLabel("THE DEHRADUN ZOO");
		jl1.setFont(new Font("Tahoma",Font.BOLD,60));
		jl1.setForeground(Color.white);
		jp1.add(jl1);
		
		add(jp1);
		
		
		jp2=new JPanel();
		jp2.setBackground(new Color(174, 214, 241 ));
		jp2.setBounds(0,130,200,750);
		jp2.setLayout(null);
		
		b1=new Button("TICKETING");
		b1.addActionListener(this);
		b1.setBounds(10,20,180,50);
		
		b2=new Button("ANIMAL ");
		b2.addActionListener(this);
		b2.setBounds(10,75,180,50);
		
		
		b3=new Button("ANIMAL CATGORY");
		b3.addActionListener(this);
		b3.setBounds(10,135,180,50);
		
		b4=new Button("PURCHASE");
		b4.addActionListener(this);
		b4.setBounds(10,195,180,50);
		
		b5=new Button("STOCK");
		b5.addActionListener(this);
		b5.setBounds(10,255,180,50);
		
		b6=new Button("ADMIN");
		b6.addActionListener(this);
		b6.setBounds(10,315,180,50);
		
		jp2.add(b1);
		jp2.add(b2);
		jp2.add(b3);
		jp2.add(b4);
		jp2.add(b5);
		jp2.add(b6);
		
		add(jp1);
		add(jp2);
		
		jp3=new JPanel();
		jp3.setBackground(Color.white);
		jp3.setBounds(200,130,1300,750);
		jp3.setLayout(null);
		
		add(jp3);
		
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
			new ticket();
		
		if(ae.getSource()==b2)
			new addanimal();
		
		if(ae.getSource()==b3)
			new addcategory();
		
		if(ae.getSource()==b4)
			new purchase();
		
		if(ae.getSource()==b5)
			new animalstock();
		
		if(ae.getSource()==b6)
			new revenue();
		
		
		
	}
	
	public static void main(String[] args) 
	{
		 new home();
	}		
}
	

