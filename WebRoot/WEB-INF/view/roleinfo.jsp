<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>roleInfo</title>
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
							<h5>角色列表</h5>
							<div class="widget-buttons">
				                <a href="#" data-title="Add Role" data-toggle="modal" data-target="#add_example_modal"><i class="icon-plus"> 添加</i></a>			                
				            </div>
						</div>
						<div class="widget-body">
							<table class="table table-striped table-bordered dataTable" style="font-size:14px">
								<thead>
									<tr>
										<th>角色编码</th>
										<th>角色名称</th>
										<th>角色级别</th>
										<th>角色描述</th>
										<th>修改时间</th>
										<th>创建时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${roleList}" var="role" >		
										<tr>
											<td>${role.role_id}</td>
											<td>${role.role_name}</td>
											<td>${role.role_level}</td>
											<td>${role.role_desc}</td>
											<td>${role.modify_date}</td>
											<td>${role.create_date}</td>
											<td>
												 <div class="btn-group">
							                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#"> Action<span class="caret"></span></a>
							                        <ul class="dropdown-menu pull-right">
							                          <li><a href="#" data-title="Edit User" data-toggle="modal" data-target="#modify_example_modal" onclick="EditPost(${role.role_id});" ><i class="icon-edit" ></i> 修改</a></li>
							                          <li><a href="#" data-title="Shouquan User" data-toggle="modal" data-target="#Shouquan_example_modal" onclick="ShouquanPost(${role.role_id});"><i class="icon-sitemap" ></i> 授权</a></li>
							                          <li><a href="#" data-title="Delete User" data-toggle="modal" data-target="#delete_example_modal" onclick="DeletePost(${role.role_id});"><i class="icon-trash" ></i> 删除</a></li>
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
		//选择修改角色，添加修改页面内容
		function EditPost(roleid){
			$.ajax({
	             url:"${pageContext.request.contextPath}/role/editRole.do",
	             type:"POST",
	             data:{"roleid":roleid},
	             dataType:"json",
	             success:function(data){
	             	var role=data[0];
	             	$("#editform #edit_roleid").val(role.role_id);
	             	$("#editform #role_id").val(role.role_id);
	             	$("#editform #role_name").val(role.role_name);
	             	$("#editform #role_level").val(role.role_level);
	             	$("#editform #role_desc").val(role.role_desc);
	             }
			});
		}


		//提示是否删除该角色
		 function DeletePost(no){
			$("#del_roleid").html(no);
		 }

			 
		//授权
		 function ShouquanPost(roleid){
		 	$("#shouquanform .role_id").val(roleid);
			$.ajax({
	             url:"${pageContext.request.contextPath}/sq/shouquanRole.do",
	             type:"POST",
	             data:{"roleid":roleid},
	             dataType:"json",
	             cache:false,
	             success:function(data){
		             if(data==""){
		             	$("#xzjs input:checked").attr("checked",false);
		             }else{
		             	var l=$("#xzjs input");   	
		             	for(var i=0; i<l.length; i++){
		             		for(var k=0; k<data.length; k++){
		             			if(l[i].value==data[k].id){
		             		    	$("#xzjs .treeid"+l[i].value).attr("checked",true);
		             			}
		             		}
		             	}
		             }
				 }
			});
		 }
	</script>
	
<!-- 添加角色 -->
	<div id="add_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">添加角色</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
			      <form class="form-horizontal" name="addform" id="addform">
	                  <div class="control-group">
	                    <label class="control-label">角色编码</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="角色编码" name="role_id" id="role_id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">角色名称</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="角色名称" name="role_name" id="role_name" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">角色级别</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="角色级别" name="role_level" id="role_level" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">角色描述</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="角色描述" name="role_desc" id="role_desc" />
	                    </div>
	                  </div>	                 
	              </form>
              </div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-primary" onclick="sendAddrole();">保存</button>
		  </div>
	</div>
	
	<script type="text/javascript">
			//添加角色保存请求
			function sendAddrole(){
				$.ajax({
		             url:"${pageContext.request.contextPath}/role/addRole.do",
		             type:"POST",
		             data:$("#addform").serialize(),
		             dataType:"json",
		             cache:false,
		             success:function(data){
		                  if(data.message=="ok"){
		                  	  alert("添加成功");
		                      window.location="${pageContext.request.contextPath}/role/roleInfo.do";
		                  }else{
		              		  alert(data.message);
		                  }
		             }
				 });
			 }
	</script>
	
	
