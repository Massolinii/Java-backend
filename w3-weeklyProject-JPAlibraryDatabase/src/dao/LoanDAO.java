package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Loan;
import model.User;
import utils.JpaUtil;

public class LoanDAO implements LoanDAOInterface {
	
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
	public Loan getLoanFromLoanId(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    System.out.println("Searching LOANS from LOAN ID -> " + id);
	    Loan loan = null;
	    try {
	        loan = em.find(Loan.class, id);
	        if (loan != null) {
	        	System.out.println(loan.toString());
	        } else {
	        	System.out.println("Nothing found for this Loan ID.");
	        }
	    } catch (Exception e) {
	        System.out.println("Error getting the loan by id: " + e);
	    } finally {
	        em.close();
	    }
	    return loan;
	}
	
	public List<Loan> getLoansFromUserId(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("Searching LOANS from USER ID -> " + id);
		List<Loan> loans = null;
	    try {
	        User user = em.find(User.class, id);
	        if (user != null) {
	            loans = user.getLoans();
	            System.out.println(loans.toString());
	        } else {
	        	System.out.println("No Loans found for this ID");
	        }
	    } catch (Exception e) {
	        System.out.println("There was an error getting loans from this USER ID: " + e);
	    } finally {
	        em.close();
	    }
	    return loans;
	}
	
	 public List<Loan> getExpiredLoans() {
	        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        System.out.println("Searching for EXPIRED LOANS : ");
	        List<Loan> loans = null;
	        try {
	            LocalDate today = LocalDate.now();
	            String queryStr = "SELECT l FROM Loan l WHERE l.loanReturn IS NULL AND l.loanEnd < :today";
	            TypedQuery<Loan> query = em.createQuery(queryStr, Loan.class);
	            query.setParameter("today", today);
	            loans = query.getResultList();
	            if (loans != null) {
	            	System.out.println("Expired Loans : " + loans);
	            } else {
	            	System.out.println("No expired Loans found. Good Job Book Keeper!");
	            }
	        } catch (Exception e) {
	            System.out.println("There was an error getting expired loans: " + e);
	        } finally {
	            em.close();
	        }
	        return loans;
	    }
}
