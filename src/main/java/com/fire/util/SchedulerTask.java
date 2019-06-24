package com.fire.util;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
	private Logger logger=LoggerFactory.getLogger(SchedulerTask.class);
	
	private static final SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
	
	private int count= 0;
	//cron 秒分时日月周年
	@Scheduled(cron="0 * * * * ?")
	private void process(){
		
		logger.info("this is a SchedulerTask running "+ (count++));
		
	}
	
	@Scheduled(fixedRate=6000)
	public void reportCurrentTime(){
		logger.info("现在时间"+ sdf.format(new Date()));
	}
	
}
