package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.domain.User;
import server.domain.UserRepository;

@Controller
public class NavigationController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String loginApi(@ModelAttribute User user, Model model) {
        boolean foundUser = userRepository.containsUser(user);
        if (foundUser) {
            return "redirect:tasks";
        } else {
            model.addAttribute("logged", false);
            return "index";
        }
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
