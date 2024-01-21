package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
@Controller // => 브라우저랑 연결되는 class임을 알림!
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/list.do")
	public String food_list(String page,Model model) // Model => 데이터를 JSP로 보내는 전송 객체 (request, response X)
	{					//  ============ String => 처음 null값 => int로 받을 수 없음
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowsize=12;
		int start=(curpage*rowsize)-(rowsize-1);
		int end=(curpage*rowsize);
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=dao.foodListData(map);
		int totalpage=dao.foodTotalPage();
		final int BLOCK=10;
		int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endpage>totalpage)
			endpage=totalpage;
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "food/list";
	}
	@RequestMapping("food/detail.do")
	public String food_detail(int fno,Model model)
	{
		
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo",vo); // => request.setAttribute(key,obj) ==> request : 보안 취약
		/*
		 *  class Model
		 *  {
		 *  	private HttpServelRequest request
		 *  	public Model(HttpServletRequest request)
		 *  	{
		 *  		this.request=request;
		 *  	}
		 *  	public void addAttribute(String key,Object obj)
		 *  	{
		 *  		request.setAttribute(key,obj)
		 *   	}
		 *  }
		 */
		return "food/detail";
		
	}
	// 화면을 이동할 때 사용
	@RequestMapping("food/find.do")
	public String food_find()
	{
		return "food/find";
	}
	
}
	
	
