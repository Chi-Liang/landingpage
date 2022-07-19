package com.hanye.info;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hanye.info.service.MailJobService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbstractTest {
	
	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected MailJobService mailJobService;
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	
}
