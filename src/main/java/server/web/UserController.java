package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import server.domain.entity.User;
import server.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @ModelAttribute("allUsers")
    public List<User> populateUsers() {
        return service.getAllUsers();
    }
}
