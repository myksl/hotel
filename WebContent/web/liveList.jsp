<%@page import="vo.Live"%>
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
<form action="liveList.jsp">
	<font color="gray" size="4" face="幼圆">请输入查询入住单号 <input type= "text" name = "what">
	<input type= "submit" value  = "查询"></font>
</form>
<table width="80%">
	<tr>
		<td>入住单号</td>
		<td>预订单号</td>
		<td>身份证号</td>
		<td>人数</td>
		<td>房间编号</td>
		<td>房间价格</td>
		<td>房间类型</td>
		<td>单据状态</td>
		
	</tr>
	<%
		String what =request.getParameter("what");
			List<Live> list = null;
			if(what==null){
		list = SpecialtyFactory.get().findAll();
		for(Live live:list){
	%>
	<tr>
		<td><%=live.getId()%></td>
		<td><%=live.getOrderId()%></td>
		<td><%=live.getUserId()%></td>
		<td><%=live.getPeople()%></td>
		<td><%=live.getRoom().getNumber()%></td>
		<td><%=live.getRoom().getPrice()%></td>
		<td><%=live.getRoom().getType()%></td>
		<td><%=live.getBillState()%></td>
	</tr>
	
<%
		}
			}else{
		Live live = SpecialtyFactory.get().findById(what);
		if(live!=null){
	%>
		<tr>
		<td><%=live.getId() %></td>
		<td><%=live.getOrderId() %></td>
		<td><%=live.getUserId() %></td>
		<td><%=live.getPeople() %></td>
		<td><%=live.getRoom().getNumber() %></td>
		<td><%=live.getRoom().getPrice() %></td>
		<td><%=live.getRoom().getType() %></td>
		<td><%=live.getBillState() %></td>
		</tr>
<%
	}
	}
%>



</table>
</center>
</body>
</html>