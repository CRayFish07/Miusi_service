<%@ page language="java" import="java.util.*" pageEncoding="GB18030"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ͼƬ���б�</title>
<script type="text/javascript">
	function del() {
		if (confirm("��ȷ��Ҫɾ����ͼƬ����?")) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<%@include file="/top_table.jsp"%> 
	<s:a href="add_picture_series.jsp">������ͼƬ��</s:a>
	<table border="1" width="95%" align="center">
		<tr>
			<td>���<br></td>
			<td>ͼƬ/��Ƶ</td>
			<td>ɾ��</td>
			<td>�༭<br></td>
		</tr>
		<s:iterator value="#request.list" id="series">
			<tr>
				<td><s:property value="#series.id" /></td>
				<td><img src=" <s:property value="#series.url" />"
					width="150px" /></td>
				<td><s:a href="removeSeries.action?series.id=%{#series.id}"
						onclick="return del();">ɾ��</s:a></td>
				<td><s:a href="showSeries.action?series.id=%{#series.id}">��ʾ����</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>