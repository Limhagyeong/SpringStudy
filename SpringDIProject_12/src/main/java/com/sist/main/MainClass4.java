package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;

import java.io.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		GoodsDAO dao=(GoodsDAO)app.getBean("gDao");
		Scanner scan=new Scanner(System.in);
		System.out.println("번호 입력:");
		int no=scan.nextInt();
		List<GoodsVO> list=dao.goodsListData(no);
		for(GoodsVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getGoods_name());
		}
	}

}
