package com.example.myserialize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonProgram {
	
	public static void main(String[] args) throws Exception {
		UserInformation userInformation = new UserInformation();
		userInformation.setField3("field3_Value");
		userInformation.setField4("field4_Value");
		userInformation.setField5("field5_Value");

		User user = new User();
		user.setField1(userInformation);
		user.setField2("field2_Value");

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.addMixInAnnotations(UserInformation.class, UserInformationMixIn.class);
		objectMapper.addMixInAnnotations(User.class, UserInformationMixIn.class);

		System.out.println("After Serialization: \n" + objectMapper.writeValueAsString(user));
	}
	
	public static class Someclass {
		String field5;

		public String getField5() {
			return field5;
		}

		public void setField5(String field5) {
			this.field5 = field5;
		}
	}

	public static class UserInformation extends Someclass {
		String field3;
		String field4;

		public String getField3() {
			return field3;
		}

		public void setField3(String field3) {
			this.field3 = field3;
		}

		public String getField4() {
			return field4;
		}

		public void setField4(String field4) {
			this.field4 = field4;
		}
	}

	public static class User {
		UserInformation field1;
		String field2;

		public UserInformation getField1() {
			return field1;
		}

		public void setField1(UserInformation field1) {
			this.field1 = field1;
		}

		public String getField2() {
			return field2;
		}

		public void setField2(String field2) {
			this.field2 = field2;
		}
	}

	public static interface UserInformationMixIn {
		@JsonIgnore
		String getField3();

		@JsonIgnore
		String getField2();

		@JsonIgnore
		String getField5();
	}

}

