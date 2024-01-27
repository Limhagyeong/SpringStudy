package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ReplyMapper;
import com.sist.vo.ReplyVO;
/*
 *  *.do ======= DispathcerServlet
 *  					| => preHandle(intercepter) => 자동 로그인 / ID 저장
 *     				    |	HandlerMapping
 *     				@Controller / @RestController
 *     				    | => postHandle()
 *     				    |  Model=request => ViewResolver
 *     					| => afterCompletion() => 권한 정보
 *     				   JSP
 *   => AOP 
 *      void aaa(); => Before
 *      void bbb(); => AfterThrowing
 *      void ccc(); => After
 *      void ddd(); => AfterReturning
 *      
 *   
 */

@Repository
public class ReplyDAO {
@Autowired
private ReplyMapper mapper;

public void replyInsert(ReplyVO vo) {
	mapper.replyInsert(vo);
}

public List<ReplyVO> replyListData(int fno){
	return mapper.replyListData(fno);
}

public void replyUpdate(ReplyVO vo) {
	mapper.replyUpdate(vo);
}

public void replyDelete(int no) {
	mapper.replyDelete(no);
}
}
