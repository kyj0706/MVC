<%@page import="java.util.ArrayList"%>
<%@page import="com.site.ex0720.BoardVo"%>
<%@page import="com.site.ex0720.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%
 BoardDao boardDao =new BoardDao();
 BoardVo boardVo = new BoardVo(); 
       
 ArrayList<BoardVo> list = new ArrayList<BoardVo>();
 list = boardDao.boardAllSelect();

 //pageContext.setAttribute("boardVo", boardVo);
%>


   <style type="text/css">
         tale,th,td{
         border: 1px solid black;
         border-collapse: collapse;
         }
         
      
      </style>
<meta charset="UTF-8">
<title>홍길동 게시판 정보</title>
</head>
   <body>
   <h3>arraylist출력</h3>
   <table>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
         </tr>
         <!-- 반복 시작 -->
         
         <c:set var="list" value="<%=list %>" />
         <c:forEach var="boardVo" items="${list}" ><!-- 객체를 받아올때는 item 변수를 받아올때는 var -->
         <tr>
            <td>${boardVo.bid }</td>
            <td>${boardVo.btitle }</td>
            <td>${boardVo.bname }</td>
            <td>${boardVo.bDate }</td>
            <td>${boardVo.bhit }</td>
         </tr>
         </c:forEach>
      </table>
      