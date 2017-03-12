<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="all2.html"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
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
<form action="login" method="get">
	<table>
		<tr>
			<td>账号</td>
			<td><input type="text" name = "username"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name = "password"></td>
		</tr>
		
		<tr>
			<td></td>
			<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type= "submit" value = "登录" ><td>
		</tr>
	
	</table>
</form>
</center>
</body>
</html>