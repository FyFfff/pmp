<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/Content/ico/favicon.html">
	<link href="${pageContext.request.contextPath}/Content/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/Content/css/theme.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/Content/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/Content/css/alertify.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/raphael-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/bootstrap.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath}/Content/js/sparkline.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath}/Content/js/morris.min.js'></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery.dataTables.min.js"></script>   
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery.masonry.min.js"></script>   
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery.imagesloaded.min.js"></script>   
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery.facybox.js"></script>   
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery.elfinder.min.html"></script> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/jquery.alertify.min.js"></script> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/realm.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function sendPost(){
			$.ajax({
	             url:"${pageContext.request.contextPath}/login/getuser.do",           
	             type:"POST",
	             data:$("#myform").serialize(),
	             dataType:"json",
	             cache:false,
	             success:function(data){
	                  if(data.message=="ok"){
	                      window.location="${pageContext.request.contextPath}/login/home.do";
	                  }else{
	                      $("#message").html(data.message);
	                      $("#message").attr("class","error");
	                  }
	             }
	          });
		}
	</script>
  </head>
  
  <body>
		
	<div id="wrap">
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
          	<div class="row-fluid">
				<div class="widget container-narrow">
					<div class="widget-header">
						<i class="icon-user"></i>
						<h5>用户登录</h5>
					</div>  
					<div class="widget-body clearfix" style="padding:25px;">
		      			<form action="" id="myform" name="myform">
							<div class="control-group">
								<div class="controls">
									<input id="wk_no" name="wk_no" class="btn-block" type="text" id="inputEmail" placeholder="账号" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input id="pwd" name="pwd" class="btn-block" type="password" id="inputPassword" placeholder="密码"  />
								</div>
							</div>		
							<button type="button" class="btn pull-right" onclick="sendPost()">登录</button>
		      			</form>
		      			<div style="text-align:left">
		      				<p id="message" style="color: #f00"></p>
		      			</div>
					</div>  
				</div>
        	</div><!--/row-fluid-->
        </div><!--/span10-->
      </div><!--/row-fluid-->
    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->
		
  </body>
</html>
