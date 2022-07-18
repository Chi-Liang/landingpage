package com.hanye.info;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class LandingpageApplicationTests extends AbstractTest {

	@Test
	@WithMockUser(username = "admin", password = "1qaz2wsx")
	public void testSendMail() throws Exception {

			mockMvc.perform(MockMvcRequestBuilders.post("/api/sendmail").accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.result").value("success"))
					.andDo(MockMvcResultHandlers.print());

	}

}
