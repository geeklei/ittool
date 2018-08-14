<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/jsp.expression.jsp" %> 
<!DOCTYPE html>
<html lang="zh-CN" class="no-js">
<head>
<base href="<%=basePath%>"/><!-- 此值紧跟head标签,影响相对路径 -->
<jsp:include page="common/common.head.html"/>
<meta name="description" content="IT通用工具,ping测试,telnet测试,身份证验证,正则验证,移动端,手机,ipad上的IT工具等等">
<meta name="keywords" content="it tools,ping测试,telnet测试,身份证验证,正则验证,手机上的IT工具,移动端上IT工具,IPAD上IT工具,平板上的IT工具">
<base target="_blank"/>
<title>it tools,ping测试,telnet测试,身份证验证</title>
</head>
<body>
<!-- <ul class="am-nav am-nav-tabs am-nav-justify">
	<li class="am-active"><a href="ping.jsp">ping测试</a></li>
	<li><a href="telnet.jsp">telnet测试</a></li>
	<li><a href="#">身份证验证</a></li>
</ul> -->
<!-- <a class="am-badge am-badge-success" href="ping.jsp">ping</a>
<a class="am-badge am-badge-success" href="telnet.jsp">telnet</a>
<a class="am-badge am-badge-primary" href="#">身份证验证</a> -->
<header class="am-g app-head">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">常用工具</h1>
    <p class="am-article-meta"><a href="http://www.3q1j1b.cn">3q1j1b.cn</a></p>
  </div>
</header>
<hr class="am-article-divider"/>
<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
    <ul class="am-tabs-nav am-cf">
        <li class="am-active"><a href="[data-tab-panel-0]">Ping测试</a></li>
        <li class=""><a href="[data-tab-panel-1]">Telnet测试</a></li>
        <li class=""><a href="[data-tab-panel-2]">身份证验证</a></li>
        <li class=""><a href="[data-tab-panel-3]">正则表达式</a></li>
        <li class=""><a href="[data-tab-panel-4]">路由追踪</a></li>
        <li class=""><a href="[data-tab-panel-5]">HTTP状态查询</a></li>
        <li class=""><a href="[data-tab-panel-6]">其他工具</a></li>
    </ul>
    <div class="am-tabs-bd">
        <div data-tab-panel-0 class="am-tab-panel am-active">
        	【Ping测试】Ping是Windows、Unix和Linux系统下的一个命令。Ping也属于一个通信协议，是TCP/IP协议的一部分。利用“Ping”命令可以检查网络是否连通，可以很好地帮助我们分析和判定网络故障。
        	<BR />
        	【格式】127.0.0.1或者127.0.0.1/2/3或者127.0.0.1,192.168.1.1或者3q1j1b.cn或者3q1j1b.cn,img.3q1j1b.cn
        	<a class="am-badge am-badge-success am-radius am-text-default" href="ping.jsp">去测试</a>
        </div>
        <div data-tab-panel-1 class="am-tab-panel ">
        	【telnet测试】Telnet协议是TCP/IP协议族中的一员，是Internet远程登陆服务的标准协议和主要方式。它为用户提供了在本地计算机上完成远程主机工作的能力。在终端使用者的电脑上使用telnet程序，用它连接到服务器。终端使用者可以在telnet程序中输入命令，这些命令会在服务器上运行，就像直接在服务器的控制台上输入一样。可以在本地就能控制服务器。
        	<BR />
        	【格式】255.255.255.255或www.3q1j1b.cn
        	<a class="am-badge  am-radius am-text-default am-badge-success" href="telnet.jsp">去测试</a>
        </div>
        <div data-tab-panel-2 class="am-tab-panel ">
                                 【 身份证验证】支持大陆15位或18位及港澳台的身份证验证。可以用于验证身份证的真假和归属地、生日、性别等.
            <BR />
        	【格式】130503670401001或者13050319670401001X或者N236312940或者C668668(9)等
        	<a class="am-badge  am-radius am-text-default am-badge-success" href="Ni.jsp">去验证</a>
        </div>
        <div data-tab-panel-3 class="am-tab-panel ">
                                 【 正则表达式】在编写处理字符串的程序或网页时，经常有查找符合某些复杂规则的字符串的需要。正则表达式就是用于描述这些规则的工具。换句话说，正则表达式就是记录文本规则的代码。
            <BR />
        	【格式】匹配项每行一个
        	<a class="am-badge  am-radius am-text-default am-badge-success" href="pattern.jsp">去验证</a>
        </div> 
        <div data-tab-panel-4 class="am-tab-panel ">
                                 【 路由追踪】路由器追踪功能，能够帮助站长识别网络通行情况，同时也是网络管理人员很好的辅助工具！Tracert（跟踪路由）是路由跟踪实用程序，用于确定 IP 数据报访问目标所采取的路径。Tracert 命令用 IP 生存时间 (TTL) 字段和 ICMP 错误消息来确定从一个主机到网络上其他主机的路由。
