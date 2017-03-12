<%@page import="factory.AdminFactory"%>
<%@page import="vo.Admin"%>
<%@page import="java.util.List"%>
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
<table width="30%">
	<tr>
		<td>账号</td>
		<td>密码</td>
		<td>权限等级</td>
	</tr>
	<%
		List<Admin> list = null;
		list = AdminFactory.get().findAll();
		for(Admin admin:list){
%>
	<tr>
		<td><%=admin.getUsername() %></td>
		<td><%=admin.getPassword() %></td>
		<td><%=admin.getLevel() %></td>
	</tr>
	
<% 
		}
%>

</table>
</center>
</body>
</html>