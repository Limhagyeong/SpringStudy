package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
// DispacherServlet을 통해서 데이터를 매개변수로 받을 수 있는 클래스
// @Controller / @RestController => Model에서만 가능
@Aspect
@Component
public class GoodsAspect {
	@Autowired
	private GoodsDAO dao;
	// finally => 무조건 전송
	@After("execution(* com.sist.web.GoodsController.goods_list(..))")
	public void cookieSend()
	{
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
									//============================================PageContext
		Cookie[] cookies=request.getCookies();
		List<GoodsVO> gList=new ArrayList<GoodsVO>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("goods_"))
				{
					   String no=cookies[i].getValue();
					   GoodsVO vo=dao.cookieData(Integer.parseInt(no));
					   gList.add(vo);
				}
			}
		}
		request.setAttribute("count", gList.size());
		request.setAttribute("gList", gList);
	}
}
