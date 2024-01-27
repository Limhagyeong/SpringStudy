package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_poster,num "
			+ "FROM(SELECT no,goods_name,goods_poster,ROWNUM as num "
			+ "FROM(SELECT no,goods_name,goods_poster "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int totalPage();
	/*
	 *  NO                                        NOT NULL NUMBER
	 GOODS_NAME                                NOT NULL VARCHAR2(1000)
	 GOODS_SUB                                          VARCHAR2(1000)
	 GOODS_PRICE                               NOT NULL VARCHAR2(50)
	 GOODS_DISCOUNT                                     NUMBER
	 GOODS_FIRST_PRICE                                  VARCHAR2(20)
	 GOODS_DELIVERY                            NOT NULL VARCHAR2(20)
	 GOODS_POSTER                                       VARCHAR2(260)
	 HIT                                                NUMBER
	 */
	@Select("SELECT no,goods_name,goods_poster,goods_price "
			+ "FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	@Select("SELECT no,goods_name,goods_poster,num "
			+ "FROM(SELECT no,goods_name,goods_poster,ROWNUM as num "
			+ "FROM(SELECT no,goods_name,goods_poster "
			+ "FROM ${tname} WHERE goods_name LIKE '%'||#{ss}||'%' ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsFindListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${tname} "
			+ "WHERE goods_name LIKE '%'||#{ss}||'%'")
	public int findTotalPage(Map map);
}
