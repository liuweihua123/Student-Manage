package com.gl.view;
import com.gl.*;

import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class Mainview {

	/**
	 * 主程序页面
	 */
	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";
	static String name;
	static String role;
	
	public static void main(String[] args) {
		
		init();

	}
	public Mainview(String a,String b)
	{
		name=a;
		role=b;
	}
	public static void init()
	{
		

		
		final JFrame jf=new JFrame("学生信息管理系统"+" "+"登陆者:"+name+"角色:"+role);
		jf.setBounds(100,0,1000,800);
		jf.setLayout(null);
		JLabel jl1=new JLabel("欢迎来到学生管理系统！");
		jl1.setBounds(400, 20,200, 40);
		jf.add(jl1);
		final JTable jtb1=new JTable();
		jtb1.setSize(40, 20);
		jtb1.setBounds(100,100,800,400);
		jf.add(jtb1);
		
		JLabel jl2=new JLabel("学号");
		jl2.setBounds(100, 80, 40, 20);
		jf.add(jl2);
		JLabel jl3=new JLabel("姓名");
		jl3.setBounds(210, 80, 50, 20);
		jf.add(jl3);
		JLabel jl4=new JLabel("性别");
		jl4.setBounds(325, 80, 50, 20);
		jf.add(jl4);
		JLabel jl5=new JLabel("身份证号");
		jl5.setBounds(440, 80, 100, 20);
		jf.add(jl5);
		JLabel jl6=new JLabel("班级");
		jl6.setBounds(560, 80, 50, 20);
		jf.add(jl6);
		JLabel jl7=new JLabel("专业");
		jl7.setBounds(670, 80, 50, 20);
		jf.add(jl7);
		JLabel jl8=new JLabel("学校名称");
		jl8.setBounds(780, 80, 100, 20);
		jf.add(jl8);
		JButton jb1=new JButton("学生成绩管理");
		jb1.setBounds(150, 550, 200, 20);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreMainview scmv=new ScoreMainview(name,role);
				scmv.initview();
				jf.setVisible(false);
				
			}
		});
		jf.add(jb1);
		
		JButton jb4=new JButton("删除学生信息");
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DelStudentInformation delsi=new DelStudentInformation();
				delsi.delgraph();
				
			}
		});
		jb4.setBounds(150, 600, 200, 20);
		jf.add(jb4);
		
		
		JButton jb6=new JButton("查询单个学生信息");
		jb6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QuerySingleStudent quss=new QuerySingleStudent();
				quss.queryss();
				
				
			}
		});
		jb6.setBounds(150, 650, 200, 20);
		jf.add(jb6);
		
		
		JButton jb2=new JButton("添加学生信息");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tianjiaview tjview=new Tianjiaview();
				tjview.tianview();
				
				
			}
		});
		jb2.setBounds(650, 550, 200, 20);
		jf.add(jb2);
		
		JButton jb3=new JButton("刷新");
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Mainview mn=new Mainview(name,role);
				mn.init();
				jf.setVisible(false);
				
			}
		});
		jb3.setBounds(650, 600, 200, 20);
		jf.add(jb3);
		
		JButton jb5=new JButton("更新学生信息");
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GenxinStudent gxst=new GenxinStudent();
				gxst.genxinview();
				
			}
		});
		jb5.setBounds(400, 600, 200, 20);
		jf.add(jb5);
		
		JButton jb=new JButton("查询学生信息");
		jb.addActionListener(new ActionListener() {
			
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String [][]a=new String [1000][7];				
				int i=0;	
			try {
					String[] liename={"学号","姓名","性别","身份证号","班级","专业","学校"};
					Class.forName("com.mysql.jdbc.Driver");		
					Connection con=DriverManager.getConnection(Url,User,Pass);
					Statement stat=con.createStatement();
					ResultSet rs=stat.executeQuery("select * from studentinfor");	
					while(rs.next())
					{
						a[i][0]=rs.getString("no");
						a[i][1]=rs.getString("name");
						a[i][2]=rs.getString("sex");
						a[i][3]=rs.getString("idcard");
						a[i][4]=rs.getString("banji");
						a[i][5]=rs.getString("major");
						a[i][6]=rs.getString("school");
						i++;
					}
			
					jtb1.setVisible(false);
					JTable jtb=new JTable(a, liename);
					jtb.setBounds(100,100,800,400);
					jf.add(jtb);
					stat.close();
					rs.close();
					con.close();	
					
			}
				catch(Exception ex)
				{
					System.out.println("error");
				}
				
			}
		});
			
		jb.setBounds(400, 550, 200, 20);
		jf.add(jb);
		
		
		jf.setVisible(true);
	}

}
