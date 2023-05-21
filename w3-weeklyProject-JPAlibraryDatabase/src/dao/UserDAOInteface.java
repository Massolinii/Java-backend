package dao;

import model.User;

public interface UserDAOInteface {
	
	public void save(User user);
	public void update(User user);
	public void delete(User user);;
	User getUserById(Integer id);

}
