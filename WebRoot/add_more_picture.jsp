<%@ page language="java" import="java.util.*" pageEncoding="GB18030"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新增图片组</title>
</head>
<body>
	<%@include file="/top_table.jsp"%>
	<s:label value="%{#request.series_id}"></s:label>
	<s:form action="addMorePicture2.action?series_id=%{#request.series_id}"
		method="post">
		<s:iterator value="new int[20]" var="pictureList" status="status">
			<label>图片地址:</label>
			<s:textfield cols="100" rows="1"
				name="%{'pictureList['+#status.index+'].url'}" theme="simple"></s:textfield>
			<label>会员可见:</label>
			<s:radio list="#{'1':'会员可见','0':'用户可见'}"
				name="%{'pictureList['+#status.index+'].need_vip'}" theme="simple"
				value="0" />
			<br />
		</s:iterator>
		<s:submit value="Add"></s:submit>
	</s:form>

</body>
</html>