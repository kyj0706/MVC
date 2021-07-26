<%@page import="com.site.ex0720.MemberVo"%>
<%@page import="com.site.ex0720.MemberDao"%>
<%@page import="com.site.ex0720.BoardVo"%>
<%@page import="com.site.ex0720.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<%
	MemberDao memberDao = new MemberDao();
	MemberVo memberVo = memberDao.memberOneSelect("aaa");

%>
<c:set var="memberVo" value="<%=memberVo %>"></c:set>
<html>
	<head>
		<meta charset="UTF-8">
		<title>fn</title>
	</head>
	<body>
	 <h3>회원정보수정</h3>
      <form action="./modifyOk.jsp" id="form" name="form">
         <label>아이디</label>
         <input type="text" id="id" name="id" value="${memberVo.id}" readonly><br>
         <label>패스워드</label>
         <input type="password" id="pw" name="pw" " ><br>
         <label>이름</label>
         <input type="text" id="name" name="name" value="${memberVo.name}"><br>
         <label>닉네임</label>
         <input type="text" id="nickName" name="nickName" value="${memberVo.nickName}" ><br>
         <label>성별</label><br>
         <input type="radio" id="male" name="gender" value="male"${ memberVo.getGender().equals("male")?"checked":"" } ><label for="male">남성</label>
         <input type="radio" id="female" name="gender" value="female" ${ memberVo.getGender().equals("female")?"checked":"" } ><label for="female">여성</label><br>
         <label>전화번호</label>
         <input type="text" id="tel" name="tel" value="${memberVo.tel}" ><br>
         <label>주소1</label>
         <input type="text" id="address1" name="address1" value="${memberVo.address1}"><br>
         <label>주소2</label>
         <input type="text" id="address2" name="address2" value="${memberVo.address2}"><br>
        <label>취미</label><br>
 		<input type="checkbox" id="swim" name="hobby" value="swim" ${fn:contains(memberVo.hobby,"swim")?"checked":"" } ><label for="swim">수영</label>
	    <input type="checkbox" id="golf" name="hobby" value="golf" ${fn:contains(memberVo.hobby,"golf")?"checked":"" }><label for="golf">골프</label>
	    <input type="checkbox" id="run" name="hobby" value="run" ${fn:contains(memberVo.hobby,"run")?"checked":"" }><label for="run">조깅</label>
	    <input type="checkbox" id="read" name="hobby" value="read" ${fn:contains(memberVo.hobby,"read")?"checked":"" }><label for="read">독서</label><br>
         <input type="button" onclick="formCheck()" value="수정완료">
         <a href="./index.jsp"><input type="button" value="취소"></a><br>
         </form>
         
	
	</body>
</html>