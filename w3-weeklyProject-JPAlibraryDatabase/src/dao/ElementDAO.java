package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Book;
import model.Element;
import utils.JpaUtil;

public class ElementDAO implements IElementDAO {

	public void save(Element el) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(el);
			em.getTransaction().commit();
			System.out.println("Successfully added into the DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("There was an error saving this Element" + e);
		} finally {
			em.close();
		}
	}

	@Override
	public Element getByISBN(int isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Element el =  em.find(Element.class, isbn);
			em.getTransaction().commit();
			return el;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("There was an error getting this ISBN");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<Element> getByYear(String year) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Element> elements = null;
		try {
		        TypedQuery<Element> query = em.createQuery("SELECT el FROM Element el WHERE el.publicationYear = :year", Element.class);
		        query.setParameter("year", year);
		        elements = query.getResultList();
		    } catch (Exception e) {
		        System.out.println("There was an error getting this Year: " + e);
		    } finally {
		        em.close();
		    }
		 return elements;
	}

	@Override
	public List<Book> getByAuthor(String author) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    List<Book> books = null;
	    try {
	        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class);
	        query.setParameter("author", author);
	        books = query.getResultList();
	    } catch (Exception e) {
	        System.out.println("There was an error getting by this Author: " + e);
	    } finally {
	        em.close();
	    }
	    return books;
	}

	@Override
	public List<Element> getByTitle(String title) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    List<Element> elements = null;
	    try {
	        TypedQuery<Element> query = em.createQuery("SELECT el FROM Element el WHERE el.Title LIKE :title", Element.class);
	        query.setParameter("title", "%" + title + "%");
	        elements = query.getResultList();
	    } catch (Exception e) {
	        System.out.println("There was an error getting by this Title: " + e);
	    } finally {
	        em.close();
	    }
	    return elements;
	}

	@Override
	public void delete(Element el) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	        em.getTransaction().begin();
	        em.remove(el);
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

}
