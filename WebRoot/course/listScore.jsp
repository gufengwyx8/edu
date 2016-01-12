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
					<s:iterator value="scoreList" var="c">
					{
						"score.id":"<s:property value='#c.id' escape='false'/>",
						"score.student.id":"<s:property value='#c.student.id' escape='false'/>",
						"score.student.name":"<s:property value='#c.student.name' escape='false'/>",
						"score.classCourse.clsInfo.id":"<s:property value='#c.classCourse.clsInfo.id' escape='false'/>",
						"score.classCourse.clsInfo.name":"<s:property value='#c.classCourse.clsInfo.name' escape='false'/>",
						"score.classCourse.id":"<s:property value='#c.classCourse.id' escape='false'/>",
						"score.classCourse.course.name":"<s:property value='#c.classCourse.course.name' escape='false'/>",
						"score.classCourse.teacher.id":"<s:property value='#c.classCourse.teacher.id' escape='false'/>",
						"score.classCourse.teacher.name":"<s:property value='#c.classCourse.teacher.name' escape='false'/>",
						"score.score":"<s:property value='#c.score' escape='false'/>",
						"score.classCourse.year":"<s:property value='#c.classCourse.year' escape='false'/>",
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
					$.messager.alert('提示','成绩名称重复');
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
			成绩列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="score.student.name" width="50">学生姓名</th>
						<th field="score.classCourse.clsInfo.name" width="50">班级名称</th>
						<th field="score.classCourse.course.name" width="50">课程名称</th>
						<th field="score.classCourse.teacher.name" width="50">授课教师</th>
						<th field="score.score" width="50">分数</th>
						<th field="score.classCourse.year" width="50">学年</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<s:if test="loginUser.type.toString()=='ADMIN' || loginUser.type.toString()=='TEACHER'">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建成绩</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改成绩</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('course/destoryScore','score.id')">删除成绩</a>
				</s:if>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">成绩信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="score.id" id="scoreId" />
					<div class="fitem">
						<label>授课信息:</label>
						<select class="easyui-combobox easyui-validatebox" name="score.classCourse.id" style="width:160px;" id="book" required="true">
							<s:iterator value="classCourseList" var="ci">
								<option value="<s:property value='#ci.id'/>">课程名:<s:property value="#ci.course.name"/> 班级:<s:property value="#ci.clsInfo.name"/> 教师:<s:property value="#ci.teacher.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>学生姓名:</label>
						<select class="easyui-combobox easyui-validatebox" name="score.student.id" style="width:160px;" id="book" required="true">
							<s:iterator value="studentList" var="t">
								<option value="<s:property value='#t.id'/>"><s:property value="#t.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>分数:</label>
						 <input class="easyui-numberbox" name="score.score" required data-options="
							onChange: function(value){
							$('#vv').text(value);
							}" />
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('course/saveScore',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
