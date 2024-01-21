package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.ShopDAO;
import com.sist.dao.ShopVO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao=(ShopDAO)app.getBean("dao");
		List<ShopVO> list=dao.shopListData();
		for(ShopVO vo:list)
		{
			System.out.println(vo.getNo()+" "+vo.getTitle());
		}
		System.out.println("===================");
		Scanner scan=new Scanner(System.in);
		System.out.println("번호 입력:");
		int no=scan.nextInt();
		ShopVO vo=dao.shopDetailData(no);
		System.out.println("번호:"+vo.getNo());
		System.out.println("장소:"+vo.getTitle());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("설명:"+vo.getMsg());
	}

}