<!-- 修改角色 -->
	<div id="modify_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">修改角色</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
			      <form class="form-horizontal" name="editform" id="editform">
	                  <div class="control-group">
	                    <label class="control-label">角色编码</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="edit_roleid" id="edit_roleid" disabled="disabled" />
	                      <input class="span" type="hidden" name="role_id" id="role_id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">角色名称</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="role_name" id="role_name"/>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">角色级别</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="role_level" id="role_level"/>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">角色描述</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="role_desc" id="role_desc"/>
	                    </div>
	                  </div>
	              </form>
              </div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-primary" onclick="sendEditrole();">保存</button>
		  </div>
	</div>
	
	<script type="text/javascript">
			 //修改角色保存请求
			 function sendEditrole(){
				$.ajax({
		             url:"${pageContext.request.contextPath}/role/updateRole.do",
		             type:"POST",
		             data:$("#editform").serialize(),
		             dataType:"json",
		             cache:false,
		             success:function(data){
		                  if(data.message=="ok"){
		                  	  alert("修改成功");
		                      window.location="${pageContext.request.contextPath}/role/roleInfo.do";
		                  }else{
		              		  alert(data.message);
		                  }
		             }
				 });
			 }
	</script>
	
	
<!-- 删除角色 -->
	<div id="delete_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">删除角色</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
		      	   <p>确定删除该角色吗？<span id="del_roleid" /></span></p>
              </div>
		  </div>
		  <div class="modal-footer">
		  		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	   			<button class="btn btn-primary" onclick="sendDelrole();">确定</button>
		  </div>
	</div>

	<script type="text/javascript">
		 //发送删除请求
		 function sendDelrole(){
			var del=$("#del_roleid").html();
			$.ajax({
	             url:"${pageContext.request.contextPath}/role/delRole.do",
	             type:"POST",
	             data:{"roleid":del},
	             dataType:"json",
	             success:function(data){
					if(data.message=="ok"){
				     	alert("删除成功");
				        window.location="${pageContext.request.contextPath}/role/roleInfo.do";
					}else{
					 	alert(data.message);
					}
	             }
			});
		 }
	</script>
	
	
<!-- 角色授权 -->
	<div id="Shouquan_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">角色授权</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
	
                <form class="form-horizontal" id="shouquanform">              
                  <div class="control-group">
                    <label class="control-label">请选择权限内容</label>
                    <div class="controls" id="xzjs">
                    	<input class="span role_id" type="hidden" name="role_id" />
                    	<c:forEach items="${allMenuList}" var="menu">
                    		<label class="radio">
	                    	<input type="checkbox" name="id" class="treeid${menu.id}" value="${menu.id}"/> ${menu.mname}
	                    	</label>
                    	</c:forEach>
					</div>
                  </div>
                </form>
 
              </div>
		  </div>
		  <div class="modal-footer">
		  		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	   			<button class="btn btn-primary" onclick="sendAddRoleFunction();">确定</button>
		  </div>
	</div>

<script type="text/javascript">
	 //发送角色授权菜单请求
	 function sendAddRoleFunction(){
			$.ajax({
	             url:"${pageContext.request.contextPath}/sq/addRoleFunction.do",
	             type:"POST",
	             data:$("#shouquanform").serialize(),
	             dataType:"json",
	             success:function(data){
					if(data.message=="ok"){
				     	alert("成功");
				        window.location="${pageContext.request.contextPath}/role/roleInfo.do";
					}else{
					 	alert(data.message);
					}
	             }
			});
	 }
</script>	
	
</body>
</html>
