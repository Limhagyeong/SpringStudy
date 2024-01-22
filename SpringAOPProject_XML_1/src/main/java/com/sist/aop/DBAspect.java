package com.sist.aop;
import com.sist.dao.*;
import java.util.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.SystemPropertyUtils;
// DI => Injection => setter, 생성자
// DI => 클래스와 클래스의 연결관계설정
/*
 *  aspect => 공통으로 사용되는 기능을 모아서 관리 : 공통모듈
 *  Advice
 *  ======
 *  PointCut => 어떤 메소드에 적용?
 *  JoinPoint => 위치
 *  	before => 메소드 시작 전
 *  	after => finally 수행
 *  	after-Throwing => catch 수행
 *  	after-Returning => 정상수행
 *  	around => 시간 (트랜젝션, 보안, 로그) ==> 메인 소스 전후 처리
 *  
 *		around  
 *  	=====
 *  	메인소스
 *  	=====
 *  	around
 *  =============================================
 *   통합해서 새로운 기능을 만든다 => 위빙 (Weaving) => proxy 패턴
 *   
 *   PointCut => 어떤 메소드에 적용할지 확인
 *   execution("* 패키지명.클래스명.*(..))")
 *   		    =			   =
 *   			리턴형		 모든 메소드에 매개 변수가 0개 이상인!
 *   						 (String) , (String,int) => 매개변수 지정 시
 *   모든 패키지에 있는 모든 클래스에 적용 ====> 어떤 클래스에 적용할건지 명확히 구분해야됨!!!! (항상 모든 클래스에 주는거 X)
 *   => 로그파일 
 *   	within("패키지명")
 *   
 *   => 모든 모델 클래스 => * 패키지명.*Controller.*(..)
 */
public class DBAspect {
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	// try 전
	public void before()
	{
		dao.getConnection();
	}
	// finally
	public void after()
	{
		dao.disConnection();
	}
	
	// 데이터 출력 => After-Returning
	/*
	 * <aop:after-returning method="afterReturing" 
	  	pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))"
		returning="obj" => 매개변수!!
	  	/>
	    </aop:aspect>
	 */
	public void afterReturning(Object obj)
	{
		System.out.println("==== 결과값 자동 처리 ===="); // => request.setAttribute => 자동 처리 가능!
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
			{
				System.out.println(vo.getEmpno()+" "
								   +vo.getEname()+" "
								   +vo.getDbday()+" "
								   +vo.getSal()+" "
								   +vo.getJob());
			}
	}
	// 에러 => After-Throwing ==> catch절!
	public void afterThrowing(Throwable ex)
	{
		System.out.println("===== 에러 발생 =====");
		ex.printStackTrace();
		// web => @ControllerAdvice : 공통 예외처리
	}
	// 시간 => around => 트랜젝션, 보안(이미 AOP가 제작됨) , 로그 
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출된 메소드:"+jp.getSignature().getName());
		// 사용자가 호출한 메소드
		// 메소드 호출
		obj=jp.proceed(); // dao.empListData() => invoke()
		long end=System.currentTimeMillis();
		System.out.println("수행 시간:"+(end-start));
		
		return obj;
	}
}
