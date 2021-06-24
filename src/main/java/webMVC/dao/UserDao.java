package webMVC.dao;

import webMVC.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUser(int id);
    void addUser(User user);
    void deleteUser(User user);
    void update(User user);
}
