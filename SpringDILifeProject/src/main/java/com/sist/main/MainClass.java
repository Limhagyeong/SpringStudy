package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 *  DI 생명주기 
 *  1. 컨테이너 생성 => ApplicationContext
 *  2. XML이나 Annotation을 읽어들인다 => bean 생성 (객체 생성) => 어떤 객체 생성
 *     VO , MainClass => 제외
 *  3. 주입 (setter, 생성자) 
 *  4. 초기화 콜백 함수 호출 => init-method 
 *  5. 프로그래머가 사용
 *  6. 소멸 => 콜백 함수 호출 => destroy-method
 *  7. 스프링 종료 (컨테이너 close) 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		GenericApplicationContext app=new GenericXmlApplicationContext("app.xml");
		Sawon sawon=app.getBean("sa",Sawon.class);
		sawon.print();
		app.close();
	}

}
