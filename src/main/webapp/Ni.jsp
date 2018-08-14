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
<title>身份证验证</title>
</head>
<body>
<header class="am-g app-head">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">常用工具</h1>
    <p class="am-article-meta"><a href="http://www.3q1j1b.cn">3q1j1b.cn</a></p>
  </div>
</header>
<hr class="am-article-divider"/>
<form action="<%=basePath%>service/nv" method="post" class="am-form">
<div class="am-input-group am-input-group-sm">
	<input id="card" name="card" required="required" type="text" maxlength="18" autocomplete="on"  class="am-input-sm am-form-field"
	placeholder="支持大陆15或18位及港澳台身份证"
	pattern="(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$)|(^[a-zA-Z][0-9]{9}$)|(^[1|5|7][0-9]{6}\(?[0-9A-Z]\)?$)|(^[A-Z]{1,2}[0-9]{6}\(?[0-9A]\)?$)"/>
	<span class="am-input-group-btn">
		<BUTTON type="submit" class="am-btn am-btn-primary">身份验证</BUTTON>
	</span>
</div>
</form>
<BR />
<%if(null!=request.getAttribute("mapRes")){%>
<TABLE class="am-table am-table-bordered am-table-striped am-table-hover am-table-radius">
<!-- <THEAD>
	<TR><TH></TH><TH></TH></TR>
</THEAD> -->
<TBODY>
	<%
		HashMap<String,String> res=(HashMap<String,String>)request.getAttribute("mapRes");		
	%>
	<TR>
		<TD>号码状态</TD>
		<TD>
			<% if("1".equals(res.get("isok"))){%>
				<FONT color="green">正确(Yes)</FONT>
			<%}else{%>
				<FONT color="red">错误(No)</FONT>
			<%} %>		
		</TD>
		
	</TR>
	<% if("1".equals(res.get("isok"))){%>
		<TR>
			<TD>发征地</TD>
			<TD><%=res.get("address") %></TD>
			
		</TR>
	
		<TR>
			<TD>生日</TD>
			<TD>
				<%=res.get("birthday") %>
			</TD>
			
		</TR>
		<TR>
			<TD>性别</TD>
			<TD>
			<% if("M".equalsIgnoreCase(res.get("sex"))){%>
				男
			<%}else{%>
				女
			<%} %>	
				
			</TD>
			
		</TR>	
		<TR>
			<TD>18位身份证号</TD>
			<TD>
				<%=res.get("idcard") %>
			</TD>
			
		</TR>	
	<%} %>
</TBODY>
<%} %>
</TABLE>
<jsp:include page="common/common.foot.html"/>
<script type="text/javascript">
	function setAccessKeys()
	{
		document.getElementById('card').accessKey="s"
		//document.getElementById('pwd').accessKey="p"
	}
</script>
</body>
</html>