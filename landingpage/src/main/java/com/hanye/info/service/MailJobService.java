package com.hanye.info.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MailJobService {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Qualifier("sendMailJob")
	@Autowired
	Job sendMailJob;
	
	public void startMailJob() {
		Map<String, JobParameter> params = new HashMap<>();
		params.put("currentTime", new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(params);
		
		try {
			JobExecution jobExecution = 
				 jobLauncher.run(sendMailJob, jobParameters);
		}catch(Exception e) {
			System.out.println("Exception while starting job");
		}
	}
	
}
