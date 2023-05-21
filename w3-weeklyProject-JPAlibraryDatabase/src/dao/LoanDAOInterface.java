package dao;

import java.util.List;

import model.Loan;

public interface LoanDAOInterface {
	
	public void save(Loan loan);
	public void update(Loan loan);
	public void delete(Loan loan);
	public Loan getLoanFromLoanId(Integer id);
	public List<Loan> getLoansFromUserId(Integer id);
	List<Loan> getExpiredLoans();
}
