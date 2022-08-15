package com.hanye.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.hanye.info.service.GroceryService;
import com.hanye.info.service.MailJobService;

@SpringBootTest
@AutoConfigureMockMvc
public class AbstractTest {
	
	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected MailJobService mailJobService;
	
	@Autowired
	protected GroceryService groceryService;
	
}
