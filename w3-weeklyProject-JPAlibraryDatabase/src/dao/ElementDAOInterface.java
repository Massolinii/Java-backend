package dao;

import java.util.List;

import model.Book;
import model.Element;

public interface ElementDAOInterface {
	
	public void save(Element e);
	public Element getElByISBN(int isbn);
	public List<Element> getElsByYear(int year);
	public List<Book> getElsByAuthor(String author);
	public List<Element> getElsByTitle(String title);
	public void delete(Element e);
	public void update(Element e);

}
