import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fire.util.MyMapper;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fire"})
//启注解事务管理
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = "com.fire.dao", markerInterface = MyMapper.class)
@EnableScheduling
public class Application {
     public static void main(String args[]){
    	 
    	 SpringApplication.run(Application.class, args);
     }
     @Autowired
 	private Environment env;

 	//destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
// 	@Bean(destroyMethod = "close")
// 	public DataSource dataSource() {
// 		DruidDataSource dataSource = new DruidDataSource();
// 		dataSource.setUrl(env.getProperty("spring.datasource.url"));
// 		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
// 		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
// 		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
// 		dataSource.setInitialSize(2);//初始化时建立物理连接的个数
// 		dataSource.setMaxActive(20);//最大连接池数量
// 		dataSource.setMinIdle(0);//最小连接池数量
// 		dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
// 		dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
// 		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
// 		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
// 		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
// 		return dataSource;
// 	}
}
