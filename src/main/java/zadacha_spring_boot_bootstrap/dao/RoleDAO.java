package zadacha_spring_boot_bootstrap.dao;


import zadacha_spring_boot_bootstrap.model.Role;
import zadacha_spring_boot_bootstrap.model.User;

import java.util.Set;

public interface RoleDAO {

    public Role getByName(String name);

    public Set<Role> byRole(User user, String[] role);
}

