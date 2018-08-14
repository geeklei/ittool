<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/jsp.expression.jsp" %>    
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>"/><!-- 此值紧跟head标签,影响基础url -->
<jsp:include page="common/common.head.html"/>
<meta name="description" content="IT通用工具,ping测试,telnet测试,身份证验证等等">
<meta name="keywords" content="it tools,ping测试,telnet测试,身份证验证">
<title>telnet,telnet测试,telnet工具</title>
<script type="text/javascript">
	function setAccessKeys()
	{
		document.getElementById('ip').accessKey="s"
		//document.getElementById('pwd').accessKey="p"
	}
	var webSocket =new WebSocket('ws://<%=noSchemePath%>service/telnet');
    webSocket.onerror = function(event) {
      onError(event)
    };
 
    webSocket.onopen = function(event) {
      onOpen(event)
    };
 
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
 
    function onMessage(event) {
      document.getElementById('result').innerHTML
        += event.data;
    }
 
/*     function onOpen(event) {
      document.getElementById('result').innerHTML
        = 'Connection established';
    } */
 
    function onError(event) {
      alert(event.data);
    }
 
    function start() {
      var checkIp=/^(\d{1,3}\.){3}\d{1,3}$|^(\w{1,100}\.)?(\w|-){1,100}\.\w{1,100}$/;   
      var checkPort=/^\d{1,8}(,\d{1,8})*$/;
      var ip=document.getElementById('ip').value;
      var port=document.getElementById('port').value;
      if(!checkIp.test(ip)){
    	  var $modal = $('#valid-modal');
          $modal.modal();
          return false; 
      }
      if(!checkPort.test(port)){
    	  var $modal = $('#valid-modal');
          $modal.modal();
          return false;  
      }
      webSocket.send(ip+"@@@"+port);
      return false;
    }
</script>
</head>
<body onload="setAccessKeys()">
<header class="am-g app-head">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">常用工具</h1>
    <p class="am-article-meta"><a href="http://www.3q1j1b.cn">3q1j1b.cn</a></p>
  </div>
</header>
<hr class="am-article-divider"/>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="valid-modal">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">验证不通过
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
      请按格式输入且不能为空。
    </div>
  </div>
</div>
<div class="am-form" data-am-validator id="am-form">
	<div class="am-input-group am-input-group-sm">
		<input id="ip" name="ip" required="required" type="text" maxlength="100" autocomplete="on" class="am-input-sm am-form-field"
		placeholder="格式:255.255.255.255或www.3q1j1b.cn"
		pattern="^(\d{1,3}\.){3}\d{1,3}$|^(\w{1,100}\.)?(\w|-){1,100}\.\w{1,100}$"/>	
		<span class="am-input-group-btn">
			<BUTTON type="button" class="am-btn am-btn-primary" onclick="start()">Telnet测试</BUTTON>
		</span>
	</div>
	<BR />
	<textarea rows="3" placeholder="扫描端口(以,分割)" id="port" name="port" required="required">80,8080,3128,8081,9080,1080,21,23,443,69,22,25,110,7001,9090,3389,1521,1158,2100,1433,3306</textarea>
</div>
<BR />
<%-- <%if(null!=request.getAttribute("mapRes")){%> --%>
<TABLE class="am-table am-table-bordered am-table-striped am-table-hover am-table-radius">
<THEAD>
	<TR><TH>地址</TH><TH>扫描端口</TH><TH>扫描结果</TH></TR>
</THEAD>
<TBODY id="result">
<%-- 	<%
		HashMap<String,String> res=(HashMap<String,String>)request.getAttribute("mapRes");
		Set<String> keySet=res.keySet();
		Iterator<String> keys=keySet.iterator();
		String key,value;
		while(keys.hasNext()){
			key=keys.next();
			value=res.get(key);			
	%> --%>
	<%-- <TR>
		<TD><%=request.getAttribute("ip")%></TD>
		<TD><%=key%></TD>
		<TD>
			<% if(value.equals("1")){%>
				<FONT color="green">Openning</FONT>
			<%}else{%>
				<FONT color="red">Closed</FONT>
			<%} %>
		</TD>
		
	</TR> --%>
	<%-- <%}%> --%>
</TBODY>
<%-- <%} %> --%>
</TABLE>
<jsp:include page="common/common.foot.html"/>
</body>
</html>