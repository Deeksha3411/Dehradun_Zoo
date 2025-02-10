package com.pack;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class revenue extends JFrame 
{
	
	JPanel jp1,jp2;
	JTabbedPane jtp;
	JScrollPane jsp;
	DefaultTableModel dtm1,dtm2;
	JTable jt1,jt2;
	
	JLabel jl1,jl2,jl3,jl4,jl5;
	JTextField jf1,jf2,jf3;
	JCheckBox jx1,jc2;
	
	 revenue()
	{
		 
		 
		 
		    jp1=new JPanel();
		    jp1.setBounds(50,50,700,700);
			jp1.setBackground(Color.cyan);
			jp1.setLayout(null);
			
			
			jl1=new JLabel("INCOME ");
			jl1.setFont(new Font("Tahoma",Font.BOLD,30));
			jl1.setBounds(280,50,400,50);
			jp1.add(jl1);
			
			
			dtm1=new DefaultTableModel();
			jt1=new JTable(dtm1);
			dtm1.addColumn("SR");
			dtm1.addColumn("NAME");
			dtm1.addColumn("TOTAL");
			dtm1.addColumn("DISCOUNT");
			dtm1.addColumn("AMOUNT");
			
			jsp=new JScrollPane(jt1);
			jsp.setBounds(100,150,460,300);
			jp1.add(jsp);
			
			
			jl5=new JLabel("Category");
			jl5.setFont(new Font("Tahoma",Font.BOLD,15));
			jl5.setBounds(70,500,230,30);
			jp1.add(jl5);
			
			jx1=new JCheckBox("");
			jx1.setBounds(320,500,230,30);
			jp1.add(jx1);
			
			
			jl3=new JLabel(" TOTAL INCOME ");
			jl3.setFont(new Font("Tahoma",Font.BOLD,20));
			jl3.setBounds(70,500,230,30);
			jp1.add(jl3);
			
			jf1=new JTextField(20);
			jf1.setFont(new Font("Tahoma",Font.BOLD,15));
			jf1.setBounds(320,500,230,30);
			jp1.add(jf1);
			

			jl5=new JLabel(" PROFIT ");
			jl5.setFont(new Font("Tahoma",Font.BOLD,20));
			jl5.setBounds(70,540,230,30);
			jp1.add(jl5);
			
			
			jf3=new JTextField(20);
			jf3.setFont(new Font("Tahoma",Font.BOLD,15));
			jf3.setBounds(320,540,230,30);
			jp1.add(jf3);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			jp2=new JPanel();
		    jp2.setBounds(780,50,700,700);
			jp2.setBackground(Color.green);
			jp2.setLayout(null);
			
			jl2=new JLabel("EXPENSES ");
			jl2.setFont(new Font("Tahoma",Font.BOLD,30));
			jl2.setBounds(240,50,400,50);
			jp2.add(jl2);
			
			dtm2=new DefaultTableModel();
			jt2=new JTable(dtm2);
			dtm2.addColumn("SR");
			dtm2.addColumn("ANIMAL NAME");
			dtm2.addColumn("QUANTITY");
			dtm2.addColumn("AMOUNT");
			
			jsp=new JScrollPane(jt2);
			jsp.setBounds(100,150,460,300);
			jp2.add(jsp);
			
			
			
			
			
			jl4=new JLabel(" TOTAL EXPENSES ");
			jl4.setFont(new Font("Tahoma",Font.BOLD,20));
			jl4.setBounds(100,500,230,30);
			jp2.add(jl4);
			
			jf2=new JTextField(20);
			jf2.setFont(new Font("Tahoma",Font.BOLD,15));
			jf2.setBounds(320,500,230,30);
			jp2.add(jf2);
			
			
			
			
	     	add(jp1);
		    add(jp2);
			
		 
		 
		
		
		
		
		
		
		
		fillticket();
		fillincome();
		
		setSize(1600,1000);
		setLayout(null);
		setVisible(true);
		
		
	}
	 
	 
	 void fillticket()
		{
		 	double total=0;
			dtm1.setNumRows(0);
		   	String query="select * from ticket";
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				int i=1;
				while(rs.next())
				{
					Object col[]=new Object[5];
					col[0]=i++;
					col[1]=rs.getString("name");
					col[2]=rs.getString("total");
					col[3]=rs.getString("dis");
					col[4]=rs.getString("amt");
					
					total+=Double.parseDouble(rs.getString("amt"));
					
					dtm1.addRow(col);
				}
				
				
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);} 
			
			jf1.setText(String.valueOf(total));
		}
	 
	 
	 
	 void fillincome()
		{
		 
		     //double tot=0;
		    // double rev=0;
			dtm2.setNumRows(0);
		   	String query= "select aname,sum(qty),sum(amt)from purchase inner join purdesc on purchase.invid=purdesc.invid inner join animal on animal.aid=purdesc.aid group by animal.aid";
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				int i=1;
				while(rs.next())
				{
					Object col[]=new Object[4];
					col[0]=i++;
					col[1]=rs.getString("aname");
					col[2]=rs.getString("sum(qty)");
					col[3]=rs.getString("sum(amt)");
					
					
					//tot+=Double.parseDouble(rs.getString("amt"));
					
					
					
					dtm2.addRow(col);
				}
				
				
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);} 
		}
	 
	 
	 public void actionPerformed(ActionEvent ae)
		{
		 
		 
		}
			
			
	
	
	public static void main(String [] ar)
	{
		new revenue();
	}
}