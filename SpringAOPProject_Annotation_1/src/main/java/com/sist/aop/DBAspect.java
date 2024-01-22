package com.sist.aop;
import com.sist.dao.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//<aop:aspect ref="aspect">
@Aspect //=> 메모리할당이랑은 연관 없음 (공통 사용 부분이라는것만 알려주는 용도)
        // => <aop:aspectj-autoproxy/>
@Component
public class DBAspect {
	@Autowired
	private EmpDAO dao;
	// 1. before
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void before()
	{
		dao.getConnection();
		System.out.println("=== 오라클 연결 자동 호출 === : 콜백함수");
	}
	// 2. after
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void after()
	{
		dao.disConnection();
		System.out.println("=== 오라클 연결 해제 자동 호출 === : 콜백함수");
	}
	// 3. around
	@Around("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("=== 사용자 로그 자동 호출 === : 콜백함수");
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출된 메소드:"+jp.getSignature().getName());
		obj=jp.proceed();
		long end=System.currentTimeMillis();
		System.out.println("걸린 시간:"+(end-start));
		return obj;
	}
	
}
