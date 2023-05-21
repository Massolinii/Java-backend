package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Book;
import model.Element;
import utils.JpaUtil;

public class ElementDAO implements ElementDAOInterface {

	public void save(Element el) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(el);
			em.getTransaction().commit();
			System.out.println("Successfully added into the DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("There was an error saving this Element." + e);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Element el) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(el);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("There was an error updating!!");
		} finally {
			em.close();
		}
		
	}
	
	@Override
	public void delete(Element el) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	        em.getTransaction().begin();
	        Element merged = em.merge(el); // Merge first the entity to delete, to prevent different EntityManager error
	        em.remove(merged);
	        em.getTransaction().commit();
	        System.out.println("Element successfully deleted.");
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("There was an error deleting the Element: " + e);
	    } finally {
	        em.close();
	    }
	}
	
	@Override
	public Element getElByISBN(int isbn) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    System.out.println("Searching for ISBN -> " + isbn);
	    Element el = null;
	    try {
	        el = em.find(Element.class, isbn);
	        if (el != null) {
	        	System.out.println(el.toString());
	        } else {
	        	System.out.println("Nothing found for this ISBN.");
	        }
	        
	    } catch (Exception e) {
	        System.out.println("There was an error getting this ISBN: " + e);
	    } finally {
	        em.close();
	    }
	    return el;
	}

	@Override
	public List<Element> getElsByYear(int year) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("Searching for Year -> " + year);
		List<Element> elements = null;
		try {
		        TypedQuery<Element> query = em.createQuery("SELECT el FROM Element el WHERE el.publicationYear = :year", Element.class);
		        query.setParameter("year", year);
		        elements = query.getResultList();
		        if (elements != null) {
		        	System.out.println(elements);
		        } else {
		        	System.out.println("Nothing was found for this Year.");
		        }
		        
		    } catch (Exception e) {
		        System.out.println("There was an error getting this Year: " + e);
		    } finally {
		        em.close();
		    }
		 return elements;
	}

	@Override
	public List<Book> getElsByAuthor(String author) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    System.out.println("Searching for Author -> " + author);
	    List<Book> books = null;
	    try {
	        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class);
	        query.setParameter("author", author);
	        books = query.getResultList();
	        if (books != null) {
	        	System.out.println(books);
	        } else {
	        	System.out.println("Nothing was found for this Author.");
	        }
	    } catch (Exception e) {
	        System.out.println("There was an error getting by this Author: " + e);
	    } finally {
	        em.close();
	    }
	    return books;
	}

	@Override
	public List<Element> getElsByTitle(String title) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    System.out.println("Searching for Title -> " + title);
	    List<Element> elements = null;
	    try {
	        TypedQuery<Element> query = em.createQuery("SELECT el FROM Element el WHERE el.Title LIKE :title", Element.class);
        	query.setParameter("title", "%" + title + "%");
	        elements = query.getResultList();
	        if (title != null) {
		        System.out.println(elements);
	        } else {
		        System.out.println("Nothing was found for this Title: " + title);
	        }
	        
	    } catch (Exception e) {
	        System.out.println("There was an error getting by this Title: " + e);
	    } finally {
	        em.close();
	    }
	    return elements;
	}

}
