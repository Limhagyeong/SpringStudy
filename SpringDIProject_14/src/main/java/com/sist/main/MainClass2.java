package com.sist.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.SeoulGoodsConfig;
import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;
import com.sist.dao.SeoulDAO;
import com.sist.dao.SeoulVO;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(SeoulGoodsConfig.class);
		
		SeoulDAO sDao=(SeoulDAO)app.getBean("sDao");
		GoodsDAO gDao=(GoodsDAO)app.getBean("gDao");
		String[] stable= {"","seoul_location","seoul_nature","seoul_shop"};
		String[] gtable= {"","goods_all","goods_best","goods_special","goods_new"};
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("===== 메뉴 =====");
			System.out.println("1.여행");
			System.out.println("2.상품");
			System.out.println("3.종료");
			System.out.println("===============");
			System.out.print("선택:");
			int index=scan.nextInt();
			if(index==1)
			{
				System.out.println("==== 서브메뉴 ====");
				System.out.println("1.명소");
				System.out.println("2.자연");
				System.out.println("3.쇼핑");
				System.out.println("===============");
				System.out.print("여행 선택:");
				int sno=scan.nextInt();
				String table_name=stable[sno];
				Map map=new HashedMap();
				map.put("table_name", table_name);
				List<SeoulVO> list=sDao.seoulListData(map);
				for(SeoulVO vo:list)
				{
					System.out.println(vo.getNo()+"."+vo.getTitle());
				}
				System.out.println("==============");
				System.out.println("상세 볼 여행 번호 선택");
				int no=scan.nextInt();
				map.put("no", no);
				SeoulVO vo=sDao.seoulDetailData(map);
				System.out.println("여행지:"+vo.getTitle());
				System.out.println("여행지 소개:"+vo.getMsg());
				System.out.println("여행지 주소:"+vo.getAddress());
			}
			else if(index==2)
			{
				System.out.println("==== 서브메뉴 ====");
				System.out.println("1.전체");
				System.out.println("2.베스트");
				System.out.println("3.특가");
				System.out.println("4.신상");
				System.out.println("===============");
				System.out.print("상품 선택:");
				int gno=scan.nextInt();
				String table_name=gtable[gno];
				Map map=new HashedMap();
				map.put("table_name", table_name);
				List<GoodsVO> list=gDao.goodsListData(map);
				for(GoodsVO vo:list)
				{
					System.out.println(vo.getNo()+"."+vo.getName());
				}
				System.out.println("==============");
				System.out.println("상세 볼 상품 번호 선택");
				int no=scan.nextInt();
				map.put("no", no);
				GoodsVO vo=gDao.goodsDetailData(map);
				System.out.println("상품명:"+vo.getName());
				System.out.println("상품가격:"+vo.getPrice());
				System.out.println("상품할인가:"+vo.getDiscount()+"%");
			}
			
			else
			{
				System.out.println("프로그램 종료");
				break;
			}
		}
	}


	}

