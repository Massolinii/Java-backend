package com.library.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book extends Deployable {
	
	private static final Logger log = LoggerFactory.getLogger(Book.class);
	
	private String author;
	private String genre;

	// Costruttore della classe Book
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
		return "Book, " + getIsbn() + ", " + getTitle() + ", " + getReleaseYear() + ", " + getPageNum() + ", " + author + ", " + genre;
	}

	// Metodo statico per creare un oggetto Book da una stringa
	public static Book fromString(String str) throws NumberFormatException {
	    String[] parts = str.split(", ");
	 // Se la lunghezza dell'array non è la lunghezza attesa (6) lancia un'eccezione
	    if (parts.length != 6) {
	        throw new IllegalArgumentException("Invalid book data");
	    }

	    String isbn = parts[0];
	    String title = parts[1];
	    int releaseYear = Integer.parseInt(parts[2]);
	    int pageNum = Integer.parseInt(parts[3]);
	    String author = parts[4];
	    String genre = parts[5];

	    return new Book(isbn, title, releaseYear, pageNum, author, genre);
	}
	
}
