package com.epicode.workSpaceReservationApplication.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.workSpaceReservationApplication.model.User;
import com.epicode.workSpaceReservationApplication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;

    @Autowired
    @Qualifier("UserAdminBean")
    ObjectProvider<User> userAdminProvider;

    @Autowired
    @Qualifier("UserNoParamsBean")
    ObjectProvider<User> userNoParamsProvider;

    @Autowired
    @Qualifier("UserWithParamsBean")
    ObjectProvider<User> userWithParamsProvider;

    @Autowired
    @Qualifier("UserFakeBean")
    ObjectProvider<User> userFakeProvider;

    public User createAdminUser() {
        return userAdminProvider.getObject();
    }

    public User createUserNoParamsBean() {
        return userNoParamsProvider.getObject();
    }

    public User createUserWithParamsBean(
            String username, String fullname, String email, String password) {
        return userWithParamsProvider.getObject();
    }

    public User createUserFake() {
        return userFakeProvider.getObject();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
    
    public List<User> getAllWithNoRes() {
        return userRepository.findAllWithNoRes();
    }

    public User getById(long id) {
        return userRepository.findById(id).get();
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public boolean existsAdminUser() {
        return userRepository.selectAdminUsers();
    }

}
