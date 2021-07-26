<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
			<style type="text/css">
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		</style>
	</head>
	<body>
	<%
	  String savePath = "c:/upload";
	  int size = 10*1024*1024;
	  String name="";
	  String title="";
	  int fileCount=0;
	
	  MultipartRequest multi = new MultipartRequest(request,savePath,size,"utf-8",new DefaultFileRenamePolicy());
	  name = multi.getParameter("name");
	  title =multi.getParameter("title");
	  fileCount = Integer.parseInt(multi.getParameter("fileCount")); 
	  
	  String[] uploads =new String[fileCount];
	  
	  
	  Enumeration e= multi.getFileNames();
	  int i=0;
	  while(e.hasMoreElements()){
		  String fname = (String)e.nextElement();
		  uploads[i]=multi.getFilesystemName(fname);
		  i++;
	  }

		  %>
	<h2>파일정보</h2>
	<table>
		<tr>
			<td align="center">작성자</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td align="center">제 목</td>
			<td><%=title %></td>
		</tr>
	<!-- 파일펌부 정보 -->
		<%for(int j=0;j<fileCount;j++){ %>
		<tr>
			<td>업로드된 파일정보</td>
			<td><%=uploads[j] %></td>
		</tr>
	<%} %>
	
	
	</table>
	

	</body>
</html>