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
					<s:iterator value="clsInfoList" var="c">
					{
						"clsInfo.id":"<s:property value='#c.id' escape='false'/>",
						"clsInfo.name":"<s:property value='#c.name' escape='false'/>",
						"clsInfo.teacher.id":"<s:property value='#c.teacher.id' escape='false'/>",
						"clsInfo.teacher.name":"<s:property value='#c.teacher.name' escape='false'/>",
						"clsInfo.year":"<s:property value='#c.year' escape='false'/>",
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
					$.messager.alert('提示','班级信息重复');
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
			班级信息列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="clsInfo.name" width="50">班级名称</th>
						<th field="clsInfo.teacher.id" width="50">辅导员编号</th>
						<th field="clsInfo.teacher.name" width="50">辅导员姓名</th>
						<th field="clsInfo.year" width="50">学年</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建班级信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改班级信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('clsInfo/destoryClsInfo','clsInfo.id')">删除班级信息</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">班级信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="clsInfo.id" id="clsInfoId" />
					<div class="fitem">
						<label>班级名称:</label>
						<input name="clsInfo.name" class="easyui-validatebox" required="true">
					</div>
					<div class="fitem">
						<label>辅导员名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="clsInfo.teacher.id" style="width:160px;" id="book" required="true">
							<s:iterator value="teacherList" var="t">
								<option value="<s:property value='#t.id'/>"><s:property value="#t.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>学年:</label>
						<input name="clsInfo.year">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('clsInfo/saveClsInfo',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
