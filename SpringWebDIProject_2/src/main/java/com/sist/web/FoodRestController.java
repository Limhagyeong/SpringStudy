package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	// 자바스크립트로 데이터를 보내준다
	@RequestMapping(value="food/find_vue.do",produces = "text/plain;charset=UTF-8")
	public String find_vue(String page,String fd)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowsize=12;
		int start=(curpage*rowsize)-(rowsize-1);
		int end=(curpage*rowsize);
		Map map=new HashedMap();
		map.put("start",start);
		map.put("end",end);
		map.put("address",fd);
		
		List<FoodVO> list=dao.foodfindListData(map);
		JSONArray arr=new JSONArray();
		for(FoodVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("poster", vo.getPoster());
			arr.add(obj);
		}
		return arr.toJSONString();
	}
}
