package com.sist.main;
import com.sist.dao.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		CategoryDAO cDao=app.getBean("cDao",CategoryDAO.class);
		FoodDAO fDao=app.getBean("fDao",FoodDAO.class);
		List<CategoryVO> list=cDao.foodCategoryData();
		for(CategoryVO vo:list)
		{
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
		System.out.println("=================================");
		Scanner scan=new Scanner(System.in);
		System.out.println("카테고리선택(1~10)");
		int cno=scan.nextInt();
		List<FoodVO> fList=fDao.foodCategoryListData(cno);
		CategoryVO cvo=cDao.CategoryInfoData(cno);
		for(FoodVO vo:fList)
		{
			System.out.println(vo.getFno()+" "
					+vo.getName()+" "
					+vo.getAddress()+" "
					+vo.getPhone()+" "
					+vo.getType());
		}
		System.out.println("=================================");
		System.out.print("맛집 선택:");
		int fno=scan.nextInt();
		FoodVO fvo=fDao.foodDetailData(fno);
		
		
		System.out.println("=================================");
		System.out.println(cvo.getTitle());
		System.out.println(cvo.getSubject());
		System.out.println("=================================");
		System.out.println(fvo.getFno());
		System.out.println(fvo.getName()+"("+fvo.getScore()+")");
		System.out.println(fvo.getAddress());
		System.out.println(fvo.getScore());
		System.out.println(fvo.getPhone());
		System.out.println(fvo.getParking());
		System.out.println(fvo.getType());
		System.out.println(fvo.getTime());
		System.out.println(fvo.getMenu());
		
	}
	

}
