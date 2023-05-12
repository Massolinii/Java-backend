package com.library.database;

// Classe Astratta Deployable per creare Book e Magazine
public abstract class Deployable {
	
	private String isbn;
	private String title;
	private int releaseYear;
	private int pageNum;
	
	public Deployable(String isbn, String title, int releaseYear, int pageNum) {
		this.isbn = isbn;
		this.title = title;
		this.releaseYear = releaseYear;
		this.pageNum = pageNum;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		 return "Deployable," + isbn + "," + title + "," + releaseYear + "," + pageNum;
	}

}
