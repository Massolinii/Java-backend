package dao;

import model.Loan;

public interface ILoanDAO {
	
	public void save(Loan loan);
	
	public void update(Loan loan);
	
	public void delete(Loan loan);
	
	public Loan getById(Integer id);
}
