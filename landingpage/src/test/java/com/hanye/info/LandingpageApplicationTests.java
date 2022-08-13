package com.hanye.info;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.hanye.info.model.mongo.GroceryItem;
import com.hanye.info.vo.ReturnVo;

@SpringBootTest
public class LandingpageApplicationTests extends AbstractTest {

	@Test
	public void testStartMailJob() {

		ReturnVo returnVo = mailJobService.startMailJob();
		assertSame(returnVo.getResult(),"success");

	}
	
	@Test
	public void testMongo() {

//		List<GroceryItem> item = mongoTemplate.findAll(GroceryItem.class);
//		assertTrue(item.size() > 0);
//		GroceryItemVo groceryItem = new GroceryItemVo();
//		groceryItem.setId("a");
//		groceryItem.setCategory("b");
//		groceryItem.setName("c");
//		mongoTemplate.save(groceryItem);
		

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
