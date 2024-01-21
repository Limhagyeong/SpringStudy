package com.sist.main;

import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

/*
 * 	@AutoWired : 반드시 스프링에서 메모리 할당을 해야 자동으로 주입이 가능
 * 	
 *  class A
 *  {
 *  	@AutoWired
 *  	B b; ====> Null => 메모리 할당 X
 *  }
 *  @Component => 메모리 할당 O
 *  class B
 *  {
 *  	@AutoWired
 *  	A a; ====> 주소
 *  }
 */
//@Component
import java.util.*;
import java.io.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		FoodDAO dao=(FoodDAO)app.getBean("fDao");
		Scanner scan=new Scanner(System.in);
		System.out.print("1.업체명,2.주소,3.음식종류 선택");
		int col=scan.nextInt();
		String fd="";
		String[] temp= {"","name","address","type"};
		fd=temp[col];
		System.out.println("검색어 입력:");
	    String ss=scan.next();
	    
	    Map map=new HashedMap();
	    map.put("col_name", fd);
	    map.put("ss", ss);
	    
		List<FoodVO> list=dao.foodFindData(map);
		for(FoodVO vo:list)
		{
			System.out.println(vo.getFno()+" "
					+vo.getName()+" "
					+vo.getAddress()+" "
					+vo.getType());
		}
		
	}

}
