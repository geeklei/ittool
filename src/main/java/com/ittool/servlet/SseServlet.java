/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  �� Ŀ ���� ittool<br/>
 *  �� �� ���� SseServlet.java<br/>
 *  �汾��Ϣ�� V1.0.0<br/> 
 *  ��    �ߣ� weig.lei<br/>
 *  ��    �ڣ� 2017��8��15��-����2:23:37
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
 * �� �� �ƣ� SseServlet<br/>
 * �� �� ���� <br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��8��15�� ����2:23:37<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��8��15�� ����2:23:37<br/>
 * ����ԭ�� 
 * 
 */
public final class SseServlet extends HttpServlet {

	/**  
	 * serialVersionUID:����һ�仰�������������ʾʲô��  <br/>
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
		
	//����������ȡHTTP�����еĲ�����Ϣ
	  String clientName=req.getParameter("clientName");
	  if(clientName!=null)
	   clientName=new String(clientName.getBytes("UTF-8"),"UTF-8");
	  else
	   clientName="�ҵ�����";		
		//���Ĳ�������HTTP��Ӧ���
	  PrintWriter out;
	  String title="HelloServlet";
	  String heading1="HelloServlet��doGet�����������";
	  //set content type
	  resp.setContentType("text/html;charset=GB2312");
	  //write html page
	  out=resp.getWriter();
	  out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
	  out.print("</HEAD><BODY>");
	  out.print(heading1);
	  out.println("<h1><p>"+clientName+":����</h1>");
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
		out.println("retry:1000");//���ƶ೤ʱ�����ͻ����������ݣ�Ĭ��Ϊ3000����
		out.println();
		out.flush();
		out.close();
	}
}
