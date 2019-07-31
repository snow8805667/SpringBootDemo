import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fire.rabbitmq.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RabbitMqHelloTest {
	
	@Autowired
	private HelloSender helloSender;
	
	@Test
	public void hello() throws Exception{
		helloSender.send1();
	}
	
	
}
