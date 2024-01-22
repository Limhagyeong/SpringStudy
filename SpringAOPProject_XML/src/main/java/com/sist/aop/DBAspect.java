package com.sist.aop;
// 자동 호출을 위해 만들어둔다
public class DBAspect {
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	public void disConnection()
	{
		System.out.println("오라클 해제");	
	}
}
