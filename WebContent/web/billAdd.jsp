<%@page import="factory.RoomFactory"%>
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
	String number = request.getParameter("number");
	String order = RoomFactory.get().getorder(number);
	String live = RoomFactory.get().getlive(number);
	Map<String,String> map =(Map) request.getAttribute("error");
	if(map!=null){
		
%>
	<%=map.get("bill") %>
<%
	}
%>
<form action="billAdd">
	<table>
		<tr>
			<td>预定单号</td>
			<td><input type="text" name = "orderId" value =<%=order %>></td>
		</tr>
		<tr>
			<td>入住单号</td>
			<td><input type="text" name = "liveId" value =<%=live %>></td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input type="text" name = "price"></td>
		</tr>
		<tr>
			<td>客人姓名</td>
			<td><input type="text" name = "name"></td>
		</tr>
		<tr>
			<td>备注</td>
			<td><input type="text" name = "ps"></td>
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