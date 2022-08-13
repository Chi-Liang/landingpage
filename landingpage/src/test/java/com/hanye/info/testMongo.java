package com.hanye.info;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import com.github.javafaker.Faker;
import com.hanye.info.vo.GroceryItemVo;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testMongo extends AbstractTest {
	
	private static String id;
	
	private static final Faker faker = Faker.instance();
	
	@BeforeClass
	public static void InitId(){
		id = faker.idNumber().invalid();
	}
	
	@Test
	public void test1CreateGrocery() {
		groceryService.saveGroceryItem(new GroceryItemVo(id,faker.name().fullName(),faker.code().asin()));
	}
	
	@Test
	public void test2QueryById() {
		var groceryItem = groceryService.findGroceryItem(id);
		assertEquals(groceryItem.getId(),id);
	}
	
	@Test
	public void test3UpdateById() {
		groceryService.editGroceryItem(new GroceryItemVo(id,faker.name().fullName(),faker.code().asin()));
	}
	
	@Test
	public void test4DeleteById() {
		groceryService.deleteGroceryItem(id);
	}
	
	@Test
	public void test5QueryAll() {
		groceryService.findAllGroceryItem().stream().forEach( grocery -> {
			 assertNotEquals(grocery.getId(),id);
		});
	}

}
