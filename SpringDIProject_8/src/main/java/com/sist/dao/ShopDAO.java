package com.sist.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopDAO {
private ShopMapper mapper;

public void setMapper(ShopMapper mapper) {
	this.mapper = mapper;
}

public List<ShopVO> shopListData(){
	return mapper.shopListData();
	
}
public ShopVO shopDetailData(int no) {
	return mapper.shopDetailData(no);
	
}
}
