import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fire.util.WebSocket;

@RestController
@RequestMapping("api")
public class socketTestController {
	@Autowired
	private WebSocket webSocket;
	@RequestMapping("/sendAllMessage")
	public String test(){
		String message="hahahahhahhhdfsdfsd";
		webSocket.sendAllMessage(message);
		return "xiao xi fa song wan cheng";
	}
	@RequestMapping("/sendOneMessage")
	public String sendOneMessage(){
		String message="发送单点消息";
		webSocket.sendAllMessage(message);
		return "单点消息发送完成";
	}
	
}
