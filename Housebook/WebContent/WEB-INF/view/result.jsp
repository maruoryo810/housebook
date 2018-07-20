<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Kakeibo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	Kakeibo result = (Kakeibo)request.getAttribute("kakei");
	%>
	<p>以下の項目が登録されました</p>
	<p>ID：<%= result.getId() %></p>
	<p>月：<%= result.getMonth() %></p>
	<p>日：<%= result.getDay() %></p>
	<p>お金：<%= result.getMoney() %></p>
	<p>収入:<%= result.getIncome() %></p>
	<p>支出:<%= result.getSpeding() %></p>
</body>
</html>