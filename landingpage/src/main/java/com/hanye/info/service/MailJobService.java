package com.hanye.info.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.hanye.info.vo.ReturnSendMailVo;
import com.hanye.info.vo.ReturnVo;

@Service
public class MailJobService {

	@Autowired
	private JobLauncher jobLauncher;

	@Qualifier("sendMailJob")
	@Autowired
	private Job sendMailJob;
	
	public ReturnVo startMailJob() {
		try {
			jobLauncher.run(sendMailJob,
					new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
			return new ReturnSendMailVo("success", "");
		} catch (Exception e) {
			return new ReturnSendMailVo("fail", e.getMessage());
		}
	}

}
