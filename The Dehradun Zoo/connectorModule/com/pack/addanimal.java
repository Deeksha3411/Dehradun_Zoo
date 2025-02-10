package com.pack;


import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.table.*;
import java.awt.*;

class addanimal extends JFrame implements ActionListener, ItemListener
{
	
	JLabel jl1,jl2,jl3,jl4;
	JTextField jf1,jf2;
	JButton b1,b2,b3,b4;
	JCheckBox jx1;
	
	JTable jt1;
	DefaultTableModel dtm;
	JScrollPane jsp;
	
	
	JComboBox jc1;
    String cat[]=new String[5];
    String catid[]=new String[5];
    int i=0;
	
	
	addanimal()
	{
		
		jl1=new JLabel("ADD ANIMAL");
		jl1.setFont(new Font("Tahoma",Font.BOLD,20));
		jl1.setBounds(100,50,300,40);
		
		
		
		jl2=new JLabel("Animal Name");
		jl2.setFont(new Font("Tahoma",Font.BOLD,15));
		jl2.setBounds(50,110,130,20);
		jf1=new JTextField(20);
		jf1.setFont(new Font("Tahoma",Font.BOLD,15));
		jf1.setBounds(190,110,130,20);
		
		
		dtm=new DefaultTableModel();
		jt1=new JTable(dtm);
		dtm.addColumn("SRid");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		
		
		
		jsp=new JScrollPane(jt1);
		jsp.setBounds(350,110,400,200);
		
		
		
		
		jl3=new JLabel("Category");
		jl3.setFont(new Font("Tahoma",Font.BOLD,15));
		jl3.setBounds(50,150,130,20);
		
		
		display(); // filling values to the cat array 
		jc1=new JComboBox<String>(cat);
		jc1.setBounds(190,150,130,20);
		
		
		jx1=new JCheckBox("");
		jx1.setBounds(20,190,30,20);
		jx1.addItemListener(this);
		
		jl4=new JLabel("Ca id");
		jl4.setFont(new Font("Tahoma",Font.BOLD,15));
		jl4.setBounds(50,190,100,20);
		
		jf2=new JTextField(20);
		jf2.setFont(new Font("Tahoma",Font.BOLD,15));
		jf2.setBounds(190,190,130,20);
		
		
		b1=new JButton("ADD");
		b1.addActionListener(this);
		b1.setBounds(50,240,90,35);
		
		b2=new JButton("RESET");
		b2.addActionListener(this);
		b2.setBounds(150,240,90,35);
		
		
		b3=new JButton("DELETE");
		b3.addActionListener(this);
		b3.setBounds(50,290,90,35);
		
		b4=new JButton("UPDATE");
		b4.addActionListener(this);
		b4.setBounds(150,290,90,35);
		
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jx1);
		add(jf1);
		add(jf2);
		add(jc1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(jsp);
		
		
		fillAnimal();

		
		setSize(900,500);
		setLayout(null);
		setVisible(true);
	}
	
	
	
	void fillAnimal()
	{
		dtm.setNumRows(0);
	   	String query="select aid,aname,cat from animal inner join ani_cat on animal.id=ani_cat.id order by aid";
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
			System.out.print("Connection Established ");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				Object col[]=new Object[3];
				col[0]=rs.getString("aid");
				col[1]=rs.getString("aname");
				col[2]=rs.getString("cat");
				
				
				dtm.addRow(col);
			}
			
			
			con.close(); 
		}catch(Exception e1){ System.out.println(e1);} 
	}
	
	
	void display()
	{
		String query="select * from ani_cat";
		i=0;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
			System.out.print("Connection Established ");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				catid[i]=rs.getString("id");
				cat[i]=rs.getString("cat");
				i++;
			}
			
			con.close(); 
		}catch(Exception e){ System.out.println(e);}  
	}
	
	
	
	
	
    public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String name=jf1.getText();
			String id=catid[jc1.getSelectedIndex()];
			
			System.out.println(name);
			System.out.println(id);
			

		
			String query="insert into animal(aname,id) values('"+name+"',"+id+")";
			System.out.println(query);
			
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
				//System.out.print("Connection Established ");
				Statement st=con.createStatement();
				st.executeUpdate(query);
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);}
			
			fillAnimal();
		}
		
		
		if(ae.getSource()==b3)
		{
			
			String b="0";
			String query="delete from animal where cat = "+b;
				
				try
				{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
					System.out.print("Connection Established ");
					Statement st=con.createStatement();
					st.executeUpdate(query);
					con.close(); 
				}catch(Exception e1){ System.out.println(e1);}
			
		}
		
		
		if(ae.getSource()==b4)
		{
			 String a=jf1.getText();
             String b=jf2.getText();
             
             
		   	String query="update animal set aname='"+a+"' where aid="+b;
		   	System.out.println(query);
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				st.executeUpdate(query);
				
				
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);}  
			fillAnimal();
		}
		
		
		
	}
    
    public void itemStateChanged(ItemEvent ie)
    {
    	if(ie.getSource()==jx1)
    	{
    		if(jx1.isSelected()==true)
    		{
    			jf2.setVisible(false);
    			jl4.setVisible(false);
    			b3.setEnabled(true);
    			b4.setEnabled(true);
    			b1.setEnabled(false);
    			b2.setEnabled(false);
    			
    		}
    		else
    		{
    			jf2.setVisible(true);
    			jl4.setVisible(true);
    			b3.setEnabled(false);
    			b4.setEnabled(false);
    			b1.setEnabled(true);
    			b2.setEnabled(true);
    		}
    		
    	}
    }
		
	
	public static void main(String [] ar)
	{
		new addanimal();
	}
}
		
