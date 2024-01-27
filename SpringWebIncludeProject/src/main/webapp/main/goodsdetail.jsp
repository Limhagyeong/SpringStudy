<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row">
<table class="table">
<tr>
<td width="30%" class="text-center" rowspan="8">
<img src="${gvo.goods_poster }" style="width: 290px; height: 400px">
</td>
<td colspan="2">
<h3>${gvo.goods_name }&nbsp;<span style="color: orange">${gvo.goods_price }</span></h3>
</td>
</tr>
<tr>
<td colspan="3" class="text-right">
<a href="../main/goodsmain.do" class="btn btn-sm btn-danger">목록</a>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>