<%@page import="factory.RoomFactory"%>
<%@page import="vo.Room"%>
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
<form action="roomList.jsp">
	<font color="gray" size="4" face="幼圆">请输入查询房间类型 <input type= "text" name = "what">
	<input type= "submit" value  = "查询"></font>
</form>
<table width="80%">
	<tr>
		<td>房间编号</td>
		<td>房间类型</td>
		<td>房间价格</td>
		<td>房间状态</td>
		<td>相关信息</td>
		<td>操作</td>
		
	</tr>
<%
	String what =request.getParameter("what");
	List<Room> list = null;
	if(what==null){
		list = RoomFactory.get().findAll();
	}else{
		list = RoomFactory.get().findByType(what);
	}
		for(Room room:list){
%>
	<tr>
		<td><%=room.getNumber() %></td>
		<td><%=room.getType() %></td>
		<td><%=room.getPrice() %></td>
		<td><%=room.getState() %></td>
	
<% 
		if(room.getState().equals("未住")){
%>	
		<td>暂无</td>
		<td><a href="orderAdd.jsp?number=<%=room.getNumber()%>">预订</a></td>
<% 		
		}
		if(room.getState().equals("预订")){
%>	
		<td><a href="orderList.jsp?what=<%=room.getOrderId()%>">预订单</a></td>	
		<td><a href="liveAdd.jsp?number=<%=room.getNumber()%>">入住</a></td>	
<% 			
		}
		if(room.getState().equals("入住")){
%>	
		<td><a href="liveList.jsp?what=<%=room.getLiveId()%>">入住单</a></td>	
		<td><a href="billAdd.jsp?number=<%=room.getNumber()%>">结账</a></td>	
<% 			
		}
		}
		
%>

	</tr>

</table>
</center>
</body>
</html>