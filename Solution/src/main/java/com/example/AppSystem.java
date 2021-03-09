package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AppSystem extends TheSystem {
	AppSystem() {

	}

	@Override
	public void display() {
		// formatting and print out the system collection
		System.out.println("AppSystem Inventory:");
		System.out.printf("%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");
		for(String output : this.getItemCollection().keySet()) {
			Item out = this.getItemCollection().get(output);
			System.out.printf("%-20s %-20s %-10.2f %-10d%n", out.getItemName(), out.getItemDesc(), out.getItemPrice(), out.getAvailableQuantity());
		}

	}

	@Override // this overwrites the parents class add method
	public Boolean add(Item item) {
		if (item == null) {
			return false;
		} else if (itemCollection.get(item.getItemName()) != null) {
			System.out.printf("%s is alread in the App System", itemCollection.get(item.getItemName()));
			return false;
		} else if (itemCollection.get(item.getItemName()) == null) {
			itemCollection.put(item.getItemName(), item);
			return true;
		} else {
			return false;
		}

	}

	public Item reduceAvailableQuantity(String itemName) {
		// Reduce the available quantity if it has some
		Item reduce = super.itemCollection.get(itemName);
		if (reduce == null) {
			return null;
		}else if(reduce.getAvailableQuantity() - 1 ==0) {
			// if there will be 0 left, remove it altogether.
			this.remove(itemName);
			return reduce;
		}

		else {
			//System.out.println("Before decrement" + reduce.getAvailableQuantity());
			reduce.setAvailableQuantity(reduce.getAvailableQuantity() - 1);
			//System.out.println("After decrement" + reduce.getAvailableQuantity());
			return reduce;
		}
	}
}
