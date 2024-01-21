package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface ShopMapper {
 @Select("SELECT no, title FROM seoul_shop")
 public List<ShopVO> shopListData();
 
 @Select("SELECT no,title,address,msg FROM seoul_shop WHERE no=#{no}")
 public ShopVO shopDetailData(int no);
}
