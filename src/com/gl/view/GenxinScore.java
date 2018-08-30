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

public class GenxinScore {

	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";
	public static void main(String [] args)
	{
		genxinscore();
	}
	public static void genxinscore()
	{
		JFrame jf=new JFrame("成绩更新(学号不变)");
		jf.setBounds(100, 100, 300, 500);
		jf.setLayout(null);
		JLabel jl1=new JLabel("学号:");
		jl1.setBounds(50, 50, 50, 20);
		jf.add(jl1);
		JLabel jl2=new JLabel("语文:");
		jl2.setBounds(50, 90, 50, 20);
		jf.add(jl2);
		JLabel jl3=new JLabel("数学:");
		jl3.setBounds(50, 130, 50, 20);
		jf.add(jl3);
		JLabel jl4=new JLabel(" java:");
		jl4.setBounds(50, 170, 50, 20);
		jf.add(jl4);
		JLabel jl5=new JLabel("C语言:");
		jl5.setBounds(43, 210, 50, 20);
		jf.add(jl5);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 50, 180, 20);
		jf.add(jt1);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 90, 180, 20);
		jf.add(jt2);
		final JTextField jt3=new JTextField();
		jt3.setBounds(100, 130, 180, 20);
		jf.add(jt3);
		final JTextField jt4=new JTextField();
		jt4.setBounds(100, 170, 180, 20);
		jf.add(jt4);
		final JTextField jt5=new JTextField();
		jt5.setBounds(100, 210, 180, 20);
		jf.add(jt5);
		JButton jb=new JButton("确认更新");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jt1.getText().toString().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "学生成绩更新失败", "错误提示",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con =DriverManager.getConnection(Url,User,Pass);
						PreparedStatement ps=con.prepareStatement("update gradeinfor set chinese=?,math=?,java=?,c=? where no=? ");
						ps.setString(1, jt2.getText().toString().trim());
						ps.setString(2, jt3.getText().toString().trim());
						ps.setString(3, jt4.getText().toString().trim());
						ps.setString(4, jt5.getText().toString().trim());
						ps.setString(5, jt1.getText().toString().trim());
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "学生成绩更新成功", "成功提示",JOptionPane.INFORMATION_MESSAGE);
						ps.close();
						con.close();
					}catch(Exception ex)
					{
						System.out.println();
					}
				}
				
				
			}
		});
		jb.setBounds(120, 260, 90, 25);
		jf.add(jb);
		jf.setVisible(true);
	}
}
