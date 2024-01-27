package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("member/login.do")
	public String member_login()
	{
		return "member/login";
	}
	@PostMapping("member/login_ok.do")
	public String login_ok(String id,String pwd,Model model,HttpSession session)
	{
		MemberVO svo=new MemberVO();
		svo.setId(id);
		svo.setPwd(pwd);
		MemberVO vo=dao.memberLogin(svo);
		if(vo.getMsg().equals("OK"))
		{
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
		}
		model.addAttribute("msg",vo.getMsg());
		return "member/login_ok";
	}
	// => GetMapping / PostMapping 오류 났을 경우 => 405 오류남
	/*
	 * 	1. 500 => 자바 에러 (코드 에러)
	 *  2. 404 => 파일이 없음
	 *  3. 405 => GetMapping / PostMapping 오류 났을 경우
	 *  4. 400 => Bad request => 매개변수의 데이터형이 맞지 않을 경우
	 *  5. 412 => 한글 변환 코드가 틀린 경우
			=> UTF-8 오타 없는지 확인
	 */
	@PostMapping("member/logout.do")
	public String member_logout(HttpSession session)
	{
		session.invalidate();
		// session에 저장된 정보를 한번에 모두 날림
		// removeAttribute => 정보를 하나씩 지움
		
		return "redirect:../main/main.do";
	}
}
