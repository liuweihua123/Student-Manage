package com.gl.view;
import com.gl.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;
public class Zhuce {
	/*
	 * ע��ҳ��
	 */
	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";
	public static void main(String [] args)
	{
		zuce();
	}
	public static void zuce()
	{
		final JFrame jf=new JFrame("ע��");
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
		JButton jb1=new JButton("ȷ��ע��");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jt1.getText().toString().trim().equals("")&&jt2.getText().toString().trim().equals("")||jt1.getText().toString().trim().equals("")||jt2.getText().toString().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"ע��ʧ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(Url, User, Pass);
						PreparedStatement ps=con.prepareStatement("insert into userinfor(username,password,role) values(?,?,?)");
						ps.setString(1,jt1.getText().toString().trim());
						ps.setString(2, jt2.getText().toString().trim());
						ps.setString(3, "����Ա");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"ע��ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
						ps.close();
						con.close();
					}catch(Exception ex)
					{
						System.out.println("�������ݿ�ʧ��");
					}
					finally
					{
						Login lg=new Login();
						lg.initview();
						jf.setVisible(false);
					}
				}
			}
		});
		jb1.setBounds(180, 300, 120, 20);
		jf.add(jb1);
		
		jf.setVisible(true);
		
		
	}

}
