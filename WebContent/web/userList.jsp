<%@page import="factory.UserFactory"%>
<%@page import="vo.User"%>
<%@page import="java.util.List"%>
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
<form action="userList.jsp">
	<font color="gray" size="4" face="幼圆">请输入查询客户姓名 <input type= "text" name = "what">
	<input type= "submit" value  = "查询"></font>
</form>
<table width="80%">
	<tr>
		<td>客户姓名</td>
		<td>身份证号</td>
		<td>联系电话</td>
		<td>会员卡号</td>
	</tr>
	<%
	String what =request.getParameter("what");
	List<User> list = null;
	if(what==null){
		list = UserFactory.get().findAll();
	}else{
		list = UserFactory.get().findByName(what);
	}
		for(User user:list){
%>
	<tr>
		<td><%=user.getName() %></td>
		<td><%=user.getId() %></td>
		<td><%=user.getPhone() %></td>
		<td><%=user.getCardId() %></td>
	</tr>
<%
		}

%>	



</table>
</center>
</body>
</html>