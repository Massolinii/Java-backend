package dao;

import javax.persistence.EntityManager;

import model.User;
import utils.JpaUtil;

public class UserDAO implements UserDAOInteface{

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
	public User getUserById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("Searching for USER ID -> " + id);
	    User user = null;
	    try {
	        user = em.find(User.class, id);
	        if (user != null) {
	        	System.out.println(user);
	        } else {
	        	System.out.println("No USER was found for this ID.");
	        }
	    } catch (Exception e) {
	        System.out.println("Error getting the user by id: " + e);
	    } finally {
	        em.close();
	    }
	    return user;
	}
	
}
