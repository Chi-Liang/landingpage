package com.hanye.info.batch;

import java.util.HashMap;
import java.util.Map;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;


@Service
public class MailJob extends QuartzJobBean {
	
	@Autowired
	private JobLocator jobLocator;
	
	@Autowired
    private JobLauncher jobLauncher;
	
	@Qualifier("sendMailJob")
	@Autowired
	private Job sendailMJob;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		Map<String, JobParameter> params = new HashMap<>();
		params.put("currentTime", new JobParameter(System.currentTimeMillis()));

		JobParameters jobParameters = new JobParameters(params);

		try {
			jobLauncher.run(sendailMJob, jobParameters);
		} catch (Exception e) {
			System.out.println("Exception while starting job");
		}
	}

}
