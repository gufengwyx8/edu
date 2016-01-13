<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />

		<title>Index</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/icon.css" />
		<script type="text/javascript" src="plugin/easyui/jquery.min.js"></script>
		<script type="text/javascript"
			src="plugin/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/datagrid.js"></script>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="userList" var="c">
					{
						"user.id":"<s:property value='#c.id' escape='false'/>",
						"user.name":"<s:property value='#c.name' escape='false'/>",
						"user.type":"<s:property value='#c.type' escape='false'/>",
						"user.typeName":"<s:property value='#c.typeName' escape='false'/>",
						"user.sex":"<s:property value='#c.sex' escape='false'/>",
						"user.password":"<s:property value='#c.password' escape='false'/>",
					},
					</s:iterator>
				];
				return rows;
			}
			$(function(){
				initDataGrid($("#dg"),$("#dlg"),$("#fm"),getData());
			});
			function saveSuccess(e){
				if(e=="error"){
					$.messager.alert('提示','用户信息重复');
				}else if(e=="success"){
					$.messager.alert('提示','保存成功');
					location.href=location.href;
				}
			}
		</script>
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div class="mainTitle">
			<s:if test="type==null">
				用户信息管理
			</s:if>
			<s:elseif test="type.toString()=='ADMIN'">
				管理员信息管理
			</s:elseif>
			<s:elseif test="type.toString()=='TEACHER'">
				教师信息管理
			</s:elseif>
			<s:elseif test="type.toString()=='STUDENT'">
				学生信息管理
			</s:elseif>
		</div>
		<div style="text-align:center;">
			<a href="user/listUser?type=ADMIN">管理员信息管理</a>
			<a href="user/listUser?type=TEACHER">教师信息管理</a>
			<a href="user/listUser?type=STUDENT">学生信息管理</a>
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="user.id" width="50">用户编号</th>
						<th field="user.name" width="50">用户名</th>
						<th field="user.typeName" width="50">用户类型</th>
						<th field="user.sex" width="50">性别</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建用户信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改用户信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('user/destoryUser','user.id')">删除用户信息</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">用户信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="user.id" id="userId" />
					<div class="fitem">
						<label>用户名</label>
						<input type="text" name="user.name"/>
					</div>
					<div class="fitem">
						<label>密码</label>
						<input type="password" name="user.password"/>
					</div>
					<div class="fitem">
						<label>用户类型:</label>
						<select class="easyui-combobox easyui-validatebox" name="user.type" style="width:160px;" id="book" required="true">
							<option value="ADMIN">管理员</option>
							<option value="TEACHER">教师</option>
							<option value="STUDENT">学生</option>
						</select>
					</div>
					<div class="fitem">
						<label>性别:</label>
						<select class="easyui-combobox" name="user.sex" style="width:160px;" id="book" >
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('user/saveUser',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
