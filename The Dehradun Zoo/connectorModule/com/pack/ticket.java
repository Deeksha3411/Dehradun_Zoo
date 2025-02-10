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

class ticket extends JFrame implements ActionListener,ItemListener
{
	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JTextField jf1,jf2,jf3,jf4,jf5,jf6,jf7,jf8,jf9;
	JButton b1,b2,b3,b4,b5;
	
	JCheckBox jc1,jc2,jc3,jc4,jc5;
	JRadioButton jr1,jr2,jr3;
	
	JTable jt1;
	DefaultTableModel dtm;
	JScrollPane jsp;
	
	String facilities[]={"Btech","MSC","MBA","B.A","Designing"};

	
	
	ticket()
	{
		
		jl1=new JLabel("TICKET COUNTER");
		jl1.setFont(new Font("Tahoma",Font.BOLD,20));
		jl1.setBounds(100,50,200,40);
		
		
		jc5=new JCheckBox("");
		jc5.setBounds(20,110,30,20);
		jc5.addItemListener(this);
		
		jl10=new JLabel("Ca id");
		jl10.setFont(new Font("Tahoma",Font.BOLD,15));
		jl10.setBounds(50,110,130,20);
		jl10.setVisible(false);
		
		jf9=new JTextField(20);
		jf9.setFont(new Font("Tahoma",Font.BOLD,15));
		jf9.setBounds(190,110,130,20);
		jf9.setVisible(false);
		
		
		
		jl2=new JLabel("Name");
		jl2.setFont(new Font("Tahoma",Font.BOLD,15));
		jl2.setBounds(50,140,130,20);
		jf1=new JTextField(20);
		jf1.setFont(new Font("Tahoma",Font.BOLD,15));
		jf1.setBounds(190,140,130,20);
		
		
		dtm=new DefaultTableModel();
		jt1=new JTable(dtm);
		dtm.addColumn("SRid");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		
		
		
		
		jsp=new JScrollPane(jt1);
		jsp.setBounds(430,110,400,200);
		
		
		
		jl3=new JLabel("Mobile");
		jl3.setFont(new Font("Tahoma",Font.BOLD,15));
		jl3.setBounds(50,170,130,20);
		jf2=new JTextField(20);
		jf2.setFont(new Font("Tahoma",Font.BOLD,15));
		jf2.setBounds(190,170,130,20);
		
		
		jl4=new JLabel("Adult");
		jl4.setFont(new Font("Tahoma",Font.BOLD,15));
		jl4.setBounds(50,200,130,20);
		jf3=new JTextField(20);
		jf3.setFont(new Font("Tahoma",Font.BOLD,15));
		jf3.setBounds(190,200,130,20);
		
		
		jl5=new JLabel("Child");
		jl5.setFont(new Font("Tahoma",Font.BOLD,15));
		jl5.setBounds(50,240,130,20);
		jf4=new JTextField(20);
		jf4.setFont(new Font("Tahoma",Font.BOLD,15));
		jf4.setBounds(190,240,130,20);
		
		
		
		
		jl6=new JLabel("FACILITIES");
		jl6.setFont(new Font("Tahoma",Font.BOLD,15));
		jl6.setBounds(50,270,130,20);
		
	
		jc1=new JCheckBox("Aquarium");
		jc1.setBounds(50,300,120,20);
		jc2=new JCheckBox("Cactus Garden");
	    jc2.setBounds(180,300,120,20);
		jc3=new JCheckBox("Laser Show");
		jc3.setBounds(290,300,120,20);
		
		
		ButtonGroup bg=new ButtonGroup();
		jr1=new JRadioButton("Indian");
		jr1.setBounds(50,340,100,20);

		
		jr2=new JRadioButton("Foreign");
		jr2.setBounds(160,340,100,20);
		
		bg.add(jr1);
		bg.add(jr2);
		
		jl7=new JLabel("Total Bill");
		jl7.setFont(new Font("Tahoma",Font.BOLD,15));
		jl7.setBounds(50,380,130,20);
		jf5=new JTextField(20);
		jf5.setFont(new Font("Tahoma",Font.BOLD,15));
		jf5.setBounds(190,380,130,20);
		
		jl8=new JLabel("Discount");
		jl8.setFont(new Font("Tahoma",Font.BOLD,15));
		jl8.setBounds(50,420,130,20);
		jf6=new JTextField(20);
		jf6.setFont(new Font("Tahoma",Font.BOLD,15));
		jf6.setBounds(190,420,130,20);
		
		
		jl9=new JLabel("Amount");
		jl9.setFont(new Font("Tahoma",Font.BOLD,15));
		jl9.setBounds(50,460,130,20);
		jf7=new JTextField(20);
		jf7.setFont(new Font("Tahoma",Font.BOLD,15));
		jf7.setBounds(190,460,130,20);
		
		
		
		b2=new JButton("Calcu");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma",Font.BOLD,15));
		b2.setBounds(80,500,90,35);
		
		b3=new JButton("Cancel");
		b3.addActionListener(this);
		b3.setFont(new Font("Tahoma",Font.BOLD,15));
		b3.setBounds(180,500,90,35);
		
		
		b4=new JButton("Update");
		b4.addActionListener(this);
		b4.setFont(new Font("Tahoma",Font.BOLD,15));
		b4.setBounds(80,540,90,35);
		
		b5=new JButton("Delete");
		b5.addActionListener(this);
		b5.setFont(new Font("Tahoma",Font.BOLD,15));
		b5.setBounds(180,540,90,35);
		
		
		
		
		b1=new JButton("Calculate and Save");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma",Font.BOLD,15));
		b1.setBounds(50,580,250,35);
		
		
		
		
		
		
		
		add(jl1);
		add(jl2);
		add(jl3);
        add(jl4);
		add(jl5);
		add(jf1);
		add(jf2);
		add(jf3);
		add(jl6);
		add(jf4);
		add(jl7);
		add(jl8);
		add(jl9);
		add(jf5);
		add(jf6);
		add(jl10);
		add(jf9);
		add(jf7);
		add(jsp);
		
		
		add(jc1);
		add(jc2);
		add(jc3);
		add(jr1);
		add(jr2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(jc5);
		
		fillAnimal();
	
	
		setSize(1300,600);
		setLayout(null);
		setVisible(true);
	}
	
	
	void fillAnimal()
	{
		dtm.setNumRows(0);
	   	String query="select * from ticket";
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
			System.out.print("Connection Established ");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				Object col[]=new Object[10];
				col[0]=rs.getString("tid");
				col[1]=rs.getString("name");
				col[2]=rs.getString("mob");
				col[3]=rs.getString("adult");
				col[4]=rs.getString("child");
				col[5]=rs.getString("facility");
				col[6]=rs.getString("citizen");
				col[7]=rs.getString("total");
				col[8]=rs.getString("dis");
				col[9]=rs.getString("amt");
				
				dtm.addRow(col);
			}
			
			
			con.close(); 
		}catch(Exception e1){ System.out.println(e1);} 
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//Calculate and Save
		if(ae.getSource()==b1)
		{
			String a=jf1.getText();
			String b=jf2.getText();
			String c=jf3.getText();
			String d=jf4.getText();
			
			String e="";
			
			if(jc1.isSelected()==true)	
				e+=" "+jc1.getText();
			 if(jc2.isSelected()==true)
				 e+=" "+jc2.getText();
			 if(jc3.isSelected()==true)
				 e+=" "+jc3.getText();
			
			e=e.trim();
			String g="";
			
			if(jr1.isSelected()==true)	
				g=jr1.getText();
			else if(jr2.isSelected()==true)
				g=jr2.getText();
			else
				g="No Gender Selected ";
			
			String x=jf5.getText();
			String y=jf6.getText();
			String z=jf7.getText();
			
			
			
			
			
			String query="insert into ticket(name,mob,adult,child,facility,citizen,total,dis,amt) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+g+"',"+x+","+y+","+z+")";
			
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
		}
		
		
		//Calculate
		
