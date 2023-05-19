package dao;

import java.util.List;

import model.Loan;

public interface IUserDAO {
	
	public List<Loan> getLoansFromId(Integer id);

}
