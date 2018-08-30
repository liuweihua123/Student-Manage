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
public class DelStudentInformation {
	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";

	public static void main(String [] args)
	{
		delgraph();
		
	}
	public static void delgraph()
	{
		JFrame jf=new JFrame("删除学生信息");
		jf.setLayout(null);
		jf.setBounds(100, 100, 1000, 400);
		JLabel jl1=new JLabel("学号：");
		jl1.setBounds(200, 80, 200, 20);
		jf.add(jl1);
		final JTextField jtx=new JTextField();
		jtx.setBounds(250, 80, 300, 20);
		jf.add(jtx);
		JButton jb=new JButton("删除");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtx.getText().toString().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入为空,请重新输入","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						/*Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(Url,User,Pass);
						Statement stat=con.createStatement();
						ResultSet rs=stat.executeQuery("select * from studentinfor");
						rs.next();
						if(!rs.getString("no").contains(jtx.getText().toString().trim()))
						{
							JOptionPane.showMessageDialog(null, "未找到该学号,请重新输入","提示",JOptionPane.INFORMATION_MESSAGE);
							rs.close();
							con.close();
						}
						else
						{*/
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection(Url,User,Pass);
							PreparedStatement ps=conn.prepareStatement("delete from studentinfor where no=?");
							ps.setString(1,jtx.getText().toString().trim());
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
							ps.close();
							conn.close();
						}
						
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "数据库连接失败","提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		jb.setBounds(600, 80, 60, 20);
		jf.add(jb);
		jf.setVisible(true);
	}

	
}
