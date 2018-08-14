/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  �� Ŀ ���� ittool<br/>
 *  �� �� ���� PatternServlet.java<br/>
 *  �汾��Ϣ�� V1.0.0<br/> 
 *  ��    �ߣ� weig.lei<br/>
 *  ��    �ڣ� 2017��9��7��-����2:55:56
 * 
 ============================================*/

package com.ittool.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eudp.airtravel.util.StringUtil;

/**
 * �� �� �ƣ� PatternServlet<br/>
 * �� �� ���� <br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��9��7�� ����2:55:56<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��9��7�� ����2:55:56<br/>
 * ����ԭ�� 
 * 
 */
public final class PatternServlet extends HttpServlet {

	/**  
	 * serialVersionUID:����һ�仰�������������ʾʲô��  <br/>
	 */
	private static final long serialVersionUID = 4209876595399079653L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/pattern.jsp");
		dispatcher.forward(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String exp=null==req.getParameter("exp")?"":req.getParameter("exp").trim();
		String item=null==req.getParameter("items")?"":req.getParameter("items").trim();
		RequestDispatcher dispatcher=req.getRequestDispatcher("/pattern.jsp");
		if(StringUtil.isEmpty(exp)||StringUtil.isEmpty(item) || !exp.matches("^\\S{1,1000}$")){			
			dispatcher.forward(req, resp);
			return;
		}
		StringBuilder sb=new StringBuilder();
		String[] items=item.split("\r\n");
		String temp="";
		for(int i=0;i<items.length;i++){
			temp=null==items[i]?"":items[i];
			if(temp.matches(exp)){
				sb.append(items[i]+"\r\n");
			}
		}
		
		
		req.setAttribute("res", sb.toString());
		req.setAttribute("item", item);
		req.setAttribute("exp", exp);
		dispatcher.forward(req, resp);		
		//String ips2=req.getAttribute("ips").toString();
		
		//System.out.println(ips2);		
	}
	
	
	

}
