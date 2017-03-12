<%@page import="vo.Bill"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<table>
<%
	String type = request.getParameter("type");
	if(type.equals("bill")){
		Bill bill = (Bill)request.getAttribute("bill");
%>	
		<tr>
		<td>预订单号</td>
		<td>入住单号</td>
		<td>价格</td>
		<td>客人姓名</td>
		<td>备注</td>
		</tr>

		<tr>
		<td><%=bill.getOrderId() %></td>
		<td><%=bill.getLiveId() %></td>
		<td><%=bill.getPrice() %></td>
		<td><%=bill.getName() %></td>
		<td><%=bill.getPs() %></td>
	</tr>
<%
	}
	if(type.equals("user")){
		
	}
	if(type.equals("order")){
		
	}
	if(type.equals("live")){
		
	}
	if(type.equals("admin")){
		
	}
	if(type.equals("room")){
		
	}
%>
</table>
</body>
</html>