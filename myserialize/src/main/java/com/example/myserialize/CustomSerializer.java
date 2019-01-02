package com.example.myserialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomSerializer extends JsonSerializer<Item> {

	@Override
	public void serialize(Item value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		if (value.owner.id==3) {
			value.owner.id++;
		}
		serialize(value , gen , serializers );
	}
	
}
