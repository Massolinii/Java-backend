package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Enums.BookGenre;

@Entity
public class Book extends Element{
	
	private String author;
	
	@Enumerated(EnumType.STRING)
	private BookGenre genre;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}
	
	public Book() {
		super();
	}

	public Book(String title, Integer publicationYear, Integer pageNumber, String author, BookGenre genre) {
        super(title, publicationYear, pageNumber);
        this.author = author;
        this.genre = genre;
    }

	@Override
	public String toString() {
		return "Book [author=" + author + ", genre=" + genre + "]";
	}
	
}
