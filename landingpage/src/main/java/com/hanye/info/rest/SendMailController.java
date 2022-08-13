package com.hanye.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanye.info.service.MailJobService;
import com.hanye.info.vo.ReturnSendMailVo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value = "用戶寄信接口", tags = "用戶寄信操作")
public class SendMailController {
	
	@Autowired
	private MailJobService mailJobService;
	
	@PostMapping("/sendmail")
//	@ApiOperation(value = "寄信",tags = "用戶寄信",notes = "用戶註冊寄信")
	public ReturnSendMailVo SendMailStart() {
		ReturnSendMailVo returnSendMailVo = mailJobService.startMailJob();
		return returnSendMailVo;
	}
	
}
