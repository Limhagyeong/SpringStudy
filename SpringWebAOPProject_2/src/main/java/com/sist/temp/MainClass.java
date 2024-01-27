package com.sist.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.*;
@Component("mc")
public class MainClass {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		String pwd="1234";
		String enPwd=mc.encoder.encode(pwd);
		System.out.println(enPwd); 
		// => $2a$10$fC.XMB0UIo971NM8YI2dWenZmMmVe8ZSWzFoWq8QX9LxF7iqUbUFK => 암호화된 pwd 
		
		// 복호화
		Scanner scan=new Scanner(System.in);
		System.out.println("비밀번호 입력:");
		String myPwd=scan.next();
		
		if(mc.encoder.matches(myPwd, enPwd)) 
		{
			System.out.println("완료");
		}
		else
		{
			System.out.println("실패");
		}
	}

}
