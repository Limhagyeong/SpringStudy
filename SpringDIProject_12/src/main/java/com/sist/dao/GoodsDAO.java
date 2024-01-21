package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.main.Component;
import com.sist.mapper.GoodsMapper;

@Repository("gDao")
public class GoodsDAO {
	@Autowired
 private GoodsMapper mapper;
	public List<GoodsVO> goodsListData(int no)
	{
		return mapper.goodsListData(no);
	}
}
