package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository("dao")
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private MyDataSource ds;
	/*
	 * 	@Autowired
	 *  => 자동 주입
	 *  public class A
	 *  {
	 *  	@Autowired
	 *  	private B b; => filed
	 *  
	 *  	@Autowired
	 *  	public A(B b) => 생성자
	 *  	{
	 *  	}
	 *  	@Autowired
	 *  	public void setB(B b) => setter
	 *  	{
	 *  	}
	 *  	@Autowired
	 *  	public void init(B b) => 일반 메소드
	 *  	{
	 *  	}
	 *  }
	 *  Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
	 */
	@Autowired
	public EmpDAO(MyDataSource ds)
	{
		this.ds=ds;
		try
		{
			Class.forName(ds.getDriver());
		}catch(Exception ex) {}
	}
	
	// before
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		}catch(Exception ex) {}
	}
	//after
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
	// 전체 목록
	public List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		// before => getConnection
		try
		{
			//around
			String sql="SELECT empno, ename, job, TO_CHAR(hiredate,'YYYY-MM-DD'),sal "
					+ "FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
			
			//around
		}
		catch(Exception ex)
		{
			// after throwing => 자주 사용하진 않음
			ex.printStackTrace();
		}
		finally
		{
			// after => disConnection
		}
		return list; //=> After-Returning
	}
	// 상세보기
	public EmpVO empDetailList(int empno)
	{
		EmpVO vo=new EmpVO();
		try
		{
			String sql="SELECT empno, ename, job, TO_CHAR(hiredate,'YYYY-MM-DD'),sal "
					+ "FROM emp "
					+ "WHERE empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setDbday(rs.getString(4));
			vo.setSal(rs.getInt(5));
			rs.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			
		}
		return vo;
	}
}
