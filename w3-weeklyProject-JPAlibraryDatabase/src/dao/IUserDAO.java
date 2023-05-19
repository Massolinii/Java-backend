package dao;

import java.util.List;

import model.Loan;
import model.User;

public interface IUserDAO {
	
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User getById(Integer id);
	public List<Loan> getLoansFromId(Integer id);

}
