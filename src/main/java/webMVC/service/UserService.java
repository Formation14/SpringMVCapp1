package webMVC.service;

import webMVC.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(int id);

    void updateUserById(int id,User user);

    void deleteUserById(int id);
}
