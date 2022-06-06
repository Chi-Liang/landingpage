package com.hanye.info.batch.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hanye.info.batch.MailJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail1(){
        return JobBuilder.newJob(MailJob.class).storeDurably().build();
    }
    
    @Bean
    public Trigger trigger1(){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail1())
                .withSchedule(CronScheduleBuilder.cronSchedule("* * 1 ? * *"))
                .build();
    }

}