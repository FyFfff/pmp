<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>home</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="pub/head.jsp" %>
  </head>
  
  <body>
   <div id="wrap">
    	<%@include file="pub/top.jsp" %>
	    <div class="container-fluid">
		      <%@include file="pub/menu.jsp" %>
		      <div class="main_container" id="page">
		     		<a onclick="EditPost();">kkkkkkkkkkk</a>
		      </div>
	    </div>
    </div>
    <script type="text/javascript">
    	function EditPost(){
    	   alert("###");
			$.ajax({
	             url:"http://10.4.74.16:7001/baiduWapPayAction.do",
	             type:"GET",
	             data:{"nextMethod":"pageInit","u":"rESkB%2BIUy724J28%2ByuIqcrTG2tZPuaXIQof2qIGHo%2Fo%3D"},
	             dataType:"json",
	             success:function(data){
					alert(data);
	             }
			});
		}
    </script>
  </body>
</html>
