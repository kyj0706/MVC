<%@page import="com.site.ex0720.BoardDao"%>
<%@page import="com.site.ex0720.BoardVo"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글저장</title>
	</head>
	<body>
	<%	
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo =null;
	
	   String path = request.getRealPath("upload");
	   int size = 10*1024*1024;
	   	int result=0;
	      try{
	         MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
	         String bname = multi.getParameter("bname");
	         String btitle = multi.getParameter("btitle");
	         String bcontent = multi.getParameter("bcontent");
	         String fileName = multi.getFilesystemName("fileName");
	         boardVo = new BoardVo(btitle,bcontent,bname,fileName);
	         result = boardDao.boardInsert(boardVo);      
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      %>
	      <c:set var="result" value="<%=result %>" />
	     <script type="text/javascript">
	     
	     
	     
	     
	     </script>
	      
	      
	      
	      
	      
	      
	      
	   <!--    finally{
	         try{
	            
	         }catch(Exception e2){
	            e2.printStackTrace();
	         }
	      } -->
	
	
	
	
	</body>
</html>