package com.sist.aop;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
@Aspect
@Component
/*
 * 	1. 모니터링 / 로깅 / 오류검사 (처리) / 성능 파악
 * 		=> 트랜잭션, 보안, 암호화 복호화, 데이터 읽기 => 분석
 *  = 공통된 기능 재사용하는 기법
 *  = 공통적인 내용을 모아서 관리 => 유지보수
 *  = 라이브러리 (트랜잭션, 보안)
 *  
 *  Spring FrameWork 
 *   => DI
 *   => AOP
 *   => MVC
 *   =================================
 *   
 *   1. 어떤 클래스의 메소드 => PointCut <<execution(* com.sist.web.*Controller.*(..))>>
 *   						=> execution("") : 특정 위치 지정
 *   					    => within("패키지명") : 모든 메소드
 *   2. 메소드 위치 => JoinPoint 
 *   	public String display()
 *  	 {
 *  		before
 *   		try
 *   		 {
 *   			around : 트랜잭션
 *   			====== setAutoCommit(false)
 *   			소스코딩
 *   			====== Commit()
 *   			around
 *   		 }
 *   		catch(Exception ex)
 *   		 {
 *   			after-throwing
 *   		 }
 *   		finally
 *   		 {
 *   			after 
 *   		 }
 *   		return "";
 *   			after-returning : 정상 수행 => return값을 받을 수 있다
 *   	 }
 *   
 *   	예)
 *   		@Before
 *   		public void before()
 *   		{
 *   
 *   		}
 *  		 @After
 *   		public void after()
 *   		{
 *   
 *   		}
 *   		@Around
 *   		public void around()
 *   		{
 *   
 *   		}
 *  		 @AfterReturning
 *   		public void afterReturning()
 *   		{
 *   
 *   		}
 *   		@AfterThrowing
 *   		public void afterThrowing()
 *   		{
 *   
 *   		}
 *   3. 인터셉트 : 자동 로그인 , id저장
 */
public class BoardAOP {
	@Autowired
	private BoardDAO dao; // dispatcherservlet이 처리해주는게 X => 라이브러리를 이용해서 request값 따로 받아줘야됨
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after() 
	{
		List<BoardVO> list=dao.boardTop5();
		 // 실제 사용중인 request를 얻어옴 => 실시간 쿠키 전송이 가능
		HttpServletRequest request=
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("tList", list);
	}
}
