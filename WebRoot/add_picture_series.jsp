<%@ page language="java" import="java.util.*" pageEncoding="GB18030"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>����ͼƬ��</title>
</head>
<body>
	<%@include file="/top_table.jsp"%>   
	<s:form action="addPictureSeries" method="post">  
        <s:iterator value="new int[100]" var="pictureList" status="status">  
            <tr>
				<td><label>ͼƬ��ַ:</label>   <s:textfield cols="100" rows="1" name="%{'pictureList['+#status.index+'].url'}" theme="simple"></s:textfield> </td>
				<td><label>��Ա�ɼ�:</label>  
            <s:radio list="#{'1':'��Ա�ɼ�','0':'�û��ɼ�'}" name="%{'pictureList['+#status.index+'].need_vip'}" theme="simple" value="0"/>
            </td><tr> 
        </s:iterator>  
        <s:submit value="ȷ��"></s:submit>  
    </s:form>  	 

</body>
</html>