package zadacha_spring_boot_bootstrap.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zadacha_spring_boot_bootstrap.model.Role;
import zadacha_spring_boot_bootstrap.model.User;
import zadacha_spring_boot_bootstrap.service.UserServiceDao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class AdminController {

    private UserServiceDao userServiceDao;

    @Autowired
    public AdminController(UserServiceDao userServiceDao) {
        this.userServiceDao = userServiceDao;

    }

    @GetMapping("/admin")
    public String showAllUser(Model model, @AuthenticationPrincipal User thisUser) {
        model.addAttribute("thisUser", thisUser);
        List<User> allUser = userServiceDao.getAllUser();
        model.addAttribute("allUser", allUser);
        return "index";
    }

    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam("role") String[] role) {
        userServiceDao.byRole(user, role);
        userServiceDao.add(user);

        return "redirect:/admin";
    }


    @PostMapping("/updateSave/{id}")
    public String edit(@ModelAttribute("user") User user,
                       @RequestParam("role") String[] role) {
        userServiceDao.byRole(user, role);
        userServiceDao.update(user);
        return "redirect:/admin";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userServiceDao.deleteUser(id);
        return "redirect:/admin";
    }

}
