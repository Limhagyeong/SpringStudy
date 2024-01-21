package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.Member;
import com.sist.spring.Sawon;

// 스프링이 관리하는 클래스가 아니다
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		Sawon s=(Sawon)app.getBean("sawon");
		System.out.println(s.getSabun());
		System.out.println(s.getName());
		System.out.println(s.getSex());	
		
		Member member=(Member)app.getBean("member1");
		member.print();
		
		Member member2=(Member)app.getBean("member2");
		member2.print();
	}

}
