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
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/icon.css" />
		<script type="text/javascript" src="plugin/easyui/jquery.min.js"></script>
		<script type="text/javascript"
			src="plugin/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/datagrid.js"></script>
	</head>
	<body>
		<jsp:include page="top.jsp"></jsp:include>
		<div class="mainTitle">
		</div>
		<div style="width: 800px; margin: 0 auto;text-align:center;float:left;">
			<img src="image/index.jpg" width="600px"/>
		</div>
		<div>
			<div id="message-dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true"  buttons="#message-dlg-buttons">
				<div class="ftitle">添加公告</div>
				<form id="message-fm" method="post" novalidate action="postMessage">
					<div class="fitem">
						<label>标题:</label>
						<input type="text" name="message.title"/>
					</div>
					<div class="fitem">
						<label>内容:</label>
						<textarea name="message.content" ></textarea>
					</div>
				</form>
			</div>
			<div id="message-dlg-buttons">
				<script type="text/javascript">
					function postMessage(){
						$.post("postMessage",$("#message-fm").serialize(),function(result){
							location.reload();
						},'text');
					}
				</script>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="postMessage();">修改</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#message-dlg').dialog('close')">取消</a>
			</div>
			公告栏：<s:if test="loginUser!=null&&loginUser.getTypeName()!='学生'"><a href="#" onclick="$('#message-dlg').dialog('open').dialog('setTitle','添加公告');return false;">添加公告</a></s:if><br/>
			
			<ul>
				<s:iterator value="messageList" var="m" status="i">
					<s:if test="#i.index<=5">
						<li style="list-style: none;margin:15px 0;">
							<a href="showMessage?message.id=<s:property value='#m.id'/>"><s:property value="#m.title"/></a>
						</li>
					</s:if>
				</s:iterator>
			</ul>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
