package com.hanye.info;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
public class LandingpageApplicationTests extends AbstractTest {

	@Test
	@WithMockUser(username = "admin", password = "1qaz2wsx" )
	public void testSendMail() throws Exception {
		
//		mockMvc.perform(MockMvcRequestBuilders.post("/login").param("username", "admin").param("password", "1qaz2wsx"))
//		.andDo(MockMvcResultHandlers.print());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/sendmail"))
				.andDo(MockMvcResultHandlers.print());
		
	}
	
	
}
