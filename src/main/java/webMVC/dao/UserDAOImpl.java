package webMVC.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webMVC.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void updateUserById(int id, User user) {
        User forUpdate = getUserById(id);
        forUpdate.setFirstName(user.getFirstName());
        forUpdate.setLastName(user.getLastName());
        forUpdate.setEmail(user.getEmail());
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        entityManager.remove(getUserById(id));
    }
}
