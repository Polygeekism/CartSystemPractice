package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class TheSystem {

	HashMap<String, Item> itemCollection = new HashMap<String, Item>();

	TheSystem() {
		// Read in the text file and store in hashmap

		if (getClass().getSimpleName().equals("AppSystem")) {

			String location = "resources/sample.txt";

			try {

				// File instance
				File file = new File(location);

				// access/read/fetch data from the file
				Scanner scInputFile = new Scanner(file);
				String line;
				//line = scInputFile.nextLine();
				String[] fields;
				while (scInputFile.hasNextLine()) {
					line = scInputFile.nextLine();
					// System.out.println(line);
					fields = line.split("  ");
					// System.out.println("Fields array: " + Arrays.toString(fields));
					Item inputItem = new Item(fields[0], fields[1], Double.parseDouble(fields[2]),
							Integer.parseInt(fields[3]));
					itemCollection.put(fields[0], inputItem);
				}
			} catch (Exception e) {
				System.out.println("THIS IS AN ERROR MESSAGE");
				
			} 
		}
	}

	public HashMap<String, Item> getItemCollection() {
		// return itemcollection
		return itemCollection;
	}

	public Boolean checkAvailability(Item item) {
		// check if there is this item if there is check to see if it has more than 0
		
		if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.printf("System is unable to add %s to the cart. System only has %d %ss%n.",
                    item.getItemName(),
                    item.getAvailableQuantity(),
                    item.getItemName());
            return false;
        }else {
        	return true;
        }


	}

	public Boolean add(Item item) {		
		//add to either collection with this function.
		if (item == null) {
            return false;
        } else if (itemCollection.containsKey(item.getItemName())) {
            item.setQuantity(item.getQuantity() + 1);
            itemCollection.put(item.getItemName(), item);
            return true;
        } else {
            this.getItemCollection().put(item.getItemName(), item);
            return true;
        }	

	}

	public Item remove(String itemName) {
		// simply remove from the collection.
		Item removed = itemCollection.remove(itemName);
		return removed;
	}

	public abstract void display();
}
