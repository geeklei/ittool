/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  �� Ŀ ���� ittool<br/>
 *  �� �� ���� PingServlet.java<br/>
 *  �汾��Ϣ�� V1.0.0<br/> 
 *  ��    �ߣ� weig.lei<br/>
 *  ��    �ڣ� 2017��8��9��-����5:49:55
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
 * �� �� �ƣ� PingServlet<br/>
 * �� �� ���� Ping����<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��8��9�� ����5:49:55<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��8��9�� ����5:49:55<br/>
 * ����ԭ�� 
 * 
 */
public final class PingServlet  extends HttpServlet {
	/**  
	 * serialVersionUID:����һ�仰�������������ʾʲô��  <br/>
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
						System.out.println("======================"+ip[i]+",ͨ��======================");
					}else{
						result.put(ip[i], "0");
						System.out.println("======================"+ip[i]+",δͨ��======================");
					}	
				}
			}else{
				result= new HashMap<String,String>();
				boolean isok=NetUtil.ping(ips);
				if(isok){
					result.put(ips, "1");
					System.out.println("======================"+ips+",ͨ��======================");
				}else{
					result.put(ips, "0");
					System.out.println("======================"+ips+",δͨ��======================");
				}				
			}			
		}else if(ips.matches(UtilConstant.ADJACENT_IP)){
			String[] ip=ips.split("/");
			result= new HashMap<String,String>();
			//String[] arrIp=new String[ip.length];
			boolean isok=NetUtil.ping(ip[0]);
			if(isok){
				result.put(ip[0], "1");
				System.out.println("======================"+ip[0]+",ͨ��======================");
			}else{
				result.put(ip[0], "0");
				System.out.println("======================"+ip[0]+",δͨ��======================");
			}	
			String pre=ip[0].substring(0, ip[0].lastIndexOf(".",ip[0].length()))+".";
			for(int i=1;i<ip.length;i++){
				isok=NetUtil.ping(pre+ip[i]);
				if(isok){
					result.put(pre+ip[i], "1");
					System.out.println("======================"+pre+ip[i]+",ͨ��======================");
				}else{
					result.put(pre+ip[i], "0");
					System.out.println("======================"+pre+ip[i]+",δͨ��======================");
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
					System.out.println("======================"+ip[i]+",ͨ��======================");
				}else{
					result.put(ip[i], "0");
					System.out.println("======================"+ip[i]+",δͨ��======================");
				}	
			}
		}
		
		
		
		req.setAttribute("mapRes", result);
		dispatcher.forward(req, res);		
		//String ips2=req.getAttribute("ips").toString();
		
		//System.out.println(ips2);
	}
}
