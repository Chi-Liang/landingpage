package com.hanye.info.batch.writer;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class MailItemWriter implements ItemWriter<String> {

	public void write(List<? extends String> items) throws Exception {
		
		items.stream().forEach(System.out::println);
		
	}

}
