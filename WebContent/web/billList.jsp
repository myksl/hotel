<%@page import="factory.BillFactory"%>
<%@page import="vo.Bill"%>
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
<form action="billList.jsp">
	<font color="gray" size="4" face="幼圆">请输入查询入住单号 <input type= "text" name = "what">
	<input type= "submit" value  = "查询"></font>
</form>
<table width="80%">
	<tr>
		<td>预订单号</td>
		<td>入住单号</td>
		<td>价格</td>
		<td>客人姓名</td>
		<td>备注</td>
	</tr>
	<%
		String what =request.getParameter("what");
		List<Bill> list = null;
		if(what==null){
			list = BillFactory.get().findAll();
			for(Bill bill:list){
	%>
	<tr>
		<td><%=bill.getOrderId()%></td>
		<td><%=bill.getLiveId()%></td>
		<td><%=bill.getPrice()%></td>
		<td><%=bill.getName()%></td>
		<td><%=bill.getPs()%></td>
	</tr>
	
<%
		}
		}else{
			Bill bill = BillFactory.get().findById(what);
			if(bill!=null){
	%>
		<tr>
		<td><%=bill.getOrderId() %></td>
		<td><%=bill.getLiveId() %></td>
		<td><%=bill.getPrice() %></td>
		<td><%=bill.getName() %></td>
		<td><%=bill.getPs() %></td>
	</tr>
<%
		}
	}
%>



</table>
</center>
</body>
</html>