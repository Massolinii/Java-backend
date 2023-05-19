package dao;

import javax.persistence.EntityManager;

import model.Loan;
import utils.JpaUtil;

public class LoanDAO implements ILoanDAO {
	
	@Override
	public void save(Loan ln) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	    	em.getTransaction().begin();
	        em.persist(ln);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error saving the loan: " + e);
	    } finally {
	        em.close();
	    }
	}
	
	@Override
	public void update(Loan ln) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
		    em.getTransaction().begin();
	        em.merge(ln);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error updating the loan: " + e);
	    } finally {
	        em.close();
	    }
	}
	
	@Override
	public void delete(Loan ln) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
		    em.getTransaction().begin();
	        em.remove(ln);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error deleting the loan: " + e);
	    } finally {
	        em.close();
	    }
	}
	
	@Override
	public Loan getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    Loan loan = null;
	    try {
	        loan = em.find(Loan.class, id);
	    } catch (Exception e) {
	        System.out.println("Error getting the loan by id: " + e);
	    } finally {
	        em.close();
	    }
	    return loan;
	}
}
