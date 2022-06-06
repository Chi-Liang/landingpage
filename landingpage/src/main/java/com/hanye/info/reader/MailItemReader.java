package com.hanye.info.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class MailItemReader implements ItemReader<String> {
	
	List<String> list = Arrays.asList("reader1","reader2","reader3","reader4","reader5","reader6","reader7","reader8");
	int i = 0;
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Inside Item Reader");
		String item;
		if(i < list.size()) {
			item = list.get(i);
			i++;
			return item;
		}
		i = 0;
		return null;
	}

}
