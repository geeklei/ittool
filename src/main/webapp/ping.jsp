<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="common/jsp.expression.jsp" %>    
<!DOCTYPE html>
<html lang="zh-CN" class="no-js">
<head>
<base href="<%=basePath%>"/><!-- 此值紧跟head标签,影响基础url -->
<jsp:include page="common/common.head.html"/>
<meta name="description" content="IT通用工具,ping测试,telnet测试,身份证验证等等">
<meta name="keywords" content="it tools,ping测试,telnet测试,身份证验证">
<title>ping,ping测试,ping工具</title>
</head>
<body onload="setAccessKeys()">
<header class="am-g app-head">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">常用工具</h1>
    <p class="am-article-meta"><a href="http://www.3q1j1b.cn">3q1j1b.cn</a></p>
  </div>
</header>
<hr class="am-article-divider"/>

<form action="<%=basePath%>service/ping" method="post" class="am-form">
<div class="am-input-group am-input-group-sm">
	<input id="ips" name="ips" required="required" type="text" maxlength="100" autocomplete="on"  class="am-input-sm am-form-field"
	placeholder="格式:xxx.xxx.xxx.xxx或者xxx.xxx.xxx.xxx/yyy/zzz或者xxx.xxx.xxx.xxx,yyy.yyy.yyy.yyy或者3q1j1b.cn或者3q1j1b.cn,img.3q1j1b.cn"
	pattern="(^\d{1,3}\.\d{1,3}\.\d{1,3}\.(\d{1,3}|\d{1,3}(/\d{1,3})+|\d{1,3}(\,\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})+)$)|(^(\w{1,100}\.)?((\w|-){1,100})\.\w{1,100}(,(\w{1,100}\.)?((\w|-){1,100})\.\w{1,100})*$)"/>
	<span class="am-input-group-btn">
		<BUTTON type="submit" class="am-btn am-btn-primary">Ping测试</BUTTON>
	</span>
</div>
</form>
<BR />
<%if(null!=request.getAttribute("mapRes")){%>
<TABLE class="am-table am-table-bordered am-table-striped am-table-hover am-table-radius">
<THEAD>
	<TR><TH>IP</TH><TH>是否ping通</TH></TR>
</THEAD>
<TBODY>
	<%
		HashMap<String,String> res=(HashMap<String,String>)request.getAttribute("mapRes");
		Set<String> keySet=res.keySet();
		Iterator<String> keys=keySet.iterator();
		String key,value;
		while(keys.hasNext()){
			key=keys.next();
			value=res.get(key);			
	%>
	<TR>
		<TD><%=key%></TD>
		<TD>
			<% if(value.equals("1")){%>
				<FONT color="green">通(Yes)</FONT>
			<%}else{%>
				<FONT color="red">不通(No)</FONT>
			<%} %>
		</TD>
		
	</TR>
	<%}%>
</TBODY>
<%} %>
</TABLE>
<jsp:include page="common/common.foot.html"/>
<script type="text/javascript">
	function setAccessKeys()
	{
		document.getElementById('ips').accessKey="s"
		//document.getElementById('pwd').accessKey="p"
	}
</script>
</body>
</html>