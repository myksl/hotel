<%@page import="java.util.List"%>
<%@page import="factory.OrderFactory"%>
<%@page import="vo.Order"%>
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
<form action="orderList.jsp">
	<font color="gray" size="4" face="幼圆">请输入查询预订单号 <input type= "text" name = "what">
	<input type= "submit" value  = "查询"></font>
</form>
<table width="80%">
	<tr>
		<td>预订单号</td>
		<td>到店时间</td>
		<td>离店时间</td>
		<td>客房编号</td>
		<td>客户电话</td>
		<td>客户姓名</td>
		<td>客户身份证号</td>
		<td>入住人数</td>
	</tr>
	<%
	String what =request.getParameter("what");
	List<Order> list = null;
	if(what==null){
		list = OrderFactory.get().findAll();
		for(Order order:list){
%>
	<tr>
		<td><%=order.getId() %></td>
		<td><%=order.getLeftTime() %></td>
		<td><%=order.getLeftTime() %></td>
		<td><%=order.getRoomId() %></td>
		<td><%=order.getUser().getPhone() %></td>
		<td><%=order.getUser().getName() %></td>
		<td><%=order.getUser().getId() %></td>
		<td><%=order.getPeople() %></td>
	</tr>
	
<% 
		}
	}else{
		Order order = OrderFactory.get().findById(what);
		if(order!=null){
%>
	<tr>
		<td><%=order.getId() %></td>
		<td><%=order.getLeftTime() %></td>
		<td><%=order.getLeftTime() %></td>
		<td><%=order.getRoomId() %></td>
		<td><%=order.getUser().getPhone() %></td>
		<td><%=order.getUser().getName() %></td>
		<td><%=order.getUser().getId() %></td>
		<td><%=order.getPeople() %></td>
	</tr>
<%
		}
	}
%>



</table>
</center>
</body>
</html>