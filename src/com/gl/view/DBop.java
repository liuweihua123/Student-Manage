package com.gl.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBop {
	static Connection con=null;
	static ResultSet rs=null;
	public static final String Url="jdbc:mysql://localhost:3306/javaproject?characterEncoding=utf8";
	public static final String User="root";
	public static final String Pass="toor";
	
	public static ResultSet query(String sql) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(Url,User,Pass);
		Statement stat=con.createStatement();
		rs=stat.executeQuery(sql);
		return rs;
		
	}
	
	public void close()
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
