package com.hanye.info;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.javafaker.Faker;
import com.hanye.info.model.mongo.GroceryItem;
import org.junit.runners.MethodSorters;

@SpringBootTest
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
		var groceryItem = groceryRepository.save(new GroceryItem(id,faker.name().fullName(),faker.code().asin()));
		assertEquals(groceryItem.getId(),id);
	}
	
	@Test
	public void test2QueryGrocery() {
		var groceryItem = groceryRepository.findById(id).get();
		assertEquals(groceryItem.getId(),id);
	}
	
	@Test
	public void test3UpdateGrocery() {
		var groceryItem = groceryRepository.save(new GroceryItem(id,faker.name().fullName(),faker.code().asin()));
		assertEquals(groceryItem.getId(),id);
	}
	
	@Test
	public void test4DeleteGrocery() {
		groceryRepository.deleteById(id);
	}

}
