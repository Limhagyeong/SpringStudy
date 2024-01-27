package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
// 리턴값이 자바스크립트 or 일반 문자열을 보낼 때 사용 
// ex)alert
// @ResponseBody
@RestController
public class BoardRestController {
@Autowired
private BoardDAO dao;

@RequestMapping(value="board/update_ok.do", produces="text/html;charset=UTF-8")
public String board_update_ok(BoardVO vo)
{
	String result="";
	boolean bCheck=dao.boardUpdate(vo);
	if(bCheck==true)
	{
		result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
	}
	else
	{
		result="<script>"
				+"alert(\"비밀번호가 일치하지 않습니다\");"
				+"history.back();"
				+"</script>";
	}
	return result;
}
@RequestMapping("board/delete_ok.do")
public String board_delete(int no,String pwd)
{
	String result="";
	boolean bCheck=dao.boardReplyDelete(no, pwd);
	if(bCheck==true)
	{
		result="yes";
	}
	else
	{
		result="no";
	}
	return result;
}
}
