package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Loan;
import model.User;
import utils.JpaUtil;

public class UserDAO implements IUserDAO{
	
	public List<Loan> getLoansFromId(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    List<Loan> loans = null;
	    try {
	        User user = em.find(User.class, id);
	        if (user != null) {
	            loans = user.getLoans();
	        }
	    } catch (Exception e) {
	        System.out.println("There was an error getting loans from this ID: " + e);
	    } finally {
	        em.close();
	    }
	    return loans;
	}

	@Override
	public void save(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	    	em.getTransaction().begin();
	        em.persist(user);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error saving the user: " + e);
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void update(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
		    em.getTransaction().begin();
	        em.merge(user);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error updating the user: " + e);
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void delete(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
		    em.getTransaction().begin();
	        em.remove(em.contains(user) ? user : em.merge(user));
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error deleting the user: " + e);
	    } finally {
	        em.close();
	    }
	}

	@Override
	public User getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    User user = null;
	    try {
	        user = em.find(User.class, id);
	    } catch (Exception e) {
	        System.out.println("Error getting the user by id: " + e);
	    } finally {
	        em.close();
	    }
	    return user;
	}
	
}
