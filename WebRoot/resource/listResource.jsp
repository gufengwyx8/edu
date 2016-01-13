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
		<script type="text/javascript">
	$(function() {
	});
</script>
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div>
			<div style="padding: 30px;">
				<div>
					<table class="detail_table">
						<tr>
							<th style="width:70%;">
								标题
							</th>
							<th>
								下载
							</th>
						</tr>
						<s:iterator value="resourceList" var="f">
							<tr>
								<td><s:property value="#f.title"/></td>
								<td><a href="resource/download?resource.id=<s:property value='#f.id'/>"><s:property value="#f.fileName"/></a></td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<s:if test="loginUser!=null&&loginUser.type.toString()=='TEACHER'">
				<div style="margin:30px 0;">
					<s:form action="addResource" namespace="/resource" method="post" enctype="multipart/form-data" >
						<s:textfield name="resource.title" label="名称"></s:textfield>
						<s:file name="file" label="附件"/>
						<s:submit value="提交"/>
					</s:form>
				</div>
				</s:if>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
