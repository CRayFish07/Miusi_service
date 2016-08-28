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
		if (confirm("你确定要删除该图片吗?")) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<%@include file="/top_table.jsp"%> 
	<s:a
		href="addMorePicture.action?picture.series_id=%{#request.list.get(0).series_id}">增加新图片</s:a>
	<table border="1" width="95%" align="center">
		<tr>
			<td>编号<br></td>
			<td>图片/视频</td>
			<td>删除</td>
		</tr>
		<s:iterator value="#request.list" id="picture">
			<tr>
				<td><s:property value="#picture.id" /></td>
				<td><img src=" <s:property value="#picture.url" />"
					width="150px" /></td>
				<td><s:radio list="#{'1':'会员可见','0':'用户可见'}"
						  theme="simple"
						value="#picture.need_vip" disabled="true" /></td>
				<td><s:a
						href="removePicture.action?picture.id=%{#picture.id}&picture.series_id=%{#picture.series_id}"
						onclick="return del();">删除</s:a></td>

				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>