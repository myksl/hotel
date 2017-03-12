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
	<%=map.get("admin") %>
<%
	}
%>
<form action="adminAdd" method="post">
	<table>
		<tr>
			<td>用户名</td>
			<td><input type="text" name = "username"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name = "password"></td>
		</tr>
		<tr>
			<td>权限等级</td>
			<td><input type="text" name = "level"></td>
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