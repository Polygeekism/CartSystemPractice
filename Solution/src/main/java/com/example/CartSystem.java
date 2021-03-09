package com.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartSystem extends TheSystem {
	CartSystem() {
	}

	@Override
	public void display() {
		//local variables
		double subTotal = 0;
		final double taxrate = 0.05;
		double tax = 0;
		//start printingn
		System.out.println("Cart:");
		Iterator pntColl = this.getItemCollection().entrySet().iterator();
		System.out.printf("%-20s %-20s %-10s %-10s %-10s\n", "Name", "Description", "Price", "Quantity", "Sub Total");
		//move through the collection and print out the values
		while (pntColl.hasNext()) {
			
			Map.Entry elem = (Map.Entry) pntColl.next();
			Item displayItem = this.getItemCollection().get(elem.getKey());
			System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f\n", displayItem.getItemName(),
					displayItem.getItemDesc(), displayItem.getItemPrice(), displayItem.getQuantity(),
					displayItem.getQuantity() * displayItem.getItemPrice());
			subTotal += displayItem.getItemPrice() * displayItem.getQuantity();
		}
		tax = subTotal * taxrate;
		//print out sub totals and total
		System.out.printf("%-20s %-20.2f\n", "Pre-tax Total ", subTotal);
		System.out.printf("%-20s %-20.2f\n", "Tax ", tax);
		System.out.printf("%-20s %-20.2f\n", "Total ", subTotal + tax);
	}
}
