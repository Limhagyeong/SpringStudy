package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@ComponentScan(basePackages = "com.sist.*")
@MapperScan(basePackages = "com.sist.mapper")
public class EmpConfig {
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
@Bean("ssf")
public SqlSessionFactory sqlSessionFactory() throws Exception
{
	SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
	ssf.setDataSource(dataSource());
	Resource res=new ClassPathResource("config.xml");
	ssf.setConfigLocation(res); // => p:configLocation="classpath:config.xml"
	return ssf.getObject();
}
}
