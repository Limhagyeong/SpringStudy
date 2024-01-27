package com.sist.inter;

import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//<bean이용> = > 로그인 자동처리 , 아이디 저장 
/*          FrontController: 요청받기=>응답    
 * main.do ======DispatcherServlet ===== HandlerMapping (모델찾기)
 *                                    |
 *                                  @getMapping/@postMapping = > 기능수행 (BACK-END)
 *                                   ======================
 *                                   프로그래머 (MODEL) 찾기 
 *                                   MODEL(Controller,Action)
 *                                        1)VO
 *                                        2)DAO
 *                                        3)Manager
 *                                         4)Service
 *                                         =>유지보수(역할분담)
 *             DispatchareServlet            
 * 
 *                   |
 *                preHandle ( handlerMapping 전에 실행)  = > main.do(getmapping/postmapping) 가 실행되기전에 처리되서 자동로그인이 되게  
 *                                     preHandle = > @GetMapping("main.do")
 *                                                  | 
 *                                                 return "main/main"
 *                                                    |  ---> postHandle
 *                                                 ViewResolver 
 * 
 *                                                    |request
 *                                                   | -----> afterCompletion 
 *                                                   JSP = > FRONTEND
 */                                                 
public class FoodInterceptor extends HandlerInterceptorAdapter {

   @Override
   //main.do 찾기전(모델 수행전:자동 로그인 ,id 저장 )
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      // TODO Auto-generated method stub
      System.out.println("===========preHandle Call....========");
      return super.preHandle(request, response, handler);
   }

   @Override
   //viewResolver로 넘어가기전 
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      System.out.println("=======postHandel Call...==========");
      // TODO Auto-generated method stub
      super.postHandle(request, response, handler, modelAndView);
   }

   @Override
   //JSP로넘어가기전
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      System.out.println("===========afterCompletion========");
      // TODO Auto-generated method stub
      super.afterCompletion(request, response, handler, ex);
   }
   
   
}