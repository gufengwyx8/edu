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
					<s:iterator value="scheduleList" var="c">
					{
						"schedule.id":"<s:property value='#c.id' escape='false'/>",
						"schedule.classCourse.clsInfo.id":"<s:property value='#c.classCourse.clsInfo.id' escape='false'/>",
						"schedule.classCourse.clsInfo.name":"<s:property value='#c.classCourse.clsInfo.name' escape='false'/>",
						"schedule.classCourse.id":"<s:property value='#c.classCourse.id' escape='false'/>",
						"schedule.classCourse.course.id":"<s:property value='#c.classCourse.course.id' escape='false'/>",
						"schedule.classCourse.course.name":"<s:property value='#c.classCourse.course.name' escape='false'/>",
						"schedule.classCourse.teacher.id":"<s:property value='#c.classCourse.teacher.id' escape='false'/>",
						"schedule.classCourse.teacher.name":"<s:property value='#c.classCourse.teacher.name' escape='false'/>",
						"schedule.classCourse.year":"<s:property value='#c.classCourse.year' escape='false'/>",
						"schedule.room.id":"<s:property value='#c.room.id' escape='false'/>",
						"schedule.room.name":"<s:property value='#c.room.name' escape='false'/>",
						"schedule.number":"<s:property value='#c.number' escape='false'/>",
						"schedule.weekday":"<s:property value='#c.weekday' escape='false'/>",
						"schedule.time":"星期<s:property value='#c.weekday' escape='false'/> 第<s:property value='#c.number'/>节",
					},
					</s:iterator>
				];
				return rows;
			}
			$(function(){
				initDataGrid($("#dg"),$("#dlg"),$("#fm"),getData());
			});
			function saveSuccess(e){
				if(e=="room"){
					$.messager.alert('提示','教室已被占用');
				}else if(e=="clsInfo"){
					$.messager.alert('提示','该班级在该时间段忙');
				}else if(e=="teacher"){
					$.messager.alert('提示','教师在该时间段不可用');
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
			课表管理
		</div>
		<div style="text-align:left;">
			<s:form action="listSchedule" namespace="/classCourse" theme="simple" method="get">
			<s:submit value="查询"/>
			<s:textfield name="msg"></s:textfield>
			</s:form>
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="schedule.classCourse.clsInfo.name" width="50">班级名称</th>
						<th field="schedule.classCourse.course.name" width="50">课程名称</th>
						<th field="schedule.classCourse.teacher.name" width="50">教师姓名</th>
						<th field="schedule.room.name" width="50">教室</th>
						<th field="schedule.time" width="50">上课时间</th>
						<th field="schedule.classCourse.year" width="50">学年学期</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<s:if test="loginUser.type.toString()=='ADMIN'">
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建课表信息</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改课表信息</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('classCourse/destorySchedule','schedule.id')">删除课表信息</a>
				</s:if>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">课表信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="schedule.id" id="scheduleId" />
					<div class="fitem">
						<label>授课信息:</label>
						<select class="easyui-combobox easyui-validatebox" name="schedule.classCourse.id" style="width:160px;" id="book" required="true">
							<s:iterator value="classCourseList" var="ci">
								<option value="<s:property value='#ci.id'/>">课程名:<s:property value="#ci.course.name"/> 班级:<s:property value="#ci.clsInfo.name"/> 教师:<s:property value="#ci.teacher.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>教室:</label>
						<select class="easyui-combobox easyui-validatebox" name="schedule.room.id" style="width:160px;" id="book" required="true">
							<s:iterator value="roomList" var="r">
								<option value="<s:property value='#r.id'/>"><s:property value="#r.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>星期:</label>
						 <input class="easyui-numberbox" name="schedule.weekday" required data-options="
							onChange: function(value){
							$('#vv').text(value);
							}" />
					</div>
					<div class="fitem">
						<label>节:</label>
						 <input class="easyui-numberbox" name="schedule.number" required data-options="
							onChange: function(value){
							$('#vv').text(value);
							}" />
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('classCourse/saveSchedule',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
