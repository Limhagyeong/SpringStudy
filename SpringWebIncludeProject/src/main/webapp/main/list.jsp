<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
   <div class="row">
    <c:forEach var="gvo" items="${gList }">
      <div class="col-md-3">
       <a href="../main/goodsdetail_before.do?no=${gvo.no }">
        <div class="panel panel-primary">
          <div class="panel-heading">${gvo.goods_name }</div>
          <div class="panel-body">
          <a href="../main/goodsdetail.do?no=${gvo.no }">
          <img src="${gvo.goods_poster }" style="width:180px;height:200px">
          </a>
          </div>
         </div>
        </a>
      </div>
    </c:forEach>
   </div>
   <div style="height: 20px"></div>
   <div class="row">
     <div class="text-center">
       <ul class="pagination">
         <c:if test="${startpage>1 }">
		  <li><a href="../main/goodsmain.do?page=${startpage-1 }">&lt;</a></li>
		 </c:if>
		 <c:forEach var="i" begin="${startpage }" end="${endpage }">
		   <li ${curpage==i?"class=active":"" }><a href="../main/goodsmain.do?page=${i }">${i }</a></li>
		 </c:forEach>
		 <c:if test="${endpage<totalpage }">
		  <li><a href="../main/goodsmain.do?page=${endpage+1 }">&gt;</a></li>
		 </c:if>
	  </ul>
     </div>
   </div>
   <div style="height: 20px"></div>
   <div class="row">
    <h3>최근 방문 맛집</h3>
    <hr>
    <c:if test="${count!=0 }">
    <c:forEach var="gvo" items="${gList }" varStatus="s">
    <c:if test="${s.index<9 }">
    <img src="${gvo.goods_poster }" style="width: 100px;height: 100px"/>
    </c:if>
    </c:forEach>
    
    </c:if>
   </div>
  </div>
</body>
</html>