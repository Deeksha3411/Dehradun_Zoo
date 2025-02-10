package com.pack;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.*;
import java.awt.*;



class purchase extends JFrame implements ActionListener
{
	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
	JTextField jf1,jf2,jf3,jf4,jf5,jf6,jf7,jf8,jf9,jf10;
	JButton b1,b2,b3,b4;
	JPanel jp1;
	

	JRadioButton jr1,jr2,jr3;
	JTable jt1,jt2,jt3;
	DefaultTableModel dtm1,dtm2;
	JScrollPane jsp1,jsp2;


	
	JComboBox jc1;
   // String Animal[]={"Btech","MSC","MBA","B.A","Designing"};
    
    String animal[];
    String aid[];
    int i=0;
    int id=1;
    int tot1=0;
	
	purchase()
	{
		
		jl1=new JLabel("PURCHASE WINDOW");
		jl1.setFont(new Font("Tahoma",Font.BOLD,20));
		jl1.setBounds(340,50,300,40);
		
		
		jl2=new JLabel("Name");
		jl2.setBounds(50,110,100,20);
		jf1=new JTextField(20);
		jf1.setBounds(160,110,100,20);
		
		
		jl3=new JLabel("Date");
		jl3.setBounds(280,110,100,20);
		jf2=new JTextField(20);
		jf2.setBounds(380,110,100,20);
		
		ButtonGroup bg=new ButtonGroup();
		jr1=new JRadioButton("Adult");
		jr1.setBounds(500,110,100,20);
		jr2=new JRadioButton("Child");
		jr2.setBounds(610,110,100,20);
		
		
		bg.add(jr1);
		bg.add(jr2);
		
		
		jl11=new JLabel("INVID");
		jl11.setBounds(730,110,100,20);
		jf10=new JTextField(20);
		jf10.setBounds(830,110,100,20);
		
		
		
		
		
		jl4=new JLabel("Animal");
		jl4.setBounds(50,150,100,20);
		
		int k=getSizze();
		animal=new String[k];
		aid=new String[k];
		
		display();
		
		jc1=new JComboBox<String>(animal);
		jc1.setBounds(160,150,100,20);
		
		
		jl5=new JLabel("Quantity");
		jl5.setBounds(280,150,100,20);
		jf3=new JTextField(20);
		jf3.setBounds(380,150,100,20);
		
		jl6=new JLabel("Price");
		jl6.setBounds(510,150,100,20);
		jf4=new JTextField(20);
		jf4.setBounds(600,150,100,20);
		
		b1=new JButton("ADD");
		b1.addActionListener(this);
		b1.setBounds(730,150,90,20);
		
		
		
		
	
		dtm1=new DefaultTableModel();
		jt1=new JTable(dtm1);
		dtm1.addColumn("SRid");
		dtm1.addColumn("Animal Name");
		dtm1.addColumn("QTY");
		dtm1.addColumn("Rate");
		dtm1.addColumn("Total");
		jsp1=new JScrollPane(jt1);
		jsp1.setBounds(50,200,780,200);
		
		
		
		dtm2=new DefaultTableModel();
		jt2=new JTable(dtm2);
		dtm2.addColumn("Animal Name");
		dtm2.addColumn("Adult");
		dtm2.addColumn("Child");
		jsp2=new JScrollPane(jt2);
		jsp2.setBounds(50,420,400,160);
		
		
		
		
		
		
		
		
		jl7=new JLabel("TOTAL");
		jl7.setBounds(500,420,100,20);
		jf5=new JTextField(20);
		jf5.setBounds(620,420,100,20);
		
		
		b3=new JButton("DELETE");
		b3.addActionListener(this);
		b3.setBounds(760,440,110,30);
		
		
		b4=new JButton("UPDATE");
		b4.addActionListener(this);
		b4.setBounds(760,490,110,30);
		
		
		
		
		
		jl8=new JLabel("TAX");
		jl8.setBounds(500,470,100,20);
		jf6=new JTextField(20);
		jf6.setBounds(620,470,100,20);
		
		jl9=new JLabel("DISCOUNT");
		jl9.setBounds(500,520,100,20);
		jf7=new JTextField(20);
		jf7.setBounds(620,520,100,20);
		
		
		jl10=new JLabel("ATP");
		jl10.setBounds(500,570,100,20);
		jf8=new JTextField(20);
		jf8.setBounds(620,570,100,20);
		
		
		b2=new JButton("CALCULATE AND SAVE");
		b2.addActionListener(this);
		b2.setBounds(470,620,250,30);
		
		
		
		
		
		
		add(jl1);
		add(jl2);
		add(jf1);
		add(jf2);
		add(jl3);
		add(jc1);
		add(jr1);
		add(jr2);
		add(jl4);
		add(b1);
		add(jl5);
		add(jl6);
	    add(jf3);
		add(jf4);
		add(jsp1);
		add(jsp2);
		add(jl8);
		add(jl7);
		add(jf5);
		add(jf6);
		add(jl9);
		add(jl10);
		add(jf7);
		add(jf8);
		add(jl11);
		add(jf10);
		add(b2);
		add(b3);
		add(b4);
		
		
		fillPurchase();
		fillPurch();
	
		setSize(980,700);
		setLayout(null);
		setVisible(true);
	}
	
	void display()
	{
		String query="select * from animal";
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
				animal[i]=rs.getString("aname");
				aid[i]=rs.getString("aid");
				i++;
			}
			
			con.close(); 
		}catch(Exception e){ System.out.println(e);}  
	}
	
	
	
	int getSizze()
	{
		String query="select * from animal";
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
	
	
	
	void fillPurchase()
	{
		
		
	}
	
	void fillPurch()
	{
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==b1)
		{
			Object ob[]=new Object[10];
			ob[0]=aid[jc1.getSelectedIndex()];
			ob[1]=animal[jc1.getSelectedIndex()];
			ob[2]=jf3.getText();
			ob[3]=jf4.getText();
			ob[4]=Integer.parseInt(jf3.getText())*Integer.parseInt(jf4.getText());
			
			tot1+=Integer.parseInt(jf3.getText())*Integer.parseInt(jf4.getText());
			int tax=(tot1*50)/100;
			int dis=(tot1*10)/100;
			int amt=tot1-dis;
			
			if(jr1.isSelected()==false && jr2.isSelected()==false)
				JOptionPane.showMessageDialog(this,"Please Choose Adult/Child Option ");  
			else
			{
				dtm1.addRow(ob);
				jf5.setText(String.valueOf(tot1));
				jf6.setText(String.valueOf(tax));
				jf7.setText(String.valueOf(dis));
				jf8.setText(String.valueOf(amt));
				
				Object ob1[]=new Object[3];
				ob1[0]=animal[jc1.getSelectedIndex()];
				ob1[1]=0;
				ob1[2]=0;
				
				if(jr1.isSelected()==true)	
					ob1[1]=jf3.getText();
				else if(jr2.isSelected()==true)
					ob1[2]=jf3.getText();
				
				
				dtm2.addRow(ob1);
			}
		}
	
		
		if(ae.getSource()==b2)
		{
			String id=jf10.getText();
			String na=jf1.getText();
			String da= jf2.getText();
			String tot=jf5.getText();
			String tax=jf6.getText();
			String dis=jf7.getText();
			String amt=jf8.getText();
			
			
			
			String query="insert into purchase(invid,partyname,Date,total,tax,dis,amt) values ("+id+",'"+na+"','"+da+"',"+tot+","+tax+","+dis+","+amt+")";
			
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				st.executeUpdate(query);
				con.close(); 
				
			}catch(Exception e1){ System.out.println(e1);}	
			
			
			System.out.println(query);
			
			String aidd="",qty="",price="",type="";
			
			for (int i = 0 ; i < dtm1.getRowCount() ; i++)
			{
				aidd=dtm1.getValueAt(i,0).toString();
				qty=dtm1.getValueAt(i,2).toString();
				price=dtm1.getValueAt(i,3).toString();
				
				if(dtm2.getValueAt(i,1).toString().equals("0"))
					type="Child";
				else if(dtm2.getValueAt(i,2).toString().equals("0"))
					type="Adult";
				else
					type="NA";
				
				
				System.out.println(aidd+" "+qty+" "+price+" "+type+" "+id);
				
			
				String q="insert into purdesc (aid,qty,price,type,invid) values ("+aidd+","+qty+","+price+",'"+type+"',"+id+")";
				
				try
				{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dehradunzoo","root","12345");  
					System.out.print("Connection Established ");
					Statement st=con.createStatement();
					st.executeUpdate(q);
					con.close(); 
					
				}catch(Exception e1){ System.out.println(e1);}
			}	
			
		}
		
		
		if(ae.getSource()==b3)
		{
			
			
			String ig=jf10.getText();
			
			String query="delete from purdesc where invid = "+ig;
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
			
			
			query="delete from purchase where invid = "+ig;
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
		
	}
		
	
	public static void main(String [] ar)
	{
		new purchase();
	}
}