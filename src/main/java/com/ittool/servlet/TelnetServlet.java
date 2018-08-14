/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  项 目 名： ittool<br/>
 *  文 件 名： TelnetServlet.java<br/>
 *  版本信息： V1.0.0<br/> 
 *  作    者： weig.lei<br/>
 *  日    期： 2017年8月9日-下午5:50:48
 * 
 ============================================*/

package com.ittool.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.net.telnet.TelnetClient;

import com.eudp.airtravel.constant.UtilConstant;
import com.eudp.airtravel.util.StringUtil;

/**
 * 类 名 称： TelnetServlet<br/>
 * 类 描 述： <br/>
 * 创 建 人： weig.lei<br/>
 * 创建时间： 2017年8月9日 下午5:50:48<br/>
 * 修 改 人： weig.lei<br/>
 * 操作时间： 2017年8月9日 下午5:50:48<br/>
 * 操作原因： 
 * 
 */
public class TelnetServlet implements Servlet {

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#destroy()
	 */
	public void destroy() {
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig arg0) throws ServletException {
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String ip=null==req.getParameter("ip")?"":req.getParameter("ip").trim();
		String port=null==req.getParameter("port")?"":req.getParameter("port").trim();
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/telnet.jsp");
		if(StringUtil.isEmpty(ip) || StringUtil.isEmpty(port) ||(!ip.matches(UtilConstant.ONE_IP) && !ip.matches(UtilConstant.ONE_DOMAIN))){			
			dispatcher.forward(req, res);
			return;
		}
		TelnetClient telnetClient = new TelnetClient("vt200");  //指明Telnet终端类型，否则会返回来的数据中文会乱码
		Map<String,String> result=  new HashMap<String,String>();
		
            
        telnetClient.setConnectTimeout(2000);//socket延迟时间：3000ms
        String[] ports=port.split(",");
        for(int i=0;i<ports.length;i++){
        	try {
            	telnetClient.connect(ip,Integer.parseInt(ports[i]));  //建立一个连接,默认端口是23
                if(telnetClient.isAvailable()){
                	result.put(ports[i], "1");
                }
        	}catch (Exception e) {           
                e.printStackTrace();
                System.out.println("Exception"+e.getMessage()); 
                result.put(ports[i], "0");
                continue;
               
            }
        } 
        telnetClient.disconnect();
		req.setAttribute("mapRes", result);
		req.setAttribute("ip", ip);
		dispatcher.forward(req, res);
	}

}
