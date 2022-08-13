package com.hanye.info.batch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import com.hanye.info.service.MailJobService;


@Service
public class MailJob extends QuartzJobBean {
	
	@Autowired
	private MailJobService mailJobService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		mailJobService.startMailJob();
	}

}
