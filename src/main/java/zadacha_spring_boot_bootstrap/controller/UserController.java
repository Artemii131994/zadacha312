package zadacha_spring_boot_bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zadacha_spring_boot_bootstrap.model.User;
import zadacha_spring_boot_bootstrap.service.UserDetailsImpl;
import zadacha_spring_boot_bootstrap.service.UserServiceDao;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserDetailsImpl userDetailsImpl;

    private UserServiceDao userServiceDao;

    @Autowired
    public UserController(UserServiceDao userServiceDao) {
        this.userServiceDao = userServiceDao;
    }

    @GetMapping("/user")
    public String showAllUser(Model model, Principal userUSS) {
        model.addAttribute("user_user", userServiceDao.ByUserName(userUSS.getName()));
        return "user";
    }
}
