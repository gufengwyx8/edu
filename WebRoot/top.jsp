<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="container">
	<div class="header">
		<div class="title">
			<div>
				综合教务管理系统
			</div>
		</div>
		<ul>
			<s:if test="loginUser!=null">
				<li>
					欢迎,
					<a href="userInfo?user.id=<s:property value='loginUser.id'/>"><s:property value="loginUser.name" /></a>
				</li>
				<li>
					<a href="#" onclick="$('#pwd-dlg').dialog('open').dialog('setTitle','修改密码');$('#pwd-fm').form('clear');return false;">修改密码</a>
				</li>
				<li>
					<a href="logout">登出</a>
				</li>
			</s:if>
			<s:else>
				<li>
					<a href="reg">注册</a>
				</li>
				<li>
					<a href="login">登录</a>
				</li>
			</s:else>
		</ul>
	</div>
	<div class="navList">
		<ul>
			<li>
				<a href="index">首页</a>
			</li>
			<s:if test="loginUser.type.toString()=='ADMIN'">
				<li>
					<a href="course/listCourse">课程管理</a>
				</li>
				<li>
					<a href="course/listBook">教材管理</a>
				</li>
				<li>
					<a href="classCourse/listClassCourse">授课信息管理</a>
				</li>
				<li>
					<a href="classCourse/listSchedule">课表管理</a>
				</li>
				<li>
					<a href="clsInfo/listClsInfo">班级管理</a>
				</li>
				<li>
					<a href="clsInfo/listRoom">教室管理</a>
				</li>
				<li>
					<a href="exam/listCet">四六级管理</a>
				</li>
				<li>
					<a href="exam/listComputer">计算机等级考试管理</a>
				</li>
				<li>
					<a href="exam/listExam">期末考试管理</a>
				</li>
				<li>
					<a href="user/listUser">用户管理</a>
				</li>
				<li>
					<a href="resource/listResource">资源管理</a>
				</li>
				<li>
					<a href="article/listArticle">留言板</a>
				</li>
			</s:if>
			<s:elseif test="loginUser.type.toString()=='TEACHER'">
				<li>
					<a href="exam/listCet">四六级成绩发布</a>
				</li>
				<li>
					<a href="exam/listCet">计算机等级考试成绩发布</a>
				</li>
				<li>
					<a href="course/listScore">期末考试成绩发布</a>
				</li>
				<li>
					<a href="exam/listExam">考场安排查询</a>
				</li>
				<li>
					<a href="classCourse/listClassCourse">授课查询</a>
				</li>
				<li>
					<a href="classCourse/listSchedule">课表查询</a>
				</li>
				<li>
					<a href="resource/listResource">资源管理</a>
				</li>
				<li>
					<a href="article/listArticle">留言板</a>
				</li>
			</s:elseif>
			<s:elseif test="loginUser.type.toString()=='STUDENT'">
				<li>
					<a href="exam/listCet">四六级成绩查询</a>
				</li>
				<li>
					<a href="exam/listComputer">等级考试成绩查询</a>
				</li>
				<li>
					<a href="course/listScore">期末考试成绩查询</a>
				</li>
				<li>
					<a href="exam/listExam">考场安排查询</a>
				</li>
				<li>
					<a href="classCourse/listClassCourse">授课查询</a>
				</li>
				<li>
					<a href="classCourse/listSchedule">课表查询</a>
				</li>
				<li>
					<a href="resource/listResource">资源管理</a>
				</li>
				<li>
					<a href="article/listArticle">留言板</a>
				</li>
			</s:elseif>
		</ul>
		<div id="pwd-dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#pwd-dlg-buttons">
			<div class="ftitle">修改密码</div>
			<form id="pwd-fm" method="post" novalidate>
				<div class="fitem">
					<label>旧密码:</label>
					<input type="password" name="oldPassword">
				</div>
				<div class="fitem">
					<label>新密码:</label>
					<input type="password" name="newPassword1" >
				</div>
				<div class="fitem">
					<label>确认密码:</label>
					<input type="password" name="newPassword2">
				</div>
			</form>
		</div>
		<div id="pwd-dlg-buttons">
			<script type="text/javascript">
				function changePassword(){
					$.post("password",$("#pwd-fm").serialize(),function(result){
						if(result=='old error'){
							$.messager.alert("提示","原始密码不正确");
						}else if(result=='new error'){
							$.messager.alert("提示","新密码不一致");
						}else{
							$.messager.alert("提示","修改成功");
							$('#pwd-dlg').dialog('close');
						}
					},'text');
				}
			</script>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="changePassword();">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#pwd-dlg').dialog('close')">取消</a>
		</div>
	</div>
	<div class="main">
		<div class="mainBody">