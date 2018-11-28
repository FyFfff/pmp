<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>menuInfo</title>
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
							<h5>菜单列表</h5>
							<div class="widget-buttons">
				                <a href="#" data-title="Add Menu" data-toggle="modal" data-target="#add_example_modal"><i class="icon-plus"> 添加</i></a>			                
				            </div>
						</div>
						<div class="widget-body">
							<table class="table table-striped table-bordered dataTable" style="font-size:14px">
								<thead>
									<tr>
										<th>菜单编号</th>
										<th>菜单名称</th>
										<th>上级菜单</th>
										<th>菜单地址</th>
										<th>菜单状态</th>
										<th>菜单等级</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${allMenuList}" var="mn" >		
										<tr>
											<td>${mn.id}</td>
											<td>${mn.mname}</td>
											<td>${mn.parentid}</td>
											<td>${mn.url}</td>
											<td>${mn.state}</td>
											<td>${mn.t_level}</td>
											<td>
												 <div class="btn-group">
							                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#"> Action<span class="caret"></span></a>
							                        <ul class="dropdown-menu pull-right">
							                          <li><a href="#" data-title="Edit User" data-toggle="modal" data-target="#modify_example_modal" onclick="EditPost(${mn.id});" ><i class="icon-edit" ></i> 修改</a></li>
							                          <li><a href="#" data-title="Delete User" data-toggle="modal" data-target="#delete_example_modal" onclick="DeletePost(${mn.id});"><i class="icon-trash" ></i> 删除</a></li>
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
		function EditPost(mid){
			$.ajax({
	             url:"${pageContext.request.contextPath}/menu/editMenu.do",
	             type:"POST",
	             data:{"id":mid},
	             dataType:"json",
	             success:function(data){
	             	var menu=data[0];
	             	$("#editform #edit_id").val(menu.id);
	             	$("#editform #id").val(menu.id);
	             	$("#editform #mname").val(menu.mname);
	             	$("#editform #parentid").val(menu.parentid);
	             	$("#editform #url").val(menu.url);
	             	$("#editform #t_level").val(menu.t_level);
	             	if(menu.state=="open"){       
	             		$("#editform #state option[value='open']").attr("selected",true);
	             	}else if(menu.state=="close"){	
	             		$("#editform #state option[value='close']").attr("selected",true);
	             	}
	             }
			});
		}


		//提示是否删除该角色
		 function DeletePost(no){
			$("#del_id").html(no);
		 }

	</script>
	
<!-- 添加菜单 -->
	<div id="add_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">添加菜单</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
			      <form class="form-horizontal" name="addform" id="addform">
	                  <div class="control-group">
	                    <label class="control-label">菜单名称</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="菜单名称" name="mname" id="mname" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">上级菜单</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="上级菜单" name="parentid" id="parentid" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单地址</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="菜单地址" name="url" id="url" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单状态</label>
	                    <div class="controls">
		                    <select class="span1" name="state" id="state" >
		                    	<option value="open" >开启</option>
		                    	<option value="close" >关闭</option>
		                    </select>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单等级</label>
	                    <div class="controls">
	                      <input class="span" type="text" placeholder="菜单等级" name="t_level" id="t_level" />
	                    </div>
	                  </div>	                 
	              </form>
              </div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-primary" onclick="sendAddmenu();">保存</button>
		  </div>
	</div>
	
	<script type="text/javascript">
			//添加菜单保存请求
			function sendAddmenu(){
				$.ajax({
		             url:"${pageContext.request.contextPath}/menu/addMenu.do",
		             type:"POST",
		             data:$("#addform").serialize(),
		             dataType:"json",
		             cache:false,
		             success:function(data){
		                  if(data.message=="ok"){
		                  	  alert("添加成功");
		                      window.location="${pageContext.request.contextPath}/menu/menuInfo.do";
		                  }else{
		              		  alert(data.message);
		                  }
		             }
				 });
			 }
	</script>
	
	
<!-- 修改菜单 -->
	<div id="modify_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">修改菜单</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
			      <form class="form-horizontal" name="editform" id="editform">
	                  <div class="control-group">
	                    <label class="control-label">菜单编号</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="edit_id" id="edit_id" disabled="disabled" />
	                      <input class="span" type="hidden" name="id" id="id" />
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单名称</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="mname" id="mname"/>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">上级菜单</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="parentid" id="parentid"/>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单地址</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="url" id="url"/>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单状态</label>
	                    <div class="controls">
	                      <select class="span1" name="state" id="state" >
		                    	<option value="open" >开启</option>
		                    	<option value="close" >关闭</option>
		                  </select>
	                    </div>
	                  </div>
	                  <div class="control-group">
	                    <label class="control-label">菜单等级</label>
	                    <div class="controls">
	                      <input class="span" type="text" name="t_level" id="t_level"/>
	                    </div>
	                  </div>
	              </form>
              </div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-primary" onclick="sendEditmenu();">保存</button>
		  </div>
	</div>
	
	<script type="text/javascript">
			 //修改角色保存请求
			 function sendEditmenu(){
				$.ajax({
		             url:"${pageContext.request.contextPath}/menu/updateMenu.do",
		             type:"POST",
		             data:$("#editform").serialize(),
		             dataType:"json",
		             cache:false,
		             success:function(data){
		                  if(data.message=="ok"){
		                  	  alert("修改成功");
		                      window.location="${pageContext.request.contextPath}/menu/menuInfo.do";
		                  }else{
		              		  alert(data.message);
		                  }
		             }
				 });
			 }
	</script>
	
	
<!-- 删除菜单 -->
	<div id="delete_example_modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h4 id="myModalLabel">删除菜单</h4>
		  </div>
		  <div class="modal-body">
		      <div class="widget-forms clearfix">
		      	   <p>确定删除该菜单吗？<span id="del_id" /></span></p>
              </div>
		  </div>
		  <div class="modal-footer">
		  		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	   			<button class="btn btn-primary" onclick="sendDelmenu();">确定</button>
		  </div>
	</div>

	<script type="text/javascript">
		 //发送删除请求
		 function sendDelmenu(){
			var del=$("#del_id").html();
			$.ajax({
	             url:"${pageContext.request.contextPath}/menu/delMenu.do",
	             type:"POST",
	             data:{"id":del},
	             dataType:"json",
	             success:function(data){
					if(data.message=="ok"){
				     	alert("删除成功");
				        window.location="${pageContext.request.contextPath}/menu/menuInfo.do";
					}else{
					 	alert(data.message);
					}
	             }
			});
		 }
	</script>

	
</body>
</html>
