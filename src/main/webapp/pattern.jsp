<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="common/jsp.expression.jsp" %> 
<!DOCTYPE html>
<html lang="zh-CN" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>"/><!-- 此值紧跟head标签,影响基础url -->
<jsp:include page="common/common.head.html"/>
<meta name="description" content="IT通用工具,ping测试,telnet测试,身份证验证,正则验证等等">
<meta name="keywords" content="it tools,ping测试,telnet测试,身份证验证,正则验证">
<title>正则验证</title>
<script type="text/javascript">
	function setAccessKeys()
	{
		document.getElementById('expression').accessKey="s"
		//document.getElementById('pwd').accessKey="p"
	}    
</script>
</head>
<body>
<header class="am-g app-head">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">常用工具</h1>
    <p class="am-article-meta"><a href="http://www.3q1j1b.cn">3q1j1b.cn</a></p>
  </div>
</header>
<hr class="am-article-divider"/>
<form class="am-form" method="post" action="<%=basePath%>service/exp">
	<textarea placeholder="每行输入一个待匹配项表达式" id="items" name="items" required="required" rows="5"><%if(null!=request.getAttribute("item")){%><%=request.getAttribute("item")%><%}%></textarea>
	<br/>
	<div class="am-input-group am-input-group-sm">		
		<input id="exp" name="exp" required="required" type="text" maxlength="500" autocomplete="on" class="am-input-sm am-form-field"
		placeholder="请输入正则表达式" pattern="^\S{1,1000}$" value="<%if(null!=request.getAttribute("exp")){%><%=request.getAttribute("exp")%><%}%>"/>
		<span class="am-input-group-btn">
			<BUTTON type="submit" class="am-btn am-btn-primary">开始验证</BUTTON>
		</span>
	</div>	
	<br>
	<textarea placeholder="匹配的项会显示在这里" readonly="readonly" rows="25"><%if(null!=request.getAttribute("res")){%><%=request.getAttribute("res")%><%}%></textarea>
</form>
<jsp:include page="common/common.foot.html"/>
</body>
</html>