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
	
	// Metodo per aggiungere un elemento al catalogo
	public boolean addElement(Deployable item) {		
		// Controlla se un elemento con lo stesso ISBN esiste già nel catalogo
		if (searchISBN(item.getIsbn()).isPresent()) {
			logger.error("Item with this ISBN already exists", item.getIsbn());
			return false;
		}
        items.add(item);
        System.out.println("Added item: " + item.getTitle()); // Stampa x debug
        System.out.println("");
        
		return true;
    }
	
	// Metodo per rimuovere un elemento dal catalogo
	public boolean removeElement(String isbn) {
		boolean removed = items.removeIf(item -> item.getIsbn().equals(isbn));
		if (!removed) {
			logger.error("No item found with ISBN {}", isbn);
	        System.out.println("");
		}
		return removed;
    }

	// Metodo per cercare un elemento nel catalogo tramite ISBN
	public Optional<Deployable> searchISBN(String isbn) {
		System.out.println("Searching for item: " + isbn); // Stampa x debug
	    return items.stream()
	        .filter(item -> item.getIsbn().equals(isbn))
	        .findAny();
	    
	}
	
	// Metodo per cercare elementi nel catalogo per anno di pubblicazione
	public List<Deployable> searchYear(int year) {
	    return items.stream()
	        .filter(item -> item.getReleaseYear() == year)
	        .collect(Collectors.toList());
	}
	
	// Metodo per cercare libri nel catalogo per autore
	public List<Book> searchAuthor(String author) {
		return items.stream()
				.filter(item -> item instanceof Book && ((Book) item).getAuthor().equals(author))
				.map(item -> (Book) item)
				.collect(Collectors.toList());
	}
	
	// Metodo per salvare il catalogo su disco
	public void writeToDisk() throws IOException {
	    try {
	        String existingData = FileUtils.readFileToString(file, "UTF-8");

	        
	        for (Deployable item : items) {
	            String itemData = item.toString();
		        // Per ogni elemento nel catalogo, se non è già presente nel file, lo aggiunge
	            if (!existingData.contains(itemData)) {
	                FileUtils.writeStringToFile(file, "\n" + itemData, "UTF-8", true); // true per abilitare l'append
	            }
	        }
	    } catch (IOException e) {
	        logger.error("Error writing to disk", e);
	        throw e;
	    }
	}
	
	// Metodo per caricare il catalogo dal disco
	public void loadFromDisk() throws IOException {
	    try {
	        List<String> lines = FileUtils.readLines(file, "UTF-8");

	        items.clear();

	        for(String line : lines) {
	            String[] parts = line.split(", ");
	            if (parts.length > 0) {
	                String type = parts[0];
	                String[] itemParts = Arrays.copyOfRange(parts, 1, parts.length);
	                
	                try {
	                    switch (type) {
	                    case "Book":
	                        items.add(Book.fromString(String.join(", ", itemParts)));
	                        break;
	                    case "Magazine":
	                        items.add(Magazine.fromString(String.join(", ", itemParts)));
	                        break;
	                    }
	                } catch (NumberFormatException e) {
	                    logger.error("Error parsing number in line: " + line, e);
	                } catch (IllegalArgumentException e) {
	                    logger.error("Invalid data in line: " + line, e);
	                }
	            }
	        } 
	    } catch (IOException e) {
	        logger.error("Error loading from disk", e);
	        System.out.println("");
	        throw e;
	        
	    }
	}
	
	// Metodo per stampare in console il catalogo
	public void printCatalog() {
	    if (items.isEmpty()) {
	        System.out.println("The catalog is currently empty.");
	        System.out.println("");
	    } else {
	        System.out.println("Catalog:");
	        int count = 1;
	        for (Deployable item : items) {	
	            System.out.println(count + ". " +item);
	            count++;
	        }
	        System.out.println("");
	    }
	}
}