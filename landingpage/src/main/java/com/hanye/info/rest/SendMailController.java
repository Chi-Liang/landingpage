package com.hanye.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanye.info.service.MailJobService;
import com.hanye.info.vo.ReturnSendMailVo;
import com.hanye.info.vo.ReturnVo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value = "用戶寄信接口", tags = "用戶寄信操作")
public class SendMailController {
	
	@Autowired
	private MailJobService mailJobService;
	
	@GetMapping("/sendmail")
	public ReturnVo SendMailStart() {
		return mailJobService.startMailJob();
	}
	
}
