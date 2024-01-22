package com.sist.dao;

public class MyDAO {
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	public void disConnection()
	{
		System.out.println("오라클 해제");	
	}
	/*
	 *  공통모듈 => 반복 구간 (get, disConnection) ===> AOP는 반복 구간이 나올 때 사용
	 *  				 => 스프링에 의해서 자동 호출
	 *  핵심모듈 => 프로그래머는 핵심만 코딩하면 된다!
	 *  
	 *  **AOP ====> 반복을 제거하는 역할 (트랜잭션, 로그파일, 보안)
	 *  			=> 사용자 정의 AOP는 극히 드물다
	 *  			=> Footer
	 *  **사용하는 디자인 패턴 : proxy 패턴 => 대신 호출 (반복되는 코드를 묶어서 새로운 클래스를 생성함)
	 *  
	 */
	public void select()
	{
		getConnection();
		System.out.println("select 문장 수행 요청");
		disConnection();
	}
	public void insert() {
		getConnection();
		System.out.println("insert 문장 수행 요청");
		disConnection();
	}
	public void update()
	{
		getConnection();
		System.out.println("update 문장 수행 요청");
		disConnection();
	}
	public void delete()
	{
		getConnection();
		System.out.println("delete 문장 수행 요청");
		disConnection();
	}
}
