package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.StudentDAO;
import com.sist.dao.StudentVO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 메모리 할당
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// new 사용 시 null값 들어옴
		StudentDAO dao=(StudentDAO)app.getBean("dao");
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("===== 메뉴 =====");
			System.out.println("1.목록");
			System.out.println("2.상세보기");
			System.out.println("3.추가하기");
			System.out.println("4.수정하기");
			System.out.println("5.삭제하기");
			System.out.println("6.종료");
			System.out.println("===============");
			System.out.print("메뉴선택");
			int menu=scan.nextInt();
			if(menu<1 || menu>6)
			{
				System.out.println("없는 메뉴입니다");
				continue;
			}
			
			if(menu==6)
			{
				System.out.println("프로그램이 종료되었습니다");
				break;
			}
			else if(menu==1)
			{
				List<StudentVO> list=dao.studentListData();
				for(StudentVO vo:list)
				{
					System.out.println(vo.getHakbun()+" "+
										vo.getName());
				}
			}
			else if(menu==2)
			{
				System.out.println("학번을 입력하시오:");
				int hakbun=scan.nextInt();
				StudentVO vo=dao.studentDetailData(hakbun);
				System.out.println("학번:"+vo.getHakbun());
				System.out.println("이름:"+vo.getName());
				System.out.println("국어점수:"+vo.getKor());
				System.out.println("영어점수:"+vo.getEng());
				System.out.println("수학점수:"+vo.getMath());
			}
			else if(menu==3)
			{
				System.out.println("이름을 입력하시오:");
				String name=scan.next();
				System.out.println("국어점수를 입력하시오:");
				int kor=scan.nextInt();
				System.out.println("수학점수를 입력하시오:");
				int math=scan.nextInt();
				System.out.println("영어점수를 입력하시오:");
				int eng=scan.nextInt();
				
				StudentVO vo=new StudentVO();
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMath(math);
				
				dao.studentInsert(vo);
				System.out.println("저장완료");
			}
			else if(menu==4)
			{
				System.out.println("이름을 입력하시오:");
				String name=scan.next();
				System.out.println("국어점수를 입력하시오:");
				int kor=scan.nextInt();
				System.out.println("수학점수를 입력하시오:");
				int math=scan.nextInt();
				System.out.println("영어점수를 입력하시오:");
				int eng=scan.nextInt();
				
				System.out.println("학번을 입력하시오:");
				int hakbun=scan.nextInt();
				
				StudentVO vo=new StudentVO();
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMath(math);
				
				dao.studentUpdate(vo);
				System.out.println("수정완료");
			}
			else if(menu==5)
			{
				System.out.println("학번을 입력하시오:");
				int hakbun=scan.nextInt();
				
				dao.studentDelete(hakbun);
				System.out.println("삭제완료");
			}
		}
		
	}

}
