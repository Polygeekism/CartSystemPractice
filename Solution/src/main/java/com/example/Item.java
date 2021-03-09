package com.example;

public class Item {
	private String itemName;
	private String itemDesc;
	private Double itemPrice;
	private Integer quantity;
	private Integer availableQuantity;

	public Item() {
		quantity = 1;
	}

	public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
		// initialize all the variables with provided parameters
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.quantity = 1;
		this.availableQuantity = availableQuantity;
	}

	
	//setters
	public void setItemName(String pItemName) {
		this.itemName = pItemName;

	}

	public void setItemDesc(String pItemDesc) {
		this.itemDesc = pItemDesc;

	}

	public void setItemPrice(Double pItemPrice) {
		this.itemPrice = pItemPrice;

	}

	public void setAvailableQuantity(Integer pAvailQuan) {
		this.availableQuantity = pAvailQuan;

	}

	public void setQuantity(Integer newQuan) {
		this.quantity = newQuan;
	}

	//getters
	public String getItemName() {
		return this.itemName;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public Double getItemPrice() {
		return this.itemPrice;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public Integer getAvailableQuantity() {
		return this.availableQuantity;
	}

}
