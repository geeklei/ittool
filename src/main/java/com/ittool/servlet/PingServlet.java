/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  项 目 名： ittool<br/>
 *  文 件 名： PingServlet.java<br/>
 *  版本信息： V1.0.0<br/> 
 *  作    者： weig.lei<br/>
 *  日    期： 2017年8月9日-下午5:49:55
 * 
 ============================================*/

package com.ittool.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eudp.airtravel.constant.UtilConstant;
import com.eudp.airtravel.util.NetUtil;
import com.eudp.airtravel.util.StringUtil;

/**
 * 类 名 称： PingServlet<br/>
 * 类 描 述： Ping服务<br/>
 * 创 建 人： weig.lei<br/>
 * 创建时间： 2017年8月9日 下午5:49:55<br/>
 * 修 改 人： weig.lei<br/>
 * 操作时间： 2017年8月9日 下午5:49:55<br/>
 * 操作原因： 
 * 
 */
public final class PingServlet  extends HttpServlet {
	/**  
	 * serialVersionUID:（用一句话描述这个变量表示什么）  <br/>
	 */
	private static final long serialVersionUID = -5891271204840606736L;
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/ping.jsp");
		dispatcher.forward(req, resp);
	}







	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ips=null==req.getParameter("ips")?"":req.getParameter("ips").trim();
		//System.out.println(ips);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/ping.jsp");
		if(StringUtil.isEmpty(ips) && !ips.matches(UtilConstant.IPS) && !ips.matches(UtilConstant.DOMAIN)){			
			dispatcher.forward(req, res);
			return;
		}
		Map<String,String> result= null;
		if(ips.matches(UtilConstant.ONE_IP) ||ips.matches(UtilConstant.DOMAIN)){
			
			if(ips.contains(",")){
				String[] ip=ips.split(",");
				result= new HashMap<String,String>();
				boolean isok;
				for(int i=0;i<ip.length;i++){
					isok=NetUtil.ping(ip[i]);
					if(isok){
						result.put(ip[i], "1");
						System.out.println("======================"+ip[i]+",通过======================");
					}else{
						result.put(ip[i], "0");
						System.out.println("======================"+ip[i]+",未通过======================");
					}	
				}
			}else{
				result= new HashMap<String,String>();
				boolean isok=NetUtil.ping(ips);
				if(isok){
					result.put(ips, "1");
					System.out.println("======================"+ips+",通过======================");
				}else{
					result.put(ips, "0");
					System.out.println("======================"+ips+",未通过======================");
				}				
			}			
		}else if(ips.matches(UtilConstant.ADJACENT_IP)){
			String[] ip=ips.split("/");
			result= new HashMap<String,String>();
			//String[] arrIp=new String[ip.length];
			boolean isok=NetUtil.ping(ip[0]);
			if(isok){
				result.put(ip[0], "1");
				System.out.println("======================"+ip[0]+",通过======================");
			}else{
				result.put(ip[0], "0");
				System.out.println("======================"+ip[0]+",未通过======================");
			}	
			String pre=ip[0].substring(0, ip[0].lastIndexOf(".",ip[0].length()))+".";
			for(int i=1;i<ip.length;i++){
				isok=NetUtil.ping(pre+ip[i]);
				if(isok){
					result.put(pre+ip[i], "1");
					System.out.println("======================"+pre+ip[i]+",通过======================");
				}else{
					result.put(pre+ip[i], "0");
					System.out.println("======================"+pre+ip[i]+",未通过======================");
				}	
			}
			
		}else if(ips.matches(UtilConstant.MULTI_IP)){
			String[] ip=ips.split(",");
			result= new HashMap<String,String>();
			boolean isok;
			for(int i=0;i<ip.length;i++){
				isok=NetUtil.ping(ip[i]);
				if(isok){
					result.put(ip[i], "1");
					System.out.println("======================"+ip[i]+",通过======================");
				}else{
					result.put(ip[i], "0");
					System.out.println("======================"+ip[i]+",未通过======================");
				}	
			}
		}
		
		
		
		req.setAttribute("mapRes", result);
		dispatcher.forward(req, res);		
		//String ips2=req.getAttribute("ips").toString();
		
		//System.out.println(ips2);
	}
}
