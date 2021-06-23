package webMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webMVC.dao.UserDAO;
import webMVC.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }


    @Override
    @Transactional()
    public void updateUserById(int id, User user) {
        userDAO.updateUserById(id,user);
    }

    @Override
    @Transactional()
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }
}
