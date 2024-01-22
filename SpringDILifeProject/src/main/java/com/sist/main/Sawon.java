package com.sist.main;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
// => 자동 호출 메소드 (순서 확인만 하면 됨) ==> 컨테이너의 역할!
import lombok.Data;


public class Sawon implements InitializingBean,DisposableBean,BeanNameAware{
	private int sabun;
	private String name;
	private String dept;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		System.out.println("setSabun() Call");
		this.sabun = sabun;
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		System.out.println("setName() Call");
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		System.out.println("setDept() Call");
		this.dept = dept;
	}
	// 프로그래머에 의해 호출되는 메소드
	public void print()
	{
		System.out.println("사번:"+sabun);
		System.out.println("이름:"+name);
		System.out.println("부서명:"+dept);
	}
	// init-method
	public void init()
	{
		System.out.println("=== 사원정보 ===");
	}
	// destroy-method
	public void destroy() {
		System.out.println("=== 객체 소멸 ===");
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("빈 이름 설정 => Map에 저장되는 상태");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setter 설정 완료");
	}
	
}