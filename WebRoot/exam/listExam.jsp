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
					<s:iterator value="examList" var="c">
					{
						"exam.id":"<s:property value='#c.id' escape='false'/>",
						"exam.startTime":"<s:property value='#c.startTime' escape='false'/>",
						"exam.room.id":"<s:property value='#c.room.id' escape='false'/>",
						"exam.room.name":"<s:property value='#c.room.name' escape='false'/>",
						"exam.classCourse.id":"<s:property value='#c.classCourse.id' escape='false'/>",
						"exam.classCourse.clsInfo.name":"<s:property value='#c.classCourse.clsInfo.name' escape='false'/>",
						"exam.classCourse.course.name":"<s:property value='#c.classCourse.course.name' escape='false'/>",
						"exam.classCourse.teacher.name":"<s:property value='#c.classCourse.teacher.name' escape='false'/>",
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
					$.messager.alert('提示','期末考试信息重复');
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
			期末考试信息列表
		</div>
		<div style="text-align:left;">
			<s:form action="listExam" namespace="/exam" method="get" theme="simple">
				<s:submit value="查询" />
				<s:textfield name="value"></s:textfield>
			</s:form>
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="exam.classCourse.clsInfo.name" width="50">班级名称</th>
						<th field="exam.classCourse.course.name" width="50">课程名称</th>
						<th field="exam.room.name" width="50">考场名称</th>
						<th field="exam.classCourse.teacher.name" width="50">监考老师</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<s:if test="loginUser.type.toString()=='ADMIN'">
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建期末考试信息</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改期末考试信息</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('exam/destoryExam','exam.id')">删除期末考试信息</a>
				</s:if>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">期末考试信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="exam.id" id="examId" />
					<div class="fitem">
						<label>授课信息:</label>
						<select class="easyui-combobox easyui-validatebox" name="exam.classCourse.id" style="width:160px;" id="book" required="true">
							<s:iterator value="classCourseList" var="ci">
								<option value="<s:property value='#ci.id'/>">课程名:<s:property value="#ci.course.name"/> 班级:<s:property value="#ci.clsInfo.name"/> 教师:<s:property value="#ci.teacher.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>考场名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="exam.room.id" style="width:160px;" id="book" required="true">
							<s:iterator value="roomList" var="r">
								<option value="<s:property value='#r.id'/>"><s:property value="#r.main"/> <s:property value="#r.name"/></option>
							</s:iterator>
						</select>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('exam/saveExam',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
