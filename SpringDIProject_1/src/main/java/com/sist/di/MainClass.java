package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application1.xml");
		DeptDAO dDao=(DeptDAO)app.getBean("dDao");
		List<DeptVO> list=dDao.deptListData();
//		dDao.init();
		for(DeptVO vo:list)
		{
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
		}
		
		System.out.println("======================");
		
		EmpDAO eDao=(EmpDAO)app.getBean("eDao");
		List<EmpVO> elist=eDao.empListData();
//		eDao.init();
		for(EmpVO vo:elist)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getHiredate().toString());
		}
	}

}
