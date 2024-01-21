package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
// DI => 클래스간의 연결관계를 맺어준다 (의존관계 설정) => 클래스간의 관계도를 만들어감 (넓은 의미)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getEname()+" "+vo.getJob()+" "+
								vo.getHiredate().toString()+" "+
								vo.getSal());
		}
		
//		System.out.println("====================================");
//		Scanner scan=new Scanner(System.in);
//		System.out.println("사번입력:");
//		int empno=scan.nextInt();
//		EmpVO vo=dao.empDetailData(empno);
//		System.out.println(vo.getEname()+" "+vo.getEname()+" "+vo.getJob()+" "+
//				vo.getHiredate().toString()+" "+
//				vo.getSal());
		
//		System.out.println("====================================");
//		DeptDAO dao2=(DeptDAO)app.getBean("dao2");
//		List<DeptVO> list2=dao2.deptListData();
//		
//		for(DeptVO vo2:list2)
//		{
//			System.out.println(vo2.getDeptno()+" "+vo2.getDname()+" "+vo2.getLoc());
//		}
	}

}
