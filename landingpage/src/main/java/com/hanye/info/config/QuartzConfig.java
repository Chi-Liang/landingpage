package com.hanye.info.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hanye.info.batch.MailJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobMailSend(){
        return JobBuilder.newJob(MailJob.class).storeDurably().build();
    }
    
    @Bean
    public Trigger trigger(){
        return TriggerBuilder.newTrigger()
                .forJob(jobMailSend())
                .withSchedule(CronScheduleBuilder.cronSchedule("* * 1 ? * *"))
                .build();
    }

}