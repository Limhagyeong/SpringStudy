package com.sist.dao;

import java.util.List;

public class SeoulDAO {
 private SeoulMapper mapper;

public void setMapper(SeoulMapper mapper) {
	this.mapper = mapper;
}
public List<SeoulVO> seoulListData() {
	return mapper.seoulListData();
}
public SeoulVO seoulDetailData(int no) {
	return mapper.seoulDetailData(no);
}
public List<SeoulVO> seoulDetailData(String title){
	return mapper.seoulFindData(title);
}
 
}
