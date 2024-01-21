package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] xml= {"application_board.xml","application_notice.xml"};
		// 클래스를 한번에 읽을 때는 배열을 사용해서 xml을 모아준다
		ApplicationContext app=new ClassPathXmlApplicationContext("application_*.xml");
		// or => "application_*.xml (패턴 사용)
		Board b=(Board)app.getBean("board");
		System.out.println(b.getNo());
		System.out.println(b.getName());
		System.out.println(b.getSubject());
		System.out.println("=================================");
		Notice n=app.getBean("notice",Notice.class);
		System.out.println(n.getNo());
		System.out.println(n.getName());
		System.out.println(n.getContent());
	}
}
