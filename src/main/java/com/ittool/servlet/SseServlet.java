/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  项 目 名： ittool<br/>
 *  文 件 名： SseServlet.java<br/>
 *  版本信息： V1.0.0<br/> 
 *  作    者： weig.lei<br/>
 *  日    期： 2017年8月15日-下午2:23:37
 * 
 ============================================*/

package com.ittool.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类 名 称： SseServlet<br/>
 * 类 描 述： <br/>
 * 创 建 人： weig.lei<br/>
 * 创建时间： 2017年8月15日 下午2:23:37<br/>
 * 修 改 人： weig.lei<br/>
 * 操作时间： 2017年8月15日 下午2:23:37<br/>
 * 操作原因： 
 * 
 */
public final class SseServlet extends HttpServlet {

	/**  
	 * serialVersionUID:（用一句话描述这个变量表示什么）  <br/>
	 */
	private static final long serialVersionUID = -4434503873218697116L;

	
	
	
	

/*	 (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/event-stream");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Expires", "-1");
		//resp.getWriter().write("data:"+new Date());
		PrintWriter out;
		out=resp.getWriter();
		out.println("event:message");
	    out.println("id:140312");
		out.println("data:"+new Date());
		out.println();
		out.flush();
		out.close();
	}*/





/*	 (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		resp.setContentType("text/event-stream");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Expires", "-1");
		//resp.getWriter().write("data:"+new Date());
		PrintWriter out;
		out=resp.getWriter();
		out.println("event:message");
	    out.println("id:140312");
		out.println("data:"+new Date());
		out.println();
		out.flush();
		out.close();
		
	//第三步：获取HTTP请求中的参数信息
	  String clientName=req.getParameter("clientName");
	  if(clientName!=null)
	   clientName=new String(clientName.getBytes("UTF-8"),"UTF-8");
	  else
	   clientName="我的朋友";		
		//第四步：生成HTTP响应结果
	  PrintWriter out;
	  String title="HelloServlet";
	  String heading1="HelloServlet的doGet方法的输出：";
	  //set content type
	  resp.setContentType("text/html;charset=GB2312");
	  //write html page
	  out=resp.getWriter();
	  out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
	  out.print("</HEAD><BODY>");
	  out.print(heading1);
	  out.println("<h1><p>"+clientName+":您好</h1>");
	  out.print("</BODY></HTML>");
	  out.close();
		
	}*/





	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/event-stream");
		resp.setCharacterEncoding("utf-8");
		//resp.setHeader("Cache-Control", "no-cache");
		//resp.setHeader("Expires", "-1");
		//resp.getWriter().write("data:"+new Date());
		PrintWriter out;
		out=resp.getWriter();
		out.println("event:message");
	    out.println("id:1");
		out.println("data:"+new Date());
		out.println("retry:1000");//控制多长时间往客户端推送数据，默认为3000毫秒
		out.println();
		out.flush();
		out.close();
	}
}
