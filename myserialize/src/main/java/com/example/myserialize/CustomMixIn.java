package com.example.myserialize;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface CustomMixIn {
	
	@JsonIgnore
	String getName();
	
}
