package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	public int totalPage()
	{
		return mapper.totalPage();
	}
	public GoodsVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	 public GoodsVO cookieData(int no)
	  {
		  return mapper.goodsDetailData(no);
	  }
	 public List<GoodsVO> goodsFindListData(Map map)
	 {
		 return mapper.goodsFindListData(map);
	 }
	 public int findTotalPage(Map map)
	 {
		 return mapper.findTotalPage(map);
	 }
}
