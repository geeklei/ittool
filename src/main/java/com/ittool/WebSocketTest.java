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
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 类 名 称： WebSocketTest<br/>
 * 类 描 述： <br/>
 * 创 建 人： weig.lei<br/>
 * 创建时间： 2017年8月31日 下午6:12:49<br/>
 * 修 改 人： weig.lei<br/>
 * 操作时间： 2017年8月31日 下午6:12:49<br/>
 * 操作原因：
 * 
 */
@ServerEndpoint("/websocketTest")
public final class WebSocketTest {
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {

		// Print the client message for testing purposes
		System.out.println("Received: " + message);

		// Send the first message to the client
		session.getBasicRemote().sendText("This is the first server message");

		// Send 3 messages to the client every 5 seconds
		int sentMessages = 0;
		while (sentMessages < 3) {
			Thread.sleep(5000);
			session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sentMessages);
			sentMessages++;
		}

		// Send a final message to the client
		session.getBasicRemote().sendText("This is the last server message");
	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected");
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
}
