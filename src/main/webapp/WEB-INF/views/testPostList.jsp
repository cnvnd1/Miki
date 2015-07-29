<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#send").on("click",function(e){
		
		//ajax
		$.ajax({
			url : "postListSelect",
			method:"get",			
			dataType:"json",
			success:function(responseData,status,xhr){
				//원래는 status확인 하는게 좋음 성공 200인지 
				console.log(responseData);
			
				
			}
		});
		
	});
	
});
</script>
</head>
<body>
	<button id="send">계산</button>
	결과값:<div id="result"></div>
</body>
</html>