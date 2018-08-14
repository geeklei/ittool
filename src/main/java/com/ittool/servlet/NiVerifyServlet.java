/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  �� Ŀ ���� ittool<br/>
 *  �� �� ���� NiVerifyServlet.java<br/>
 *  �汾��Ϣ�� V1.0.0<br/> 
 *  ��    �ߣ� weig.lei<br/>
 *  ��    �ڣ� 2017��9��4��-����10:19:08
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

import com.eudp.airtravel.util.NIUtil;
import com.eudp.airtravel.util.StringUtil;

/**
 * �� �� �ƣ� NiVerifyServlet<br/>
 * �� �� ���� ���֤��֤����<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��9��4�� ����10:19:08<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��9��4�� ����10:19:08<br/>
 * ����ԭ�� 
 * 
 */
public final class NiVerifyServlet extends HttpServlet {

	/**  
	 * serialVersionUID:����һ�仰�������������ʾʲô��  <br/>
	 */
	private static final long serialVersionUID = 5683807360034042396L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idCard=null==req.getParameter("card")?"":req.getParameter("card").trim();
		RequestDispatcher dispatcher=req.getRequestDispatcher("/Ni.jsp");
		if(StringUtil.isEmpty(idCard)){
			dispatcher.forward(req, resp);
			return;
		}
		Map<String,String> result=  new HashMap<String,String>();
		if(NIUtil.validateCard(idCard)){
			result.put("isok", "1");			
			if(idCard.length()<12){
				String[] res=NIUtil.validateIdCard10(idCard);
				result.put("address", res[0]);
				result.put("birthday", "N");
				result.put("sex", res[1]);
			}else{
				result.put("address", NIUtil.getProvinceByIdCard(idCard));
				result.put("birthday", NIUtil.getBirthByIdCard(idCard));
				result.put("sex", NIUtil.getGenderByIdCard(idCard));
			}
			result.put("idcard", idCard);			
			if(idCard.length()==15){
				result.put("idcard", NIUtil.conver15CardTo18(idCard));
			}
			
		}else{
			result.put("isok", "0");
		}
		req.setAttribute("mapRes", result);
		dispatcher.forward(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/Ni.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	

}
