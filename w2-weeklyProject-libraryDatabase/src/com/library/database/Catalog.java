package com.library.database;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Catalog {
	
	private List<Deployable> items;
	
	private static final Logger logger = LoggerFactory.getLogger(Catalog.class);
	
	private static String path = "data/catalog.txt";
	private static File file = new File(path);
	
	public Catalog() {
		items = Collections.synchronizedList(new ArrayList<>());
	}
	
	public boolean addElement(Deployable item) {
		
		if (searchISBN(item.getIsbn()).isPresent()) {
			logger.error("Item with this ISBN already exists", item.getIsbn());
			return false;
		}
        items.add(item);
        System.out.println("Added item: " + item.getIsbn()); // Stampa x debug
		return true;
    }
	
	public boolean removeElement(String isbn) {
		boolean removed = items.removeIf(item -> item.getIsbn().equals(isbn));
		if (!removed) {
			logger.error("No item found with ISBN {}", isbn);
		}
		return removed;
    }

	public Optional<Deployable> searchISBN(String isbn) {
		System.out.println("Searching for item: " + isbn); // Stampa x debug
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
				.map(Deployable::toString)
				.collect(Collectors.joining("\n"));
		
		try {
			FileUtils.writeStringToFile(file, data, "UTF-8");
		} catch (IOException e) {
			logger.error("Error writing to disk", e);
			throw e;
		}
	}
	
	public void loadFromDisk() throws IOException {
		try {
			List<String> lines = FileUtils.readLines(file, "UTF-8");
			
			items = lines.stream().map(line -> {
				String[] parts = line.split(",");
				Deployable item = null;
				if (parts.length > 0) {
					String type = parts[0];
					String[] itemParts = Arrays.copyOfRange(parts, 1, parts.length);
					
					switch (type) {
					case "Book":
						item = Book.fromString(String.join(",", itemParts));
						break;
					case "Magazine":
						item = Magazine.fromString(String.join(",", itemParts));
						break;
					}
				}
				return item;
			}).filter(item -> item != null).collect(Collectors.toList());
			
		} catch (IOException e) {
			logger.error("Error loading from disk", e);
			throw e;
		}
	}
}