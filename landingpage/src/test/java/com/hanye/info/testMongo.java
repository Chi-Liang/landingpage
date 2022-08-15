package com.hanye.info;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.github.javafaker.Faker;
import com.hanye.info.vo.GroceryItemVo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testMongo extends AbstractTest {
	
	private static String id;
	
	private static final Faker faker = Faker.instance();
	
	@BeforeAll
	public static void InitId(){
		id = faker.idNumber().invalid();
	}
	
	@Test
	@Order(1)
	public void testCreateGrocery() {
		groceryService.saveGroceryItem(new GroceryItemVo(id,faker.name().fullName(),faker.code().asin()));
	}
	
	@Test
	@Order(2)
	public void testQueryById() {
		var groceryItem = groceryService.findGroceryItem(id);
		assertEquals(groceryItem.getId(),id);
	}
	
	@Test
	@Order(3)
	public void testUpdateById() {
		groceryService.editGroceryItem(new GroceryItemVo(id,faker.name().fullName(),faker.code().asin()));
	}
	
	@Test
	@Order(4)
	public void testDeleteById() {
		groceryService.deleteGroceryItem(id);
	}
	
	@Test
	@Order(5)
	public void testQueryAll() {
		groceryService.findAllGroceryItem().stream().forEach( grocery -> {
			 assertNotEquals(grocery.getId(),id);
		});
	}

}
