package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Loan;
import model.User;
import utils.JpaUtil;

public class UserDAO {
	
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
	
}
