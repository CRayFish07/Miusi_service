<%@ page language="java" import="java.util.*" pageEncoding="GB18030"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图片组列表</title>
<script type="text/javascript">
	function del() {
		if (confirm("你确定要删除该图片组吗?")) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<%@include file="/top_table.jsp"%> 
	<s:a href="add_picture_series.jsp">增加新图片组</s:a>
	<table border="1" width="95%" align="center">
		<tr>
			<td>编号<br></td>
			<td>图片/视频</td>
			<td>删除</td>
			<td>编辑<br></td>
		</tr>
		<s:iterator value="#request.list" id="series">
			<tr>
				<td><s:property value="#series.id" /></td>
				<td><img src=" <s:property value="#series.url" />"
					width="150px" /></td>
				<td><s:a href="removeSeries.action?series.id=%{#series.id}"
						onclick="return del();">删除</s:a></td>
				<td><s:a href="showSeries.action?series.id=%{#series.id}">显示详情</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>