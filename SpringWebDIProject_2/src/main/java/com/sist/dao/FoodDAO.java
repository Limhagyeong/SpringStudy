package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;

@Repository
public class FoodDAO {
@Autowired
private FoodMapper mapper;

public List<FoodVO> foodListData(Map map){
	
	return mapper.foodListData(map);
}

public int foodTotalPage() {
	
	return mapper.foodTotalPage();
}

public FoodVO foodDetailData(int fno) {
	return mapper.foodDetailData(fno);
}

public List<FoodVO> foodfindListData(Map map){
	return mapper.foodfindListData(map);
}

public int foodFindTotalPage(String address) {
	return mapper.foodFindTotalPage(address);
}

}
