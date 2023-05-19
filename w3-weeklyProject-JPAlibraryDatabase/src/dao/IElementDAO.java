package dao;

import java.util.List;

import model.Book;
import model.Element;

public interface IElementDAO {
	
	public void save(Element e);
	public Element getByISBN(int isbn);
	public List<Element> getByYear(String year);
	public List<Book> getByAuthor(String author);
	public List<Element> getByTitle(String title);
	public void delete(Element e);
	public void update(Element e);

}
