package com.example.myserialize;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		Item myItem = new Item(1, "theItem", new User(2, "theUser"));

//		generalSerialization(myItem);
//		itemSerialization(myItem);

//		customSerialization(myItem);

//		customSerializationUsingMixin(myItem);
		
		customDeSerializationUsingMixin("{\"id\":1,\"itemName\":\"theItem\",\"owner\":{\"id\":2,\"name\":\"theUser\"}}");

	}

	public static String generalSerialization(Item myItem) throws Exception {
		System.out.println("generalSerialization start");
		String serialized = new ObjectMapper().writeValueAsString(myItem);

		System.out.println("serialized using generalSerialization = " + serialized);
		System.out.println("generalSerialization end");
		return serialized;
	}

	public static String itemSerialization(Item myItem) throws Exception {
		System.out.println("itemSerialization start");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		SimpleModule module = new SimpleModule();
		module.addSerializer(Item.class, new ItemSerializer());
		mapper.registerModule(module);

		String serialized = mapper.writeValueAsString(myItem);

		System.out.println("serialized using itemSerialization = " + serialized);

		System.out.println("itemSerialization end");
		return serialized;
	}

	public static String customSerialization(Item myItem) throws Exception {
		System.out.println("customSerialization start");
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		ObjectWriter writer = mapper.writer().withoutAttribute("id");
		
		String serialized = writer.writeValueAsString(myItem);

//		String serialized = mapper.writeValueAsString(myItem);

		System.out.println("serialized using customSerialization = \n" + serialized);

		System.out.println("customSerialization end");
		return serialized;
	}
	
	public static String customSerializationUsingMixin(Item myItem) throws Exception {
//		System.out.println("customSerializationUsingMixin start");
		ObjectMapper mapper = new ObjectMapper();
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		mapper.addMixIn(User.class, CustomMixIn.class);

		String serialized = mapper.writeValueAsString(myItem);

		System.out.println("serialized using customSerializationUsingMixin = \n" + serialized);

//		System.out.println("customSerializationUsingMixin end");
		return serialized;
	}
	
	
	public static Item customDeSerializationUsingMixin(String myItemJson) throws Exception {
//		System.out.println("customDeSerializationUsingMixin start");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		Item serializedItem = (Item) mapper.readValue(myItemJson ,  Item.class);

		System.out.println("de-serialized using customDeSerializationUsingMixin = \n" + serializedItem.toString());
		
		customSerializationUsingMixin(serializedItem);
		
		System.out.println("Again After Serialization Done = \n" + serializedItem.toString());
		
//		System.out.println("customDeSerializationUsingMixin end");
		return serializedItem;
	}
}