		if(ae.getSource()==b2)
		{
		
			
			int adult=Integer.parseInt(jf3.getText());
			int child=Integer.parseInt(jf4.getText());
			
			
			int total=(adult*30)+(child*0);
	       
			
			
			if(jc1.isSelected()==true)
				total=50+total;
			if(jc2.isSelected()==true)
				total=50+total;
			if(jc3.isSelected()==true)
				total=50+total;
			
			
			if(jr1.isSelected()==true)
				total=30+total;
			else if(jr2.isSelected()==true)
			   total=50+total;
			  
		  jf5.setText(String.valueOf(total));
		  
		  //Total
		 
		  int dis=(total*10)/100;
		   jf6.setText(String.valueOf(dis));
		 
		 //Amount
		 
		  int amt=total-dis;
		  jf7.setText(String.valueOf(amt));
			
		}	
		
		
		if(ae.getSource()==b5)
		{
			
			
			String fg=jf9.getText();
			
			String query="delete from ticket where tid = "+fg;
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
			//String ax=jf9.getText();
			String a=jf1.getText();
			String b=jf2.getText();
			String c=jf3.getText();
			String d=jf4.getText();
			String e=jf3.getText();
			String f=jf4.getText();
			String x=jf5.getText();
			String y=jf6.getText();
			String z=jf7.getText();
		   
			String query="update ticket set name='"+a+"',mob='"+b+"',adult="+c+",child="+d+",facility='"+e+"',citizen='"+f+"',total="+x+",dis="+y+",amt="+z+" where tid="+jf9.getText();
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
    	if(ie.getSource()==jc5)
    	{
    		if(jc5.isSelected()==true)
    		{
    		    jf9.setVisible(true);
    			jl10.setVisible(true);
    			b5.setEnabled(true);
    			b4.setEnabled(true);
    			b1.setEnabled(false);
    			b2.setEnabled(false);
    			b3.setEnabled(false);
    			
    		}
    		else
    		{
    			jf9.setVisible(false);
    			jl10.setVisible(false);
    			b3.setEnabled(true);
    			b4.setEnabled(false);
    			b1.setEnabled(true);
    			b2.setEnabled(true);
    			b5.setEnabled(false);
    		}
    		
    	}
    }
		
	
	public static void main(String [] ar)
	{
		new ticket();
	}
}
