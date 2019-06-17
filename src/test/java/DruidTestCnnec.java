


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fire.config.DruidConfig;




@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)//如果报错，把这个类放在测试类的根目录和主启动类平级
public class DruidTestCnnec {
	@Autowired
	private DruidConfig dataSource;//注入配置类
	
	@Test
	public void testconnect(){
		
		try {
			Connection connection=dataSource.getDataSource().getConnection();//获取连接
			System.out.println(connection);//打印连接
			String sql="select * from learn_resource";
			PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getInt("id")+","+rs.getString("author")+","+rs.getString("title")+","+rs.getString("url"));
				
			}
			connection.close();//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
