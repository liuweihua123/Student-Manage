package com.gl.view;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class Login {
	/*
	 * 
	 */
	/*public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";*/
	public static void main(String [] args)
	{
		initview();
	}
	public static void initview()
	{
		final JFrame jf=new JFrame("��¼");
		jf.setBounds(100, 100, 500, 500);
		jf.setLayout(null);
		JLabel jl1=new JLabel("�û�����");
		JLabel jl2=new JLabel("���룺");
		jl1.setBounds(0, 100, 100, 30);
		jl2.setBounds(0, 200, 100, 30);
		jf.add(jl1);
		jf.add(jl2);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 100, 300, 30);
		jf.add(jt1);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 200, 300, 30);
		jf.add(jt2);
		
		JButton jb1=new JButton("��¼");
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jt1.getText().toString().trim().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "�������û���");
					return;
				}
				if(jt2.getText().toString().trim().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "����������");
					return;
				}
				try
				{
					/*Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection(Url, User, Pass);
					Statement st=con.createStatement();*/
					String sql="select * from userinfor where username='"+jt1.getText().toString().trim()+"'";
					DBop dbop=new DBop();
					ResultSet rs=dbop.query(sql);
					//rs.next();
					if(rs.next())
					{
						if(jt2.getText().toString().trim().equals(rs.getString("password")))
						{
							String usern=rs.getString("username");
							String rol=rs.getString("role");
							Mainview mv=new Mainview(usern,rol);
							mv.init();	
							jf.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(jf, "�������");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(jf, "û�и��û�");
					}
					dbop.close();
					/*con.close();*/
					/*	if(jt1.getText().toString().trim().equals(rs.getString("username"))&&jt2.getText().toString().trim().equals(rs.getString("password")))
						{
							Mainview mv=new Mainview();
							mv.init();	
							jf.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"��¼ʧ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							
						}
					*/
				}
				catch(Exception ex)
				{
					System.out.println("���ݿ�����ʧ��");
				}
				

					
			
			}
		});
		jb1.setBounds(150, 300, 80, 20);
		jf.add(jb1);
		
		JButton jb2=new JButton("ע��");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Zhuce z1=new Zhuce();
				z1.zuce();
				jf.setVisible(false);
				
			}
		});
		jb2.setBounds(300, 300, 80, 20);
		jf.add(jb2);
		jf.setVisible(true);
		
		
	}
	

}