<BR />
Tracert 工作原理<BR />
通过向目标发送不同 IP 生存时间 (TTL) 值的“Internet 控制消息协议 (ICMP)”回应数据包，Tracert 诊断程序确定到目标所采取的路由。要求路径上的每个路由器在转发数据包之前至少将数据包上的 TTL 递减 1。数据包上的 TTL 减为 0 时，路由器应该将“ICMP 已超时”的消息发回源系统。
Tracert 先发送 TTL 为 1 的回应数据包，并在随后的每次发送过程将 TTL 递增 1，直到目标响应或 TTL 达到最大值，从而确定路由。通过检查中间路由器发回的“ICMP 已超时”的消息确定路由。某些路由器不经询问直接丢弃 TTL 过期的数据包，这在 Tracert 实用程序中看不到。
            <BR />
        	【格式】192.168.1.100或者www.3q1j1b.cn
        	<a class="am-badge  am-radius am-text-default" href="#">去测试</a>
        </div> 
        <div data-tab-panel-5 class="am-tab-panel ">
                                 【 HTTP状态查询】一些常见的状态码为：200 - 服务器成功返回网页, 404 - 请求的网页不存在, 503 - 服务不可用
          	<BR />
            1xx（临时响应） <BR />
			表示临时响应并需要请求者继续执行操作的状态代码。 <BR />
			代码 说明 <BR />
			100 （继续） 请求者应当继续提出请求。 服务器返回此代码表示已收到请求的第一部分，正在等待其余部分。 <BR />
			101 （切换协议） 请求者已要求服务器切换协议，服务器已确认并准备切换。 <BR />
			2xx （成功） <BR />
			表示成功处理了请求的状态代码。 <BR />
			代码 说明 <BR />
			200 （成功） 服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。 <BR />
			201 （已创建） 请求成功并且服务器创建了新的资源。 <BR />
			202 （已接受） 服务器已接受请求，但尚未处理。 <BR />
			203 （非授权信息） 服务器已成功处理了请求，但返回的信息可能来自另一来源。 <BR />
			204 （无内容） 服务器成功处理了请求，但没有返回任何内容。 <BR />
			205 （重置内容） 服务器成功处理了请求，但没有返回任何内容。 <BR />
			206 （部分内容） 服务器成功处理了部分 GET 请求。 <BR />
			3xx （重定向） <BR />
			表示要完成请求，需要进一步操作。 通常，这些状态代码用来重定向。 <BR />
			代码 说明 <BR />
			300 （多种选择） 针对请求，服务器可执行多种操作。 服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择。 <BR />
			301 （永久移动） 请求的网页已永久移动到新位置。 服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。 <BR />
			302 （临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。 <BR />
			303 （查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。 <BR />
			304 （未修改） 自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容。 <BR />
			305 （使用代理） 请求者只能使用代理访问请求的网页。 如果服务器返回此响应，还表示请求者应使用代理。 <BR />
			307 （临时重定向） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。 <BR />
			4xx（请求错误） <BR />
			这些状态代码表示请求可能出错，妨碍了服务器的处理。 <BR />
			代码 说明 <BR />
			400 （错误请求） 服务器不理解请求的语法。 <BR />
			401 （未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。 <BR />
			403 （禁止） 服务器拒绝请求。 <BR />
			404 （未找到） 服务器找不到请求的网页。 <BR />
			405 （方法禁用） 禁用请求中指定的方法。 <BR />
			406 （不接受） 无法使用请求的内容特性响应请求的网页。 <BR />
			407 （需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。 <BR />
			408 （请求超时） 服务器等候请求时发生超时。 <BR />
			409 （冲突） 服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息。 <BR />
			410 （已删除） 如果请求的资源已永久删除，服务器就会返回此响应。 <BR />
			411 （需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。 <BR />
			412 （未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。 <BR />
			413 （请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。 <BR />
			414 （请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。 <BR />
			415 （不支持的媒体类型） 请求的格式不受请求页面的支持。 <BR />
			416 （请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。 <BR />
			417 （未满足期望值） 服务器未满足"期望"请求标头字段的要求。 <BR />
			5xx（服务器错误） <BR />
			这些状态代码表示服务器在尝试处理请求时发生内部错误。 这些错误可能是服务器本身的错误，而不是请求出错。 <BR />
			代码 说明 <BR />
			500 （服务器内部错误） 服务器遇到错误，无法完成请求。 <BR />
			501 （尚未实施） 服务器不具备完成请求的功能。 例如，服务器无法识别请求方法时可能会返回此代码。 <BR />
			502 （错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。 <BR />
			503 （服务不可用） 服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。 <BR />
			504 （网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。 <BR />
			505 （HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。 <BR />
            <BR />
        	【格式】http://www.3q1j1b.cn或者http://www.3q1j1b.cn,http://www.3q1j1b.cn/info/154.jspx
        	<a class="am-badge  am-radius am-text-default" href="#">去测试</a>
        </div>                      
        <div data-tab-panel-6 class="am-tab-panel ">
                                 【其他工具】大家如果有其他工具需求。
            <BR />
            1.可以通过微信公众号联系作者(推荐)
            <BR />
        	<IMG alt="作者微信公众号" src="img/qrcode_for_gh_e924a320a17f_430.jpg" />
        	<BR />
        	2.可以通过在线留言
        	<a class="am-badge  am-radius am-text-default am-badge-success" href="http://www.3q1j1b.cn/guestbook.jspx">去留言</a>
        </div>    
    
    </div>
</div>
<jsp:include page="common/common.foot.html"/>
</body>
</html>