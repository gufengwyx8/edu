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
				<div
					style="clear: both; margin: 10px 0 10px 0; border: solid 1px green">
					<div style="float: left; width: 20%; padding: 10px;">
						<s:property value="article.user.name" />
						<br />
					</div>
					<div
						style="float: left; width: 70%; padding: 10px; border-left: solid 1px green;">
						<div>
							标题：<s:property value="article.title"/>
							<s:date name="article.date" format="yyyy-MM-dd HH:mm:ss" />
						</div>
						<div style="clear: both; margin: 20px 0;">
							<s:property value="article.content" escape="false"/>
						</div>
					</div>
					<div style="clear: both;">
					</div>
				</div>
				<s:iterator value="articleList" var="a">
					<div
						style="clear: both; margin: 10px 0 10px 0; border: solid 1px green">
						<div style="float: left; width: 20%; padding: 10px;">
							<s:property value="#a.user.name" />
							<br />
						</div>
						<div
							style="float: left; width: 70%; padding: 10px; border-left: solid 1px green;">
							<div>
								<s:date name="#a.date" format="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="clear: both; margin: 20px 0;">
								<s:property value="#a.content" escape="false"/>
							</div>
						</div>
						<div style="clear: both;">
						</div>
					</div>
				</s:iterator>
				<div style="margin:30px 0;">
					<s:form action="postArticle" namespace="/article" method="post">
						<s:hidden name="article.parent.id" value="%{article.id}"/>
						<script type="text/javascript" src="plugin/ckeditor/ckeditor.js"></script>
						<script type="text/javascript" src="plugin/ckfinder/ckfinder.js"></script>
						<s:textarea name="article.content" label="内容" rows="10" cols="59" value=""></s:textarea>
						<s:submit value="回答"/>
					</s:form>
				</div>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
