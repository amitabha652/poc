package com.example.myserialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ItemSerializer extends StdSerializer<Item> {

	public ItemSerializer() {
		this(null);
	}

	public ItemSerializer(Class<Item> t) {
		super(t);
	}

	@Override
	public void serialize(Item value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

//		if (value.owner.id == 2) {
//			jgen.writeNumberField("owner", value.owner.id++);
//		}

       jgen.writeStartObject();
       jgen.writeNumberField("id", value.id);
       jgen.writeStringField("itemName", value.itemName);
       jgen.writeNumberField("owner", value.owner.id);
       jgen.writeEndObject();
	}
}
