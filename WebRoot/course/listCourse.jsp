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
					<s:iterator value="courseList" var="c">
					{
						"course.id":"<s:property value='#c.id' escape='false'/>",
						"course.name":"<s:property value='#c.name' escape='false'/>",
						"course.score":"<s:property value='#c.score' escape='false'/>",
						"course.hours":"<s:property value='#c.hours' escape='false'/>",
						"course.book.name":"<s:property value='#c.book.name' escape='false'/>",
						"course.book.id":"<s:property value='#c.book.id' escape='false'/>",
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
					$.messager.alert('提示','课程名称重复');
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
			课程列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="course.name" width="50">课程名称</th>
						<th field="course.score" width="50">学分</th>
						<th field="course.hours" width="50">学时</th>
						<th field="course.book.name" width="50">教材名称</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建课程</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改课程</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('course/destoryCourse','course.id')">删除课程</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">课程信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="course.id" id="courseId" />
					<div class="fitem">
						<label>课程名称:</label>
						<input name="course.name" class="easyui-validatebox" required="true">
					</div>
					<div class="fitem">
						<label>学时:</label>
						<input name="course.hours">
					</div>
					<div class="fitem">
						<label>学分:</label>
						 <input class="easyui-numberbox" name="course.score" required data-options="
							onChange: function(value){
							$('#vv').text(value);
							}" />
					</div>
					<div class="fitem">
						<label>教材:</label>
						<select class="easyui-combobox" name="course.book.id" style="width:160px;" id="book">
							<s:iterator value="bookList" var="b">
								<option value="<s:property value='#b.id'/>"><s:property value="#b.name"/></option>
							</s:iterator>
						</select>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('course/saveCourse',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
