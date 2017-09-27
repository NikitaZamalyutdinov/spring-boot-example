package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.Data.User;
import server.Data.UserRepository;

@Controller
public class NavigationController {

    UserRepository userRepository = new UserRepository();

    @RequestMapping("/login")
    public String loginApi(@ModelAttribute User user, Model model) {
        boolean foundUser = userRepository.containsUser(user);
        model.addAttribute("logged", foundUser);
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
