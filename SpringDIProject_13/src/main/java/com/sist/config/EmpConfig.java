package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
// 	<context:component-scan base-package="com.sist.*"></context:component-scan>
@ComponentScan(basePackages ="com.sist.*")
public class EmpConfig {
/*
 * <bean id="ds" 
	class="org.apache.commons.dbcp.BasicDataSource"
	p:driverClassName="oracle.jdbc.driver.OracleDriver"
	p:url="jdbc:oracle:thin:@localhost:1521:XE" 
	p:username="hr"
	p:password="happy" />
 */
	@Bean("ds")
	public BasicDataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 * <bean id="ssf" 
	class="org.mybatis.spring.SqlSessionFactoryBean"
	p:dataSource-ref="ds" 
	/>
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean() throws Exception
	{
		MapperFactoryBean mapper=new MapperFactoryBean();
		mapper.setSqlSessionFactory(sqlSessionFactory());
		mapper.setMapperInterface(com.sist.mapper.EmpMapper.class);
		return mapper;
	}
}
