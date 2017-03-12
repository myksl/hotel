<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="all.html"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%
	Map<String,String> map =(Map) request.getAttribute("error");
	if(map!=null){
		
%>
	<%=map.get("user") %>
<%
	}
%>
<form action="userAdd" method="get">
	<table>
		<tr>
			<td>客人姓名</td>
			<td><input type="text" name = "name"></td>
		</tr>
		<tr>
			<td>身份证</td>
			<td><input type="text" name = "id"></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name = "phone"></td>
		</tr>
		<tr>
			<td>会员卡号</td>
			<td><input type="text" name = "cardId"></td>
		</tr>
		<tr>
			<td></td>
			<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type= "submit" value = "添加" ><td>
		</tr>
	
	
	</table>

</form>
</center>
</body>
</html>

