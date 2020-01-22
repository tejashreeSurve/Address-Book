package com.bridgelabz.fellowshipprogram.oops.addressbook.repository;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonOperation {
ObjectMapper mapper= new ObjectMapper();

	public void toWriteIntoFile(String filepath, Object object) {
		try {
			mapper.writeValue(new File(filepath), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object toReadFromFile(String filepath, Object object)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(new File(filepath), object.getClass());

	}
}
