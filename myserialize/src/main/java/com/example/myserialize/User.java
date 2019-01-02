package com.example.myserialize;

public class User {
	public int id;
    public String name;

    public User() { }
    
    public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return " {id=" + id + ", name=" + name + "}";
	}
    
    
}
