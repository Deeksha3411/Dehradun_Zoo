package com.pack;



import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.*;
import java.awt.*;

class animalstock extends JFrame implements ActionListener
{
	
	JLabel jl1,jl2,jl3,jl4,jl5;
	JTextField jf1,jf2,jf3;
	JButton b1,b2;
	
	JTable jt1;
	DefaultTableModel dtm;
	JScrollPane jsp;
	
	
	JComboBox jc1;
  // String Category[]={"Btech","MSC","MBA","B.A","Designing"};
	
	String animal[];
    String aid[];
    int i=0;
    int id=1;

	
	
	animalstock()
	{
		
		jl1=new JLabel("ANIMAL STOCK");
		jl1.setFont(new Font("Tahoma",Font.BOLD,20));
		jl1.setBounds(100,50,300,40);
		
		
		int k=getSizze();
		animal=new String[k];
		aid=new String[k];
		
		display();
		
		jl2=new JLabel("Animal");
		jl2.setBounds(50,110,130,20);
		jc1=new JComboBox<String>(animal);
		jc1.setBounds(190,110,130,20);
		
		
		
		dtm=new DefaultTableModel();
		jt1=new JTable(dtm);
		dtm.addColumn("SRid");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		dtm.addColumn("Animal Name");
		
		
		
		jsp=new JScrollPane(jt1);
		jsp.setBounds(360,110,400,200);
		
		
		
		jl3=new JLabel("Quantity");
		jl3.setBounds(50,140,130,20);
		jf1=new JTextField(20);
		jf1.setBounds(190,140,130,20);
		
		
		
		
		
		
		
		b1=new JButton("Submit");
		b1.addActionListener(this);
		b1.setBounds(80,170,90,35);
		
		b2=new JButton("RESET");
		b2.addActionListener(this);
		b2.setBounds(180,170,90,35);
		
		
		add(jl1);
		add(jl2);
		add(jc1);
		
		add(jl3);
		
		
		add(jf1);
		
		add(b1);
		add(b2);
		add(jsp);

		
		fillstock();
		
		setSize(800,500);
		setLayout(null);
		setVisible(true);
	}
	
	
	void fillstock()
	{
		dtm.setNumRows(0);
		String query="select animal.aid,animal.aname, sum(qty) from animal inner join purdesc on animal.aid=purdesc.aid group by animal.aid";
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
				col[2]=rs.getString("sum(qty)");
				
				
				dtm.addRow(col);
			}
			
			
			con.close(); 
		}catch(Exception e1){ System.out.println(e1);} 
	}
	
	
	
	
	
	void display()
	{
		String query="select animal.aid,animal.aname, sum(qty) from animal inner join purdesc on animal.aid=purdesc.aid group by animal.aid";
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
				animal[i]=rs.getString("animal.aname");
				aid[i]=rs.getString("animal.aid");
				i++;
			}
			
			con.close(); 
		}catch(Exception e){ System.out.println(e);}  
	}
	
	
	int getSizze()
	{
		String query="select animal.aname, sum(qty) from animal inner join purdesc on animal.aid=purdesc.aid group by animal.aid";
		i=0;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
			System.out.print("Connection Established ");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
				i++;
			
			con.close(); 
		}catch(Exception e){ System.out.println(e);} 
		
		
		return i;
	}
	
		
		
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==b1)
		{
			String id=aid[jc1.getSelectedIndex()];
			
			String query="select animal.aname, sum(qty) from animal inner join purdesc on animal.aid=purdesc.aid where animal.aid="+id+" group by animal.aid";
			System.out.println(query);
			
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
				//System.out.print("Connection Established ");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next())
					jf1.setText(rs.getString("sum(qty)"));
					
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);}
			
			fillstock();
		}
		
		
		
	
			
					
		
		
	}
		
	
	public static void main(String [] ar)
	{
		new animalstock();
	}
}
		
