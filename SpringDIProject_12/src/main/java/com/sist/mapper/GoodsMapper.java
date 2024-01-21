package com.sist.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.dao.GoodsVO;


public interface GoodsMapper {
	public List<GoodsVO> goodsListData(int no);
}
