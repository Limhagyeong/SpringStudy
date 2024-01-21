package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
/*
 * 어노테이션 : 구분자
 * =======
 * 1. 메모리 할당 어노테이션 (선택적 어노테이션) => 클래스 별 구분을 위함!
 * 		@Component
 * 			|
 * -------------------------------------
 * |               |         |          |      @ControllerAdvice @RestControllerAdvice => 공통 예외처리
 * @repository   @Service    @Controller  @RestController
 * => DAO(저장소)   =>DAO여러개  => Model      => 다른 시스템과 연결
 * 											  Vue/React (리턴:json)
 * 
 * 2. DI (주입)
 *    @AutoWired : 스프링에서 자동으로 주소값을 찾아서 넘겨준다
 *    @Inject : 
 *    
 * 3. AOP : 공통모듈 
 *    @Aspect => @Before , @After ...
 */
@Repository
public class FoodDAO {
@Autowired
private FoodMapper mapper;

public List<FoodVO> foodListData(Map map)

{
	return mapper.foodListData(map);
}
public int foodTotalPage()
{
	return mapper.foodTotalPage();
}
}
