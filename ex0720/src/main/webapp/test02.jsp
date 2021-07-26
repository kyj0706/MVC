<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<style type="text/css">
		table,th,td{border:1px solid black; border-collapse: collapse;  }
		
		</style>
	<head>
		<meta charset="UTF-8">
		<title>jstl</title>
	</head>
	<body>
	<!-- 이거랑 같다 -->
	<%
	  for(int i=0; i<10; i++){
		  
	  }
	%>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		<c:forEach var="i" begin="0" end="10" step="1">
			<tr>
				<th><c:out value="${i+1}"></c:out></th>
				<th>게시판제목</th>
				<th>홍길동</th>
				<th>2021-07-20</th>
				<th>1</th>
			</tr>
		
		</c:forEach>
		</table>
	</body>
</html>