package zadacha_spring_boot_bootstrap.dao;


import zadacha_spring_boot_bootstrap.model.User;

import java.util.List;


public interface UserDAO {
    public List<User> getAllUser();

    public User getUser(Long id);

    public void update(User user);

    public void deleteUser(Long id);

    public User ByUserName(String s);

    public void add(User user);

}
