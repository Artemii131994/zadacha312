package zadacha_spring_boot_bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zadacha_spring_boot_bootstrap.service.UserServiceDao;


import java.security.Principal;

@Controller
@RequestMapping("")
public class UserController {

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
