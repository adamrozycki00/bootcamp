package pl.sda.Bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.model.User;
import pl.sda.Bootcamp.service.UserService;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/rejestracja")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String register(Model model) {

        List<Course> courseList = new LinkedList<>();
        courseList.add(new Course("Java", "dzienny"));
        courseList.add(new Course("Java", "weekendowy"));
        courseList.add(new Course("Frontend", "wieczorowy"));
        courseList.add(new Course("Frontend", "weekendowy"));
        courseList.add(new Course("Python", "dzienny"));
        courseList.add(new Course("Python", "weekendowy"));

        model.addAttribute("courseList", courseList);
        model.addAttribute("user", new User());

        return "/register";
    }

    @PostMapping("/podsumowanie")
    public String summaryRegister(@ModelAttribute User user,
                                  Model model) {
        model.addAttribute("user", user);
        userService.save(user);
        return "/summary";
    }

}
