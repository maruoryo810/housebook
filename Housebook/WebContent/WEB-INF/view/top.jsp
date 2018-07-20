<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録、削除、検索</title>
</head>
<body>
	収入と支出の情報を入力してください<br>
	<form action="/Kakeibo/InsertServlet" method="get">
		ID:<input type="text" name="Bookid"><br>
		月:<input type="text" name="Bookmonth"><br>
		日:<input type="text" name="Bookday"><br>
		金額:<input type="text" name="Bookmoney"><br>
		内容：<input type="text" name="Bookcontent"><br>
		<input type="submit" value="収入"><br>
		<input type="submit" value="支出"><br>
		</form>
</body>
</html>