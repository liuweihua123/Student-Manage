package com.gl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class QuerySingleStudent {
	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";

	public static void main(String [] args)
	{
		queryss();
	}
	public static void queryss()
	{
		final JFrame jf=new JFrame("查询单个学生");
		jf.setLayout(null);
		jf.setBounds(100, 100, 1000, 400);
		JLabel jl=new JLabel("请输入学号:");
		jl.setBounds(100, 50, 200, 20);
		jf.add(jl);
		final JTextField jtx=new JTextField();
		jtx.setBounds(200, 50, 300, 20);
		jf.add(jtx);
		
		JLabel jlx1=new JLabel("数据： 学号   姓名  性别  身份证  班级  专业   学校名称");
		jlx1.setBounds(100, 80, 800, 20);
		jf.add(jlx1);
		
		final JTable jtb=new JTable(1, 7);
		jtb.setRowHeight(40);
		jtb.setBounds(100, 100, 800, 40);
		jf.add(jtb);
		
		JLabel jlx=new JLabel("数据： 学号   语文  数学  java  c语言成绩");
		jlx.setBounds(100, 180, 600, 20);
		jf.add(jlx);
		
		final JTable jtb2=new JTable(1,5);
		jtb2.setRowHeight(40);
		jtb2.setBounds(100, 200, 800, 40);
		jf.add(jtb2);
		JButton jb=new JButton("查询");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String a[][]=new String[1][7];
				String lie[]={"学号","姓名","性别","身份证号","班级","专业","学校"};
				
				String b[][]=new String[1][5];
				String lie1[]={"学号","语文","数学","java","c"};
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(Url,User,Pass);
					Statement stat=con.createStatement();
					ResultSet rs=stat.executeQuery("select * from studentinfor where no='"+jtx.getText().toString().trim()+"' ");
				
					while(rs.next())
					{
						a[0][0]=rs.getString("no");
						a[0][1]=rs.getString("name");
						a[0][2]=rs.getString("sex");
						a[0][3]=rs.getString("idcard");
						a[0][4]=rs.getString("banji");
						a[0][5]=rs.getString("major");
						a[0][6]=rs.getString("school");
				
						
					}
				
					//System.out.println(rs.getString("name"));
					jtb.setVisible(false);
					JTable jtb1=new JTable(a, lie);
					jtb1.setRowHeight(40);
					jtb1.setBounds(100, 100, 800, 40);
					jf.add(jtb1);
					
				
					
					
					/*rs.close();
					con.close();*/
					
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "数据库连接失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(Url,User,Pass);
					Statement stat=con.createStatement();

					ResultSet rs1=stat.executeQuery("select * from gradeinfor where no='"+jtx.getText().toString().trim()+"'");

					while(rs1.next())
					{
						b[0][0]=rs1.getString("no");
						b[0][1]=rs1.getString("chinese");
						b[0][2]=rs1.getString("math");
						b[0][3]=rs1.getString("java");
						b[0][4]=rs1.getString("c");			
						
					}
					
					//System.out.println(rs.getString("name"));
			
					
					jtb2.setVisible(false);
					JTable jtb3=new JTable(b, lie1);
					jtb3.setRowHeight(40);
					jtb3.setBounds(100, 200, 800, 40);
					jf.add(jtb3);
					
					
					
					
					
					con.close();
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "数据库连接失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});
		jb.setBounds(550, 50, 60, 20);
		jf.add(jb);
		
		
		
		jf.setVisible(true);
	}
}
