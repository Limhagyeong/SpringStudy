package com.sist.dao;
/*
 * service => 여러개의 dao를 묶어서 한번에 데이터를 전송한다
 * 					==== 독립적
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository("cDao")
public class CategoryDAO {
	@Autowired
	private CategoryMapper mapper;
	
	public List<CategoryVO> foodCategoryData()
	{
		return mapper.foodCategoryData();
	}
	public CategoryVO CategoryInfoData(int cno)
	{
		return mapper.CategoryInfoData(cno);
	}
}
