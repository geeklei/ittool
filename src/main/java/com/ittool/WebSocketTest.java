/**===========================================
 *        Copyright (C) 2017 Tempus
 *           All rights reserved
 *
 *  �� Ŀ ���� ittool<br/>
 *  �� �� ���� WebSocketTest.java<br/>
 *  �汾��Ϣ�� V1.0.0<br/> 
 *  ��    �ߣ� weig.lei<br/>
 *  ��    �ڣ� 2017��8��31��-����6:12:49
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
 * �� �� �ƣ� WebSocketTest<br/>
 * �� �� ���� <br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��8��31�� ����6:12:49<br/>
 * �� �� �ˣ� weig.lei<br/>
 * ����ʱ�䣺 2017��8��31�� ����6:12:49<br/>
 * ����ԭ��
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
