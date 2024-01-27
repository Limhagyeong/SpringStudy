<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row">
<form method="post" action="../main/goodsfind.do">
<select name="tname" class="input-sm">
<option value="goods_all" ${tname=="goods_all"?"selected":"" }>전체상품</option>
<option value="goods_best" ${tname=="goods_best"?"selected":"" }>인기상품</option>
<option value="goods_new" ${tname=="goods_new"?"selected":"" }>신상품</option>
<option value="goods_special" ${tname=="goods_special"?"selected":"" }>특가상품</option>
</select>
<input type="text" name="ss" size="20" class="input-sm" value="${ss }">
<input type="submit" value="검색" class="btn btn-sm btn-danger">
</form>
</div>
<div style="height: 20px"></div>
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
<div class="row">

</div>
</div>
  <div style="height: 20px"></div>
   <div class="row">
     <div class="text-center">
       <ul class="pagination">
         <c:if test="${startPage>1 }">
		  <li><a href="../main/goodsfind.do?page=${startpage-1 }&tname=${tname}&ss=${ss}">&lt;</a></li>
		 </c:if>
		 <c:forEach var="i" begin="${startpage }" end="${endpage }">
		   <li ${curpage==i?"class=active":"" }><a href="../main/goodsfind.do?page=${i }&tname=${tname}&ss=${ss}">${i }</a></li>
		 </c:forEach>
		 <c:if test="${endpage<totalpage }">
		  <li><a href="../main/goodsfind.do?page=${endpage+1 } }&tname=${tname}&ss=${ss}">&gt;</a></li>
		 </c:if>
	  </ul>
     </div>
   </div>
</body>
</html>