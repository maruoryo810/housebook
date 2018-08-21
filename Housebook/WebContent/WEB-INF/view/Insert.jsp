<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Kakeibo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支出の登録</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	Kakeibo result = (Kakeibo)request.getAttribute("kakei");
	%>
	<h1>収支の登録が完了しました。</h1>
</body>
</html>