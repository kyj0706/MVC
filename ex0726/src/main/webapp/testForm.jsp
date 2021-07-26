<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>testForm</title>
		<style type="text/css">
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		</style>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		var count=1;
		
		//삭제
		function subInput() {
			
			if($("input:checkbox[name=filecheck]:checked").length<=0){
        		alert("체크가 1개 이상 되어야 삭제가 가능합니다.");
        		return false;
        	}
			 $("input:checkbox[name=filecheck]").each(function(){
	               if(this.checked){
	                  $("#"+this.value).remove();
	                  alert("행삭제 합니다.")
	               }
	            });
	         }
		//추가
		function addInput() {
			alert("행추가 합니다.");
			var addTable="";
			addTable = addTable +'<tr id="'+count+'">';
			addTable = addTable +'<td><input type="checkbox" id="filecheck" name="filecheck" value="'+count+'"></td>';
			addTable = addTable +'<td><input type="file" id="file'+count+'" name="file'+count+'"></td>';
			addTable = addTable +'</tr>';
			count++;
			$("#tbodyTr").append(addTable);
		}
		
		//파일업로드
		function submitForm() {
			$("#fileCount").val($("input:checkbox[name=filecheck]").length);
			$("#testForm").submit();
		
			
			
		}
		
		
		</script>
	</head>
	<body>
		<h3>다중파일업로드</h3>
		<form action="testFormOk.jsp" method="post" id="testForm" name="testForm" enctype="multipart/form-data">
		
		<input type="hidden" id="fileCount" name="fileCount">
		
		<label>작성자</label>
		<input type="text" id="name" name="name"><br>
		<label>제&nbsp;&nbsp;목</label>
		<input type="text" id="title" name="title"><br>
		
		<br><br>
		
		<input type="button" onclick="addInput()" value="행추가">
		<input type="button" onclick="subInput()" value="행삭제"><br>
		<br>
		<font>check 업로드할 파일이름</font><br>
		<table>
			<tbody id="tbodyTr">
				<!-- thml 소스 들어갈곳 -->
			</tbody>
		</table>
		
		<br><br><br>
		<font color="red">업로드할 파일은 최대 10M까지 가능함</font><Br>
		<input type="button" onclick="submitForm()" value="파일올리기">
		
		
		
		
		</form>
	
	</body>
</html>