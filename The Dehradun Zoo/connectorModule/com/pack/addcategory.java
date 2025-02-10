package com.pack;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.table.*;


class addcategory extends JFrame implements ActionListener,ItemListener
{
	
	JLabel jl1,jl2,jl3;
	JTextField jf1,jf2;
	JButton b1,b2,b3,b4;
	JCheckBox jc1;
	
	JTable jt1;
	DefaultTableModel dtm;
	JScrollPane jsp;
	
	
	addcategory()
	{
		
		jl1=new JLabel("ADD ANIMAL CATEGORY");
		jl1.setFont(new Font("Tahoma",Font.BOLD,20));
		jl1.setBounds(100,50,400,40);
		
		
		
		jl2=new JLabel("Category");
		jl2.setFont(new Font("Tahoma",Font.BOLD,15));
		jl2.setBounds(50,110,100,20);
		jf1=new JTextField(20);
		jf1.setFont(new Font("Tahoma",Font.BOLD,15));
		jf1.setBounds(160,110,100,20);
		
		
		
		jc1=new JCheckBox("");
		jc1.setBounds(20,160,30,20);
		jc1.addItemListener(this);
		
		jl3=new JLabel("Ca id");
		jl3.setFont(new Font("Tahoma",Font.BOLD,15));
		jl3.setBounds(50,160,100,20);
		jl3.setVisible(false);
		
		jf2=new JTextField(20);
		jf2.setFont(new Font("Tahoma",Font.BOLD,15));
		jf2.setBounds(160,160,100,20);
		jf2.setVisible(false);
		
		
		
		
		
		
		
		dtm=new DefaultTableModel();
		jt1=new JTable(dtm);
		dtm.addColumn("SRid");
		dtm.addColumn("Animal Name");
		
		jsp=new JScrollPane(jt1);
		jsp.setBounds(300,110,400,200);
		
		b1=new JButton("ADD");
		b1.addActionListener(this);
	    b1.setFont(new Font("Tahoma",Font.PLAIN,13));
		b1.setBounds(50,210,90,35);
		
		b2=new JButton("RESET");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma",Font.PLAIN,13));
		b2.setBounds(150,210,90,35);
		
		
		b3=new JButton("DELETE");
		b3.addActionListener(this);
	    b3.setFont(new Font("Tahoma",Font.PLAIN,13));
		b3.setBounds(50,270,90,35);
		
		b4=new JButton("UPDATE");
		b4.addActionListener(this);
		b4.setFont(new Font("Tahoma",Font.PLAIN,13));
		b4.setBounds(150,270,90,35);
		
		
		
		
		
		add(jl1);
		add(jl2);
		add(jf1);
		add(jl3);
		add(jf2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(jc1);
		add(jsp);
		
		fillAnimal();
		
		setSize(800,500);
		setLayout(null);
		setVisible(true);
	}
	
	
	
	
	
	void fillAnimal()
	{
		dtm.setNumRows(0);
	   	String query="select * from ani_cat";
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
			System.out.print("Connection Established ");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				Object col[]=new Object[2];
				col[0]=rs.getString("id");
				col[1]=rs.getString("cat");
				
				
				dtm.addRow(col);
			}
			
			
			con.close(); 
		}catch(Exception e1){ System.out.println(e1);} 
	}
	
	
	
	
	 
		
		
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String a=jf1.getText();
			String query="insert into ani_cat(cat) values('"+a+"')";
			
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
		
		
		
		if(ae.getSource()==b3)
		{
			String b=jf2.getText();
			String query="delete from ani_cat where id="+b;
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
		
		
		if(ae.getSource()==b4)
		{	
			 String a=jf1.getText();
             String b=jc1.getText();
        
        
		
			   	String query="update ani_cat set cat='"+a+"' where id="+b;
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
    	if(ie.getSource()==jc1)
    	{
    		if(jc1.isSelected()==true)
    		{
    			jf2.setVisible(true);
    			jl3.setVisible(true);
    			b3.setEnabled(true);
    			b4.setEnabled(true);
    			b1.setEnabled(false);
    			b2.setEnabled(false);
    		}
    		else
    		{
    			jf2.setVisible(false);
    			jl3.setVisible(false);
    			b3.setEnabled(false);
    			b4.setEnabled(false);
    			b1.setEnabled(true);
    			b2.setEnabled(true);
    		}
    		
    	}
    }
		
	
	public static void main(String [] ar)
	{
		new addcategory();
	}
}
		
