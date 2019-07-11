package com.fire.config;

import java.io.IOException;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

//@Configuration
public class QuartzConfig {
	
	@Bean(name="SchedulerFactory")
	public SchedulerFactoryBean schedulerFactoryBean() throws IOException{
		SchedulerFactoryBean schedulerfacotory=new SchedulerFactoryBean();
		//用于quartz集群,QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
		schedulerfacotory.setOverwriteExistingJobs(true);
		//任务调度监听类
        //schedulerfacotory.setGlobalTriggerListeners(triggerListenerLogMonitor());
		return schedulerfacotory;
		
	}
	
	/*
	 * quartz初始化监听器
	 */
	@Bean
	public QuartzInitializerListener  executorListener(){
		return new QuartzInitializerListener();
	}
	
	@Bean(name="Scheduler")
	public Scheduler scheduler() throws IOException{
		Scheduler scheduler =schedulerFactoryBean().getScheduler();
		//添加同步任务
        addmyTestJob(scheduler);
        return scheduler;
	}
	
	private void addmyTestJob(Scheduler scheduler){
		String startJob="true";
		String jobName="DATAMART_SYNC";
		String jobGroup ="DATAMART_SYNC";
		String cron = "0 0/1 * * * ?";//定时的时间设置
		String className = myTest.class.getName();
		if(startJob!=null && startJob.equals("true")){
			addCommonCronJob(jobName, jobGroup, cron, scheduler, className);
			
		}else{
			  deleteCommonJob(jobName, jobGroup, scheduler);
		}
		
	}
	
	//删除定时任务
	private void deleteCommonJob(String jobName,String jobGroup,Scheduler scheduler){
		
		JobKey jobKey= JobKey.jobKey(jobName,jobGroup);
		
		try {
			scheduler.pauseJob(jobKey);//暂停任务
			scheduler.deleteJob(jobKey);//删除任务
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
   private void addCommonCronJob(String jobName,String jobGroup,String cron,Scheduler scheduler,String className){
	   
	   try {
		TriggerKey triggerKey=TriggerKey.triggerKey(jobName,jobGroup);
		   //任务触发
		Trigger checkExist = (Trigger) scheduler.getTrigger(triggerKey);
		   
		   if(checkExist!=null){
			   JobDetail jobDetail = null;
			   jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(className)).requestRecovery(true).withIdentity(jobName, jobGroup)
		               .build();;//当Quartz服务被中止后，再次启动或集群中其他机器接手任务时会尝试恢复执行之前未完成的所有任务
		       jobDetail.getJobDataMap().put("jobName", jobName);
		       jobDetail.getJobDataMap().put("jobGroup", jobGroup);
		       CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
		       
		       /*withMisfireHandlingInstructionDoNothing
		       ——不触发立即执行
		       ——等待下次Cron触发频率到达时刻开始按照Cron频率依次执行
		       withMisfireHandlingInstructionIgnoreMisfires
		       ——以错过的第一个频率时间立刻开始执行
		       ——重做错过的所有频率周期后
		       ——当下一次触发频率发生时间大于当前时间后，再按照正常的Cron频率依次执行
		       withMisfireHandlingInstructionFireAndProceed
		       ——以当前时间为触发频率立刻触发一次执行
		       ——然后按照Cron频率依次执行*/
		       CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup).withSchedule(cronScheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires()).build();
		       scheduler.scheduleJob(jobDetail, trigger);
			   
		   }else{
//			   scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
		       addCommonCronJob(jobName, jobGroup, cron, scheduler, className);
		   }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SchedulerException e) {
		e.printStackTrace();
	}
	   
   }
	
	
	
}
