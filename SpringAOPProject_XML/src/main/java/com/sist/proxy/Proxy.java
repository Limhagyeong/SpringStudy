package com.sist.proxy;
// 대리자 => 대신 호출이 가능하도록 해줌
/*
 *  AOP ==> 위빙은 메소드를 결합
 *  
 *  어떤 클래스의 어떤 메소드에 적용할건지 설정 => pointCut 
 *  어떤 시점 => JoinPoint
 *     before : try수행 전 
 *     after : finally 수행
 *     after-throwing : catch절 수행 => Web 오류 발생 전송
 *     after-returning : 정상 수행을 했을 때 => Web으로 전송
 *     around 
 *      로그 / 트랜젝션
 *      = 로그
 *        => 1. 시간 , 호출 메소드 => setAutoCommit(false)
 *        	 => 수행 문장
 *        => 2. 시간 => commit()
 *     
 *     PointCut + JoinPoint => Advice
 */
public class Proxy {
	private Sawon sawon;
	public Proxy(Sawon sa)
	{
		this.sawon=sa;
	}
	// 위빙 => 하나의 메소드를 만든다
	public void display()
	{
		System.out.println("Before 처리");
		sawon.display();
		System.out.println("After 처리");
	}
}
