<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
		<title>operInfo</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<%@include file="pub/head.jsp"%>
</head>

<body>

	<div id="wrap">
		<%@include file="pub/top.jsp"%>
		<div class="container-fluid">
			<%@include file="pub/menu.jsp"%>

			<div class="main_container" id="page">
				<div class="row-fluid"></div>
				<div class="row-fluid">
					<div class="widget-padding">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>用户列表</h5>
							<div class="widget-buttons">
				                <a href="#" data-title="Add User" data-toggle="modal" data-target="#add_example_modal"><i class="icon-plus"> 添加</i></a>			                
				            </div>
						</div>
						<div class="widget-body">
							<table class="table table-striped table-bordered dataTable" style="font-size:14px">
								<thead>
									<tr>
										<th>操作员工号</th>
										<th>操作员名称</th>
										<th>手机号码</th>
										<th>归属编码1</th>
										<th>归属编码2</th>
										<th>隶属等级</th>
										<th>创建时间</th>
										<th>修改时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${operList}" var="oper">					
										<tr>
											<td>${oper.wk_no}</td>
											<td>${oper.oname}</td>
											<td>${oper.msisdn}</td>
											<td>${oper.org_id}</td>
											<td>${oper.site_id}</td>
											<td>${oper.wk_level}</td>
											<td>${oper.insert_time}</td>
											<td>${oper.modify_time}</td>
											<td>
												 <div class="btn-group">
							                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#"> Action<span class="caret"></span></a>
							                        <ul class="dropdown-menu pull-right">
							                        	<li><a href="#" data-title="Edit User" data-toggle="modal" data-target="#modify_example_modal" onclick="EditPost(${oper.wk_no});" ><i class="icon-edit" ></i> 修改</a></li>
							                        	<li><a href="#" data-title="Shouquan User" data-toggle="modal" data-target="#Shouquan_example_modal" onclick="ShouquanPost(${oper.wk_no});"><i class="icon-sitemap" ></i> 授权</a></li>
							                        	<li><a href="#" data-title="Delete User" data-toggle="modal" data-target="#delete_example_modal" onclick="DeletePost(${oper.wk_no});"><i class="icon-trash" ></i> 删除</a></li>						                        
							                        </ul>
							                      </div>
											</td>									
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div><!-- main_container 结束 -->
		</div><!-- container-fluid 结束 -->
	</div><!-- wrap 结束 -->
	
	
	<script type="text/javascript">
	
	//修改
		function EditPost(wkno){
			$.ajax({
	             url:"${pageContext.request.contextPath}/oper/editOper.do",
	             type:"POST",
	             data:{"wkno":wkno},
	             dataType:"json",        
	             success:function(data){
	             	var oper=data[0];
	             	$("#editform .wk_no_id").val(oper.wk_no);
	             	$("#editform .wk_no").val(oper.wk_no);
	             	$("#editform .password").val(oper.password);
	             	$("#editform .oname").val(oper.oname);
	             	$("#editform .msisdn").val(oper.msisdn);
	             	$("#editform .org_id").val(oper.org_id);
	             	$("#editform .site_id").val(oper.site_id);
	             	$("#editform .wk_level").val(oper.wk_level);
	             }
			});
		}
	
			 
	 //删除
		 function DeletePost(wkno){
			$("#del_wk_no").html(wkno);
		 }
		 
	 //授权
		 function ShouquanPost(wkno){
		 	$("#shouquanform .wk_no").val(wkno);
			$.ajax({
	             url:"${pageContext.request.contextPath}/sq/shouquanOper.do",
	             type:"POST",
	             data:{"wkno":wkno},
	             dataType:"json",
	             cache:false,
	             success:function(data){            
		             if(data==0){
		             	$("#xzjs input:checked").attr("checked",false);
		             }else{
		             	var l=$("#xzjs input");        	
		             	for(var i=0; i<l.length; i++){
		             		if(l[i].value==data){
		             		    $("#xzjs .roleid"+l[i].value).attr("checked",true);
		             		}
		             	}
		             }
				 }
			});
		 }
	 
	</script>
	
<!-- 添加用户 -->
	<div id="add_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">添加用户</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
			      <form class="form-horizontal" name="addform" id="addform">
	                  <div class="control-group">
	                    <label class="control-label">操作员工号</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="操作员工号" name="wk_no" id="wk_no" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">密码</label>
	                    <div class="controls">
	                      <input class="span" type="password" placeholder="密码" name="password" id="password" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">操作员名称</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="操作员名称" name="oname" id="oname" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">手机号</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="手机号" name="msisdn" id="msisdn" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">归属编码1</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="归属编码1" name="org_id" id="org_id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">归属编码2</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="归属编码2" name="site_id" id="site_id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">隶属等级</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="隶属等级" name="wk_level" id="wk_level" />
	                    </div>
	                  </div>
	              </form>
              </div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-primary" onclick="sendAddOper();">保存</button>
		  </div>
	</div>
	
	<script type="text/javascript">
		//添加用户保存请求
			function sendAddOper(){
				$.ajax({
		             url:"${pageContext.request.contextPath}/oper/addOper.do",
		             type:"POST",
		             data:$("#addform").serialize(),
		             dataType:"json",
		             cache:false,
		             success:function(data){
		                  if(data.message=="ok"){
		                  	  alert("添加成功");
		                      window.location="${pageContext.request.contextPath}/oper/operInfo.do";
		                  }else{
		              		  alert(data.message);
		                  }
		             }
				 });
			 }
	</script>
	
	
	
