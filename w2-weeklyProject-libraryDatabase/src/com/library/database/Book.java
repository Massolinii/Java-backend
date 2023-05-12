package com.library.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book extends Deployable {
	
	private static final Logger log = LoggerFactory.getLogger(Book.class);
	
	private String author;
	private String genre;

	public Book(String isbn, String title, int releaseYear, int pageNum, String author, String genre) {
		super(isbn, title, releaseYear, pageNum);
		this.author = author;
		this.genre = genre;
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book," + getIsbn() + "," + getTitle() + "," + getReleaseYear() + "," + getPageNum() + "," + author + "," + genre;
	}

	public static Book fromString(String str) {
	    String[] parts = str.split(",");
	    if (parts.length != 7) {
	        return null;
	    }
	    
	    try {
	    	String isbn = parts[1];
		    String title = parts[2];
		    int releaseYear = Integer.parseInt(parts[3]);
		    int pageNum = Integer.parseInt(parts[4]);
		    String author = parts[5];
		    String genre = parts[6];
		    
		    return new Book(isbn, title, releaseYear, pageNum, author, genre);
	    } catch (NumberFormatException e) {
	    	// metterò log di errore qui
	    	return null;
	    }
	    
	}
	
}
