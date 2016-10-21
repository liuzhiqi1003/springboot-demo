package cn.lzq.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import cn.lzq.po.DemoMessage;
import cn.lzq.po.DemoResponse;

@Controller
public class WsController {

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public DemoResponse say(DemoMessage message) throws Exception{
		Thread.sleep(3000);
		DemoResponse response = new DemoResponse();
		response.setResponseMessage("Welcome,"+message.getName()+"!");
		return response;
	}
}
