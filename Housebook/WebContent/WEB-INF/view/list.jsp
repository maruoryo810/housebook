<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Kakeibo" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支出の登録</title>
</head>
<body>

<table border="1">
	<tr>
		<th>ID</th>
		<th>月</th>
		<th>日</th>
		<th>金額</th>
		<th>内容</th>
	</tr>
		<%
		 @SuppressWarnings("unchecked")
		 ArrayList<Kakeibo> al = (ArrayList<Kakeibo>) request.getAttribute("al");
		for (Kakeibo si : al) {
		 %>
		 <tr>
		 	<td><%=si.getId()%></td>
		 	<td><%=si.getMonth() %></td>
		 	<td><%=si.getDay() %></td>
		 	<td><%=si.getMoney() %></td>
		 	<td><%=si.getContent() %></tr>
		 	<%
		 		}
		 	%>
		</table>
	<%
	request.setCharacterEncoding("UTF-8");

	Kakeibo result = (Kakeibo)request.getAttribute("kakei");
	%>
	<h1>登録画面</h1>
</body>
</html>