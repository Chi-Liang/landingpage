package com.hanye.info;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import com.hanye.info.vo.ReturnVo;

public class testSendMail extends AbstractTest {

	@Test
	public void testStartMailJob() {

		ReturnVo returnVo = mailJobService.startMailJob();
		assertEquals(returnVo.getResult(),"success");

	}
	
	
//	@Test
//	@WithMockUser(username = "admin", password = "1qaz2wsx")
//	public void testSendMail() throws Exception {
//
//			mockMvc.perform(MockMvcRequestBuilders.post("/api/sendmail").accept(MediaType.APPLICATION_JSON))
//					.andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
//					.andExpect(MockMvcResultMatchers.jsonPath("$.result").value("success"))
//					.andDo(MockMvcResultHandlers.print());
//
//	}

}
