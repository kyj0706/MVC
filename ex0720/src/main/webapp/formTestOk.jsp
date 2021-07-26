<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%request.setCharacterEncoding("utf-8"); %>
	<head>
		<meta charset="UTF-8">
		<title>el태크</title>
		<style type="text/css">
		table,th,td{border:1px solid black; border-collapse: collapse;  }
		
		</style>
	</head>
	<body>
		<h3>el태크 방식</h3>
		<h4>${sessionScope.session_id }님 환영합니다.</h4>
		<h4>${sessionScope.session_flag }입니다.</h4>
		<hr>
		<h4>${session_id }님 sessionScope없이 사용</h4>
		<h4>${ session_flag }입니다.</h4>
		<hr>
		<h4><%=session.getAttribute("session_id") %>님: 스크립트릿으로 표시</h4>
		<table>
			<tr>
				<th>id</th>
				<td>${param.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${param.name}</td>
			</tr>
		</table>	
		<h3>스크립트릿, 표현식방식</h3>
		<table>
			<tr>
				<th>id</th>
				<td><%=request.getParameter("id") %></td>
			</tr>
			<tr>
				<th>이름</th>
				<td></td>
			</tr>
		
		</table>
		
	</body>
</html>