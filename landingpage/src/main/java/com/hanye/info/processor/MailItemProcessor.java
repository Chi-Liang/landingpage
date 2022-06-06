package com.hanye.info.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MailItemProcessor implements ItemProcessor<String, String> {

	public String process(String item) throws Exception {
		
		return item + " process";
		
	}

}
