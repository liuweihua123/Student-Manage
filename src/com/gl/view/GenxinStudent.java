package com.gl.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GenxinStudent {
	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";

	public static void main(String [] args)
	{
		genxinview();
	}
	public static void genxinview()
	{
		JFrame jf4=new JFrame("更新学生信息(学号不变)");
		jf4.setBounds(100, 100, 300, 500);
		jf4.setLayout(null);
		JLabel jl1=new JLabel("学号：");
		jl1.setBounds(50, 50, 40, 20);
		jf4.add(jl1);		
		JLabel jl2=new JLabel("姓名：");
		jl2.setBounds(50, 90, 40, 20);
		jf4.add(jl2);
		JLabel jl3=new JLabel("性别：");
		jl3.setBounds(50, 130, 40,20);
		jf4.add(jl3);
		JLabel jl4=new JLabel("身份证号：");
		jl4.setBounds(24, 170, 100, 20);
		jf4.add(jl4);
		JLabel jl5=new JLabel("班级：");
		jl5.setBounds(50, 210, 40, 20);
		jf4.add(jl5);
		JLabel jl6=new JLabel("专业：");
		jl6.setBounds(50, 250, 40, 20);
		jf4.add(jl6);
		JLabel jl7=new JLabel("学校名称：");
		jl7.setBounds(24, 290, 100, 20);
		jf4.add(jl7);
		
		final JTextField jt1=new JTextField();
		jt1.setBounds(90, 50, 180, 20);
		jf4.add(jt1);
		final JTextField jt2=new JTextField();
		jt2.setBounds(90, 90, 180, 20);
		jf4.add(jt2);
		final JTextField jt3=new JTextField();
		jt3.setBounds(90, 130, 180, 20);
		jf4.add(jt3);
		final JTextField jt4=new JTextField();
		jt4.setBounds(90, 170, 180, 20);
		jf4.add(jt4);
		final JTextField jt5=new JTextField();
		jt5.setBounds(90, 210, 180, 20);
		jf4.add(jt5);
		final JTextField jt6=new JTextField();
		jt6.setBounds(90, 250, 180, 20);
		jf4.add(jt6);
		final JTextField jt7=new JTextField();
		jt7.setBounds(90, 290, 180, 20);
		jf4.add(jt7);
		JButton jb=new JButton("确认更新");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jt1.getText().toString().trim().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "更新失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con =DriverManager.getConnection(Url, User, Pass);
						PreparedStatement ps=con.prepareStatement("update studentinfor set name=?,sex=?,idcard=?,banji=?,major=?,school=? where no=?");
						
						ps.setString(1, jt2.getText().toString().trim());	
						ps.setString(2, jt3.getText().toString().trim());
						ps.setString(3, jt4.getText().toString().trim());
						ps.setString(4, jt5.getText().toString().trim());
						ps.setString(5, jt6.getText().toString().trim());
						ps.setString(6, jt7.getText().toString().trim());
						ps.setString(7, jt1.getText().toString().trim());
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						ps.close();
						con.close();
				
					}catch(Exception ex)
					{
						System.out.println("error");
						
					}
				}
				
							
			}
		});
		jb.setBounds(100, 350, 100, 30);
		jf4.add(jb);
		jf4.setVisible(true);
	}
}

