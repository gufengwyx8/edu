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
								日期
							</th>
							<th>
								提问人
							</th>
							<s:if test="loginUser.type.toString()=='ADMIN'">
								<th>
									删除
								</th>
							</s:if>
						</tr>
						<s:iterator value="articleList" var="a">
							<tr>
								<td><a href="article/showArticle?article.id=<s:property value='#a.id'/>"><s:property value="#a.title"/></a></td>
								<td><s:date name="#a.date" format="yyyy-MM-dd"/></td>
								<td><s:property value="#a.user.name"/></td>
								<s:if test="loginUser.type.toString()=='ADMIN'">
									<td><a href="article/removeArticle?article.id=<s:property value='#a.id'/>">删除</a></td>
								</s:if>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div style="margin:30px 0;">
					<s:form action="postArticle" namespace="/article" method="post">
						<s:textfield name="article.title" label="标题"></s:textfield>
						<script type="text/javascript" src="plugin/ckeditor/ckeditor.js"></script>
						<script type="text/javascript" src="plugin/ckfinder/ckfinder.js"></script>
						<s:textarea name="article.content" label="内容" rows="10" cols="59"></s:textarea>
						<s:submit value="发帖"/> 
					</s:form>
				</div>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
