package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
/*
 *  OOP => 객체지향프로그램에서는 반복 소스가 있는 경우 
 *  	   => 한개의 클래스 안에서 => 메소드를 만들어 처리
 *  	   => 여러개의 클래스를 만들 때 => 클래스화 처리
 *         => 자동 호출이 없다!! 
 *         => 자동호출을 위해 AOP 사용
 *  
 *  ====> AOP는 OOP를 보완한 패턴이다
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		System.out.println("====================");
		dao.insert();
		System.out.println("====================");
		dao.update();
		System.out.println("====================");
		dao.delete();
	
	}

}
