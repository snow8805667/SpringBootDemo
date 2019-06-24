import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JavaMailSenderTest {

	@Autowired
	private JavaMailSender mailSender;
	
	@Test
	public void sendSimpleMail() throws Exception{
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("1373666320@qq.com");
		message.setTo("940729677@qq.com");
		message.setSubject("主题：简单的邮件111");
		message.setText("测试邮件内容！！！！");
		mailSender.send(message);
	}
	
}
