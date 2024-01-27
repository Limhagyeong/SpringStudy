package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.*;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("main/goodsmain.do")
	public String goods_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowsize=12;
		  int start=(rowsize*curpage)-(rowsize-1);
		  int end=rowsize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<GoodsVO> gList=dao.goodsListData(map);
		System.out.println(gList.size());
		final int BLOCK=10;
		  int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  
		  int totalpage=dao.totalPage();
		  if(endpage>totalpage)
			  endpage=totalpage;

		model.addAttribute("curpage",curpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		model.addAttribute("gList",gList);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("goodsmain_jsp","list.jsp");
		return "main/goodsmain";
	}
	@GetMapping("main/goodsdetail_before.do")
	   public String goods_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	   {
		   // 쿠키는 일반 객체 => 매개변수로 받을 수 없다
		   Cookie cookie=new Cookie("goods_"+no, String.valueOf(no));
		   cookie.setPath("/");
		   cookie.setMaxAge(60*60*24);
		   response.addCookie(cookie);
		   // sendredirect => 값 전송 시 사용 ==> get방식
		   ra.addAttribute("no", no);
		   return "redirect:../main/goodsdetail.do";
	   }
	@GetMapping("main/goodsdetail.do")
	public String goods_datail(int no,Model model)
	{
		
		GoodsVO gvo=dao.goodsDetailData(no);
		
		model.addAttribute("gvo",gvo);
		model.addAttribute("no",no);
		model.addAttribute("goodsmain_jsp","goodsdetail.jsp");
		return "main/goodsmain";
	}
	@RequestMapping("main/goodsfind.do")
	public String goods_find(String page,String tname,String ss,Model model)
	{
		if(tname==null)
			tname="goods_all";
		if(ss==null)
			ss="세트";
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowsize=12;
		  int start=(rowsize*curpage)-(rowsize-1);
		  int end=rowsize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("tname", tname);
		map.put("ss", ss);
		
		List<GoodsVO> gList=dao.goodsFindListData(map);
		System.out.println(gList.size());
		final int BLOCK=10;
		  int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  
		  int totalpage=dao.findTotalPage(map);
		  if(endpage>totalpage)
			  endpage=totalpage;

		model.addAttribute("curpage",curpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		model.addAttribute("gList",gList);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("tname",tname);
		model.addAttribute("ss",ss);
		model.addAttribute("goodsmain_jsp","goodsfind.jsp");
		return "main/goodsmain";
	}

	
}
