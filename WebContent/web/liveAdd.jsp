<%@page import="vo.Room"%>
<%@page import="factory.RoomFactory"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	SimpleDateFormat sdf =  new SimpleDateFormat( "yyyyMMdd" );
	String number = request.getParameter("number");
	String  date= sdf.format(new Date());
	String id =number+date;
	Room room = RoomFactory.get().findById(number);
	Map<String,String> map =(Map) request.getAttribute("error");
	if(map!=null){
		
%>
	<%=map.get("live") %>
<%
	}
%>
<form action="liveAdd">
	<table>
		<tr>
			<td>入住单号</td>
			<td><input type="text" name = "id" value=<%=id %>></td>
		</tr>
		<tr>
			<td>预定单号</td>
			<td><input type="text" name = "orderId" value=<%=room.getOrderId() %>></td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td><input type="text" name = "userId"></td>
		</tr>
		<tr>
			<td>客房编号</td>
			<td><input type="text" name = "number" value=<%=number %>></td>
		</tr>
		<tr>
			<td>客房类型</td>
			<td><input type="text" name = "type" value=<%=room.getType() %>></td>
		</tr>
		<tr>
			<td>客房价格</td>
			<td><input type="text" name = "price" value=<%=room.getPrice() %> ></td>
		</tr>
		<tr>
			<td>入住人数</td>
			<td><input type="text" name = "people"></td>
		</tr>
		<tr>
			<td>单据状态</td>
			<td><input type="text" name = "billState"></td>
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