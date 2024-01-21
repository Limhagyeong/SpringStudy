package com.sist.di;
import java.util.*;
import java.sql.*;
// commdatabase => 하나만 만들어놓으면 됨 (재사용성)
public class CommonsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String url,username,password; // setterDI로 넘겨받음
	
	public CommonsDAO(String driver) // 객체 생성 후 값을 채워야함 => 생성자가 우선 순위 (생성자DI)
	{
		try
		{
			Class.forName(driver);
		}catch(Exception ex) {}
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//연결
	public Connection getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception ex) {}
		
		return conn;
	}
	// 해제
	public void disConnection(Connection conn, PreparedStatement ps)
	{
		try
		{
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
		}catch(Exception ex) {}
	}
	
	
}
