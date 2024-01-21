package com.sist.ann;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 *  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	 	p:dataSource-ref="ds"
	 />
 */
// 메모리 할당 => <bean id="ssf"
@Component("ssf")
// 지정하지 않는 경우 => mySqlSessionFactoryBean (클래스명 앞자리가 소문자로 바뀌어 자동 id명칭으로 부여된다)
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

	// 데이터 소스를 찾아서 값을 넣어줌 => 자동으로 getBean()
	@Autowired 
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
}
