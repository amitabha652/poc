package com.example.myserialize;

public class Item {
	
	public int id;
	public String itemName;
	public User owner;
	
	public Item() { }
	
	public Item(int id, String itemName, User owner) {
		this.id = id;
		this.itemName = itemName;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", itemName=" + itemName + ", owner=" + owner + "}";
	}
	
	
}
