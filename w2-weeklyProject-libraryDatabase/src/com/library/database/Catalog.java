package com.library.database;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Catalog {
	
	private List<Deployable> items;
	
	private static String path = "data/catalog.txt";
	private static File file = new File(path);
	
	public Catalog() {
		items = new ArrayList<>();
	}
	
	public void addElement(Deployable item) {
        items.add(item);
    }
	
	public void removeElement(String isbn) {
        items.removeIf(item -> item.getIsbn().equals(isbn));
    }

	public Optional<Deployable> searchISBN(String isbn) {
	    return items.stream()
	        .filter(item -> item.getIsbn().equals(isbn))
	        .findAny();
	}
	
	public List<Deployable> searchYear(int year) {
	    return items.stream()
	        .filter(item -> item.getReleaseYear() == year)
	        .collect(Collectors.toList());
	}
	
	public List<Book> searchAuthor(String author) {
		return items.stream()
				.filter(item -> item instanceof Book && ((Book) item).getAuthor().equals(author))
				.map(item -> (Book) item)
				.collect(Collectors.toList());
	}
	
	public void writeToDisk() throws IOException {
		String data = items.stream()
				.map(item -> item.toString())
				.collect(Collectors.joining("\n"));
		
		try {
			FileUtils.writeStringToFile(file, data, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadFromDisk(String filename) throws IOException {
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		
		for (String line : lines) {
			String[] parts = line.split(",");
			Deployable item = null;
			
			if (parts.length > 0) {
				 String type = parts[0];
		         String[] itemParts = Arrays.copyOfRange(parts, 1, parts.length);
		           
				switch (type) {
				case "Book" :
					item = Book.fromString(String.join(",", itemParts));
					break;
				case "Magazine" :
					item = Magazine.fromString(String.join(",", itemParts));
					break;
				}
			}
			
			if (item != null) {
				items.add(item);
			}
		}
	}
}
