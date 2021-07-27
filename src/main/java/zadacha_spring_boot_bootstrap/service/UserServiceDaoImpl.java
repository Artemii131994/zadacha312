package zadacha_spring_boot_bootstrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zadacha_spring_boot_bootstrap.dao.RoleDAO;
import zadacha_spring_boot_bootstrap.dao.UserDAO;
import zadacha_spring_boot_bootstrap.model.Role;
import zadacha_spring_boot_bootstrap.model.User;


import java.util.List;
import java.util.Set;

@Service
public class UserServiceDaoImpl implements UserServiceDao {


    private UserDAO userDAO;
    private RoleDAO roleDAO;


    @Autowired
    public UserServiceDaoImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }


    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public Role getByName(String name) {
        return roleDAO.getByName(name);
    }

    @Override
    @Transactional
    public Set<Role> byRole(User user, String[] role) {
        return roleDAO.byRole(user, role);
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }
}
