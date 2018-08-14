/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  项 目 名： ittool<br/>
 *  文 件 名： WebSocketTest.java<br/>
 *  版本信息： V1.0.0<br/> 
 *  作    者： weig.lei<br/>
 *  日    期： 2017年8月31日-下午6:12:49
 * 
 ============================================*/

package com.ittool;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.net.telnet.TelnetClient;

import com.eudp.airtravel.util.StringUtil;

/**
 * 类 名 称： TelnetWebSocket<br/>
 * 类 描 述： <br/>
 * 创 建 人： weig.lei<br/>
 * 创建时间： 2017年8月31日 下午6:12:49<br/>
 * 修 改 人： weig.lei<br/>
 * 操作时间： 2017年8月31日 下午6:12:49<br/>
 * 操作原因：
 * 
 */
@ServerEndpoint("/service/telnet")
public final class TelnetWebSocket {
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {

		// Print the client message for testing purposes
		System.out.println("Received: " + message);
		
		String revMsg=null==message?"":message.trim();
		String ip=null==revMsg.split("@@@")[0]?"":revMsg.split("@@@")[0].trim();
		String port=null==revMsg.split("@@@")[1]?"":revMsg.split("@@@")[1].trim();
		if(StringUtil.isEmpty(ip)||StringUtil.isEmpty(port)){
			session.getBasicRemote().sendText("<TR><TD colspan=\"3\">输入错误</TD></TR>");
			return;
		}

		TelnetClient telnetClient = new TelnetClient("vt200");  //指明Telnet终端类型，否则会返回来的数据中文会乱码
		
        
        telnetClient.setConnectTimeout(3000);//
        String[] ports=port.split(",");


        
        
        
        for(int i=0;i<ports.length;i++){
        	try {
            	telnetClient.connect(ip,Integer.parseInt(ports[i]));  //建立一个连接,默认端口是23
                if(telnetClient.isAvailable()){
                	session.getBasicRemote().sendText("<TR><TD>"+ip+"</TD><TD>"+ports[i]+"</TD><TD><FONT color=green>Openning</FONT></TD></TR>");
                }
        	}catch (Exception e) {           
                e.printStackTrace();
                System.out.println("Exception:"+e.getMessage()); 
                //result.put(ports[i], "0");
                session.getBasicRemote().sendText("<TR><TD>"+ip+"</TD><TD>"+ports[i]+"</TD><TD><FONT color=red>Closed</FONT></TD></TR>");
                continue;
               
            }
        } 
		
		
        telnetClient.disconnect();		
		
		

		// Send the first message to the client
//		session.getBasicRemote().sendText("This is the first server message");

		// Send 3 messages to the client every 5 seconds
		
/*		int sentMessages = 0;
		while (sentMessages < 3) {
			Thread.sleep(2000);
			//session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sentMessages);
			session.getBasicRemote().sendText("<TR><TD>"+sentMessages+"</TD><TD>"+sentMessages+"</TD><TD><FONT color=\"green\">Openning</FONT></TD></TR>");
			sentMessages++;
		}*/
		

		// Send a final message to the client
		//session.getBasicRemote().sendText("This is the last server message");
	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected");
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
	
	@OnError
	public void onError(Session session, Throwable thr) {
		System.out.println(thr.getMessage());
	}
}
