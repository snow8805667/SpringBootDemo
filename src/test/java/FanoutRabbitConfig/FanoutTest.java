package FanoutRabbitConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fire.rabbitmq.HelloSender;

import javafx.application.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FanoutTest {
	@Autowired
	private HelloSender helloSender;
	
	@Test
	public void send() throws Exception{
		helloSender.send3();
	}
}
