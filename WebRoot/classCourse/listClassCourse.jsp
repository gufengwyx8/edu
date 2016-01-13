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
					<s:iterator value="classCourseList" var="c">
					{
						"classCourse.id":"<s:property value='#c.id' escape='false'/>",
						"classCourse.clsInfo.id":"<s:property value='#c.clsInfo.id' escape='false'/>",
						"classCourse.clsInfo.name":"<s:property value='#c.clsInfo.name' escape='false'/>",
						"classCourse.course.id":"<s:property value='#c.course.id' escape='false'/>",
						"classCourse.course.name":"<s:property value='#c.course.name' escape='false'/>",
						"classCourse.teacher.id":"<s:property value='#c.teacher.id' escape='false'/>",
						"classCourse.teacher.name":"<s:property value='#c.teacher.name' escape='false'/>",
						"classCourse.year":"<s:property value='#c.year' escape='false'/>",
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
					$.messager.alert('提示','授课信息重复');
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
			授课信息列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="classCourse.clsInfo.name" width="50">班级名称</th>
						<th field="classCourse.course.name" width="50">课程名称</th>
						<th field="classCourse.teacher.id" width="50">教师编号</th>
						<th field="classCourse.teacher.name" width="50">教师姓名</th>
						<th field="classCourse.year" width="50">学年</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<s:if test="loginUser.type.toString()=='ADMIN'">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建授课信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改授课信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('classCourse/destoryClassCourse','classCourse.id')">删除授课信息</a>
				</s:if>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">授课信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="classCourse.id" id="classCourseId" />
					<div class="fitem">
						<label>班级名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="classCourse.clsInfo.id" style="width:160px;" id="book" required="true">
							<s:iterator value="clsInfoList" var="ci">
								<option value="<s:property value='#ci.id'/>"><s:property value="#ci.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>课程名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="classCourse.course.id" style="width:160px;" id="book" required="true">
							<s:iterator value="courseList" var="course">
								<option value="<s:property value='#course.id'/>"><s:property value="#course.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>教师名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="classCourse.teacher.id" style="width:160px;" id="book" required="true">
							<s:iterator value="teacherList" var="t">
								<option value="<s:property value='#t.id'/>"><s:property value="#t.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>学年:</label>
						<input name="classCourse.year">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('classCourse/saveClassCourse',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
