package com.sist.web;
// Model 역할 => 브라우저로 값을 보냄
// return값이 무조건 파일명
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
@Controller 
@RequestMapping("board/") // => 중복된 경로를 빼준다
public class BoardController {
	@Autowired
	private BoardDAO dao;
	// list.do
	@RequestMapping("list.do")
	public String board_list(String page,Model model)
	{
		// 사용자가 전송한 모든 데이터는 매개변수로 받는다 
		// ModelClass => 전송 객체
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*10)-9);
		map.put("end", (curpage*10));
		List<BoardVO> list=dao.boardListData(map);
		
		int count=dao.boardTotalPage();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10); // => 게시글번호가 변하지 않도록 해줌
		
		model.addAttribute("count", count);
		model.addAttribute("curpage",curpage);
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		
		return "board/list"; // board/list.jsp
	}
	//insert.do
	@RequestMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	//insert_ok.do => command객체 => vo단위로 값을 받음
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	// detail.do?no=${vo.no} => public String board_detail(int no,Model model)
	// 			 ==========								   ======= 같아야햠
	@RequestMapping("detail.do")
	public String board_detail(int no,Model model)
	{
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	@RequestMapping("update.do")
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo",vo);
		return "board/update";
	}
	// 답변하기 
	@RequestMapping("reply.do")
	public String board_reply(int pno, Model model)
	{
		model.addAttribute("pno",pno);
		return "board/reply";
	}
	@RequestMapping("reply_ok.do")
	public String board_reply_ok(int pno, BoardVO vo)
	{
		dao.boardReplyInsert(pno, vo);
		return "redirect:list.do";
	}
	
}
