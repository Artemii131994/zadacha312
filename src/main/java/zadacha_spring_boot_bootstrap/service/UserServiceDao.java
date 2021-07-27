package zadacha_spring_boot_bootstrap.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import zadacha_spring_boot_bootstrap.model.Role;
import zadacha_spring_boot_bootstrap.model.User;


import java.util.List;
import java.util.Set;


public interface UserServiceDao {

    public List<User> getAllUser();

    public User getUser(Long id);

    public void update(User user);

    public void deleteUser(Long id);

    public Role getByName(String name);

    public Set<Role> byRole(User user, String[] role);

    public void add(User user);
}
