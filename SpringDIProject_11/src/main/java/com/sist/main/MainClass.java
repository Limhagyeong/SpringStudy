package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component
/*
 * @Component => (value={TYPE})
 * =>  사용 위치 ==> 클래스에만 적용
 * 
 * @Autowired => value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE}
 * => 사용 위치
 *  class A
 *  {
 *  	@
 *  	B b
 *  	@
 *  	public A(){}
 *  	@
 *  	public void display(){}
 *  	public A(@B b){}
 *  }
 * 
 * 
 */
public class MainClass {
	//@Autowired + @Qualifier = @Resource(1.8)
	@Autowired
	 // 하나의 인터페이스를 여러개의 DAO에 올렸을 때 어떤 객체를 가지고올건지 설정해준다
	@Qualifier("memberDAO")
	private OracleDB ob;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.ob.display(); // 동일한 인터페이스로 접근할 시 오류난다 => @Qualifier("memberDAO")로 해결
	}

}
