package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
@Service("fService") // => 결합성을 약하게 만들기 위함
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO dao;
	
	@Override
	public List<FoodVO> foodListData(String type) {
		// TODO Auto-generated method stub
		return dao.foodListData(type);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

}
