package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean delete(Long userId) {
        User userToDelete = entityManager.find(User.class, userId);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }
}