<!-- 修改用户 -->
	<div id="modify_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">修改用户</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
			      <form class="form-horizontal" name="editform" id="editform">
	                  <div class="control-group">
	                    <label class="control-label">操作员工号</label>
	                    <div class="controls">
	                      <input class="span wk_no_id" type="text" name="wk_no_id" disabled="disabled"/>
	                      <input class="span wk_no" type="hidden" name="wk_no" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">密码</label>
	                    <div class="controls">
	                      <input class="span password" type="password" name="password" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">操作员名称</label>
	                    <div class="controls">
	                      <input class="span oname" type="text" name="oname" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">手机号</label>
	                    <div class="controls">
	                      <input class="span msisdn" type="text" name="msisdn" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">归属编码1</label>
	                    <div class="controls">
	                      <input class="span org_id" type="text" name="org_id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">归属编码2</label>
	                    <div class="controls">
	                      <input class="span site_id" type="text" name="site_id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">隶属等级</label>
	                    <div class="controls">
	                      <input class="span wk_level" type="text" name="wk_level" />
	                    </div>
	                  </div>
	              </form>
              </div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-primary" onclick="sendEditOper();">保存</button>
		  </div>
	</div>
	
	<script type="text/javascript">
	
	 //修改用户保存请求
	 function sendEditOper(){
			$.ajax({
	             url:"${pageContext.request.contextPath}/oper/updateOper.do",
	             type:"POST",
	             data:$("#editform").serialize(),
	             dataType:"json",
	             cache:false,
	             success:function(data){
	                  if(data.message=="ok"){
	                  	  alert("修改成功");
	                      window.location="${pageContext.request.contextPath}/oper/operInfo.do";
	                  }else{
               			  alert(data.message);
	                  }
	             }
			 });
	 }
	</script>


	
<!-- 删除用户 -->
	<div id="delete_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">删除用户</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
		      	   <p>确定删除该用户吗？<span id="del_wk_no" /></span></p>
              </div>
		  </div>
		  <div class="modal-footer">
		  		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	   			<button class="btn btn-primary" onclick="sendDelOper();">确定</button>
		  </div>
	</div>
	<script type="text/javascript">

	 //发送删除请求
		 function sendDelOper(){
			var del=$("#del_wk_no").html();
			$.ajax({
	             url:"${pageContext.request.contextPath}/oper/delOper.do",
	             type:"POST",
	             data:{"wkno":del},
	             dataType:"json",        
	             success:function(data){
					if(data.message=="ok"){
				     	alert("删除成功");
				        window.location="${pageContext.request.contextPath}/oper/operInfo.do";
					}else{
					 	alert(data.message);
					}
	             }
			});
		 } 
		 
	</script>
	
	

<!-- 用户授权 -->
	<div id="Shouquan_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">用户授权</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
	
                <form class="form-horizontal" id="shouquanform">              
                  <div class="control-group">
                    <label class="control-label">请选择角色</label>
                    <div class="controls" id="xzjs">
                    	<input class="span wk_no" type="hidden" name="wk_no" />
                    	<c:forEach items="${roleList}" var="rol">
                    		<label class="radio">
	                    	<input type="radio" name="role_id" class="roleid${rol.role_id }" value="${rol.role_id }"/> ${rol.role_name }
	                    	</label>
                    	</c:forEach>
					</div>
                  </div>
                </form>
 
              </div>
		  </div>
		  <div class="modal-footer">
		  		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	   			<button class="btn btn-primary" onclick="sendAddOperRole();">确定</button>
		  </div>
	</div>

<script type="text/javascript">
	 //发送用户授权角色请求
	 function sendAddOperRole(){
			$.ajax({
	             url:"${pageContext.request.contextPath}/sq/addOperRole.do",
	             type:"POST",
	             data:$("#shouquanform").serialize(),
	             dataType:"json",
	             success:function(data){
					if(data.message=="ok"){
				     	alert("成功");
				        window.location="${pageContext.request.contextPath}/oper/operInfo.do";
					}else{
					 	alert(data.message);
					}
	             }
			});
		 }
</script>
	
</body>
</html>
