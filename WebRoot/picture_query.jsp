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
		if (confirm("��ȷ��Ҫɾ����ͼƬ��?")) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<%@include file="/top_table.jsp"%> 
	<s:a
		href="addMorePicture.action?picture.series_id=%{#request.list.get(0).series_id}">������ͼƬ</s:a>
	<table border="1" width="95%" align="center">
		<tr>
			<td>���<br></td>
			<td>ͼƬ/��Ƶ</td>
			<td>ɾ��</td>
		</tr>
		<s:iterator value="#request.list" id="picture">
			<tr>
				<td><s:property value="#picture.id" /></td>
				<td><img src=" <s:property value="#picture.url" />"
					width="150px" /></td>
				<td><s:radio list="#{'1':'��Ա�ɼ�','0':'�û��ɼ�'}"
						  theme="simple"
						value="#picture.need_vip" disabled="true" /></td>
				<td><s:a
						href="removePicture.action?picture.id=%{#picture.id}&picture.series_id=%{#picture.series_id}"
						onclick="return del();">ɾ��</s:a></td>

				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>