package com.sist.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.spring.Student;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app2.xml");
		// close하려면 GenericXmlApplicationContext 사용
		// ApplicationContext => close 불가
		Student std=(Student)app.getBean("std");
		System.out.println(std.getHakbun());
		System.out.println(std.getName());
		System.out.println(std.getKor());
		System.out.println(std.getMath());
		System.out.println(std.getEng());
		app.close();
	}

}
