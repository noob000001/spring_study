<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
<h1>마이페이지</h1>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>${authentication.userId}</th>
	</tr>
	<tr>
		<th>비밀번호</th>
		<th>${authentication.password}</th>
	</tr>
	<tr>
		<th>전화번호</th>
		<th>${authentication.tell}</th>
	</tr>
	<tr>
		<th>이메일</th>
		<th>${authentication.email}</th>
	</tr>

</table>
</body>
</html>