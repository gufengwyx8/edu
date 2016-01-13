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
					<s:iterator value="cetList" var="c">
					{
						"cet.id":"<s:property value='#c.id' escape='false'/>",
						"cet.name":"<s:property value='#c.name' escape='false'/>",
						"cet.student.id":"<s:property value='#c.student.id' escape='false'/>",
						"cet.student.name":"<s:property value='#c.student.name' escape='false'/>",
						"cet.exam.startTime":"<s:property value='#c.exam.startTime' escape='false'/>",
						"cet.exam.room.id":"<s:property value='#c.exam.room.id' escape='false'/>",
						"cet.exam.room.name":"<s:property value='#c.exam.room.name' escape='false'/>",
						"cet.score":"<s:property value='#c.score' escape='false'/>",
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
					$.messager.alert('提示','四六级信息重复');
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
			四六级信息列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="cet.id" width="50">考试编号</th>
						<th field="cet.name" width="50">考试名称</th>
						<th field="cet.student.name" width="50">学生姓名</th>
						<th field="cet.exam.startTime" width="50">开始时间</th>
						<th field="cet.exam.room.name" width="50">考场名称</th>
						<th field="cet.score" width="50">成绩</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<s:if test="loginUser.type.toString()=='ADMIN' || loginUser.type.toString()=='TEACHER'">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建四六级信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改四六级信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('exam/destoryCet','cet.id')">删除四六级信息</a>
				</s:if>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">四六级信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="cet.id" id="cetId" />
					<div class="fitem">
						<label>考试名称:</label>
						<input name="cet.name" class="easyui-validatebox" required="true"/>
					</div>
					<div class="fitem">
						<label>学生姓名:</label>
						<select class="easyui-combobox easyui-validatebox" name="cet.student.id" style="width:160px;" id="book" required="true">
							<s:iterator value="studentList" var="t">
								<option value="<s:property value='#t.id'/>"><s:property value="#t.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>考场名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="cet.exam.room.id" style="width:160px;" id="book" required="true">
							<s:iterator value="roomList" var="r">
								<option value="<s:property value='#r.id'/>"><s:property value="#r.main"/> <s:property value="#r.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>开始时间:</label>
						<input name="cet.exam.startTime"/>
					</div>
					<div class="fitem">
						<label>成绩:</label>
						<input name="cet.score"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('exam/saveCet',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
