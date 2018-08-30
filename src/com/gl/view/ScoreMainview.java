package com.gl.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ScoreMainview extends Mainview{
	

 static String aa=name;
 static String bb=role;
	public ScoreMainview(String a, String b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}


	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";
	
	
	public static void main(String [] args)
	{
		initview();
	}

	
	public static void initview()
	{
		
		final JFrame jf=new JFrame("学生成绩管理"+" "+"登陆者:"+aa+"角色:"+bb);
		jf.setLayout(null);
		jf.setBounds(100, 0, 1000, 800);
		JLabel jl1=new JLabel("学号");
		jl1.setBounds(100, 80, 30, 20);
		jf.add(jl1);
		JLabel jl2=new JLabel("语文");
		jl2.setBounds(260, 80, 30, 20);
		jf.add(jl2);
		JLabel jl3=new JLabel("数学");
		jl3.setBounds(420, 80, 30, 20);
		jf.add(jl3);
		JLabel jl4=new JLabel("java");
		jl4.setBounds(580, 80, 30, 20);
		jf.add(jl4);
		JLabel jl5=new JLabel("c语言");
		jl5.setBounds(740, 80, 80, 20);
		jf.add(jl5);
		JButton jb1=new JButton("添加成绩");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tianscore tscore=new Tianscore();
				tscore.initscore();
				
			}
		});
		jb1.setBounds(150, 550, 200, 20);
		jf.add(jb1);
		final JTable jtb1=new JTable();	
		jtb1.setBounds(100,100,800,400);
		jf.add(jtb1);
		JButton jb=new JButton("查询学生成绩");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				String [][]a=new String [1000][5];
				try {
					String[] liename={"学号","语文","数学","java","c"};
					Class.forName("com.mysql.jdbc.Driver");		
					Connection con=DriverManager.getConnection(Url,User,Pass);
					Statement stat=con.createStatement();
					ResultSet rs=stat.executeQuery("select * from gradeinfor");	
					while(rs.next())
					{
						a[i][0]=rs.getString("no");
						a[i][1]=rs.getString("chinese");
						a[i][2]=rs.getString("math");
						a[i][3]=rs.getString("java");
						a[i][4]=rs.getString("c");
						i++;
					}
					/*for(int p=0;p<2;p++)
					{
						for(int j=0;j<7;j++)
						{
							System.out.print(a[p][j]+"  ");
						}
						System.out.println();
					}*/
					jtb1.setVisible(false);
					JTable jtb=new JTable(a, liename);
					jtb.setBounds(100,100,800,400);
					jf.add(jtb);
					/*stat.close();
					rs.close();
					con.close();*/	
			}
				catch(Exception ex)
				{
					System.out.println("error");
				}
			}
		});
		jb.setBounds(400, 550, 200, 20);
		jf.add(jb);
		
		JButton jb5=new JButton("更新学生成绩");
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GenxinScore gxsc=new GenxinScore();
				gxsc.genxinscore();
				
			}
		});
		jb5.setBounds(400, 600, 200, 20);
		jf.add(jb5);
		JButton jb4=new JButton("删除学生成绩");
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DelStudentScore delsc=new DelStudentScore();
				delsc.delstuscore();
				
			}
		});
		jb4.setBounds(150, 600, 200, 20);
		jf.add(jb4);
		
		JButton jb2=new JButton("刷新");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreMainview scmview=new ScoreMainview(aa,bb);
				scmview.initview();
				jf.setVisible(false);
				
			}
		});
		jb2.setBounds(650, 600, 200, 20);
		jf.add(jb2);
		JButton jb3=new JButton("返回");
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				Mainview mv=new Mainview(aa,bb);
				
				mv.init();
				jf.setVisible(false);
				
			}
		});
		jb3.setBounds(650, 550, 200, 20);
		jf.add(jb3);
		jf.setVisible(true);
	}
}
