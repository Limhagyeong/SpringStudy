package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
@Repository
public class BoardDAO2 {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public BoardDAO2(){
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception ex){}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
		}catch(Exception ex) {}
	}
	//SqlSessionFactoryBean이 처리해줌
//	@Transactional
	// 답변하기
	/*
	 * 	Insert => commit 입고 ==> 정상수행
	 * 	
	 *  Insert => commit 재고 ==> error : 수량 맞지않음
	 *  
	 *  문제 해결 => 둘 다 정상 수행된다면 한번에 commit / 둘 중 하나라도 오류나면 rollback 
	 *   ===> 일괄처리 (트랜잭션)
	 */
	public void boardReplyInsert(int pno,BoardVO vo)
	{
		try
		{
			// 연결
			getConnection();
			// commit => 해제
			conn.setAutoCommit(false); // @Around
			String sql="SELECT group_id,group_step,group_tab FROM springReplyBoard "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();	
			rs.next();
			int gi=rs.getInt(1);
			int gs=rs.getInt(2);
			int gt=rs.getInt(3);
			rs.close();
			ps.close();
			
			// update => gs, gt 증가시켜줌 
			/*					 gi		gs		gt
			 *  AAAAA			  1      0 		 0	
			 *    => EEEEE        1      1       1  ((O))             	
			 *    => BBBBB 	      1      1       1   ==> 1 2 1 (O)
			 *    => EEEEE        1      1       1  ((X))
			 *      => CCCCC      1		 2       2   ==> 1 3 2 (O)
			 *  DDDDD			  2      0        
			 */
			sql="UPDATE springReplyBoard SET"
					+ "group_step=group_step+1"
					+ "WHERE group_id=? AND group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate(); // AutoCommit => 얘를 무력화시킨당! => conn.setAutoCommit(false); 
			ps.close();
			// insert
			sql="INSERT INTO springReplyBoard VALUES("
					+ "sr_no_seq.nextval,?,?,?,?,SYSDATE,0,?,?,?,?,0)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, pno); // => root
			ps.executeUpdate(); // AutoCommit => 얘를 무력화시킨당! => conn.setAutoCommit(false); 
			ps.close();
		    // update
			sql="UPDATE springReplyBoard SET "
					+ "depth=depth+1 "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate(); // AutoCommit => 얘를 무력화시킨당! => conn.setAutoCommit(false); 
			ps.close();
			conn.commit(); // @Around
		}
		catch(Exception ex)
		{
			try
			{
				conn.rollback(); //@AfterThrowing
				ex.printStackTrace();
			}catch(Exception e) {}
		}
		finally
		{
			try
			{
				conn.setAutoCommit(true); //@After
				disConnection();
				
			}catch(Exception e) {}
		}
	}
	// 삭제하기
}
