package com.sist.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sawon=new Sawon();
		sawon.display();
		Proxy p=new Proxy(sawon);
		p.display();
	}

}
