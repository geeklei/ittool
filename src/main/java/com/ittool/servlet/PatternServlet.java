/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  项 目 名： ittool<br/>
 *  文 件 名： PatternServlet.java<br/>
 *  版本信息： V1.0.0<br/> 
 *  作    者： weig.lei<br/>
 *  日    期： 2017年9月7日-下午2:55:56
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
 * 类 名 称： PatternServlet<br/>
 * 类 描 述： <br/>
 * 创 建 人： weig.lei<br/>
 * 创建时间： 2017年9月7日 下午2:55:56<br/>
 * 修 改 人： weig.lei<br/>
 * 操作时间： 2017年9月7日 下午2:55:56<br/>
 * 操作原因： 
 * 
 */
public final class PatternServlet extends HttpServlet {

	/**  
	 * serialVersionUID:（用一句话描述这个变量表示什么）  <br/>
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
