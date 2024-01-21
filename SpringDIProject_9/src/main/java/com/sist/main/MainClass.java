package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

/*
 * 	1. XML 버전 ===> XML 파일 공유
 *  2. Annotation -===> 개별적으로 사용이 가능
 *     => 분업화 (가장 많이 사용)
 *     Annotation 
 *      => 사용자 정의 클래스
 *      => 라이브러리 클래스 (어노테이션이 없다) => 상속
 *  3. 사용자 클래스는 어노테이션 사용
 *       라이브러리 클래스 XML => 공통 사용
 *   =====================================================
 *     4버전 형식 => 5버전 설정파일 (자바) => 6버전 분산처리
 *     									| MSA (Spring Cloud)
 *                ==============================
 *                    | 보안 (모든 파일 => 자바)
 *     스프링 
 *       => 틀 (프로그램 형식을 정리 => 모든 개발자가 동일한 포맷)
 *       	=> 형식 통일 (형식을 제공해주는) => 프레임 워크
 *       => 형식 통일
 *          1. DI => 객체 생성 
 *          		        객체 생성시에 필요한 데이터를 주입
 *  				        멤버변수 초기화
 *  						= setXxxx()
 *  						= 생성자
 *  						 개발자가 사용
 *  			     객체 소멸
 *  			     =============== 컨테이너(제공)        
 *			2. 중복 코딩
 *				 => OOP에서 단점 (자동 호출이 안된다)
 *					=> 중복 코딩 (메소드,메소드 여러개 => 클래스)
 *			     => 자동 호출이 가능
 * 				 => AOP => 단어
 *    				Before / After / After-Returning / After-Throwing
 *    				위빙 , JoinPointer , PointCut
 *    				aaa()
 *    				bbb()
 *    				ccc()
 *    				public void display()
 *    				{
 *    					try
 *    					{
 *    						Before => ex) 시작시 
 *    							   => aaa() => 자동으로 호출할 수 있도록 기능 설정 가능함! 
 *    					}
 *    					catch(exception ex)
 *    					{
 *    						@After-Throwing => 에러시 수행 ==> ccc()
 *    					}
 *    					finally
 *    					{
 *    						@After => finally 안에서 수행 ==> bbb()
 *    					}		
 *    					@After-Returning => 정상 수행시 처리			
 *    					return 
 *    				}
 *    ===================================================================
 *    1. Application
 *    2. Web Application (MVC)
 *                   
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml"); // 스프링 동작
		EmpDAO dao=(EmpDAO)app.getBean("empDAO"); // DL
		List<EmpVO> list=dao.empDeptJoinData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getDvo().getDname()+" "
					+vo.getDvo().getLoc());
					// dvo.setDname() => dvo.dname
		}
	}

}
