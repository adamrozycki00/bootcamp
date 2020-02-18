package pl.sda.Bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.model.User;

import java.util.LinkedList;
import java.util.List;

@Controller
//@RequestMapping(value = "/rejestracja", method = RequestMethod.GET) // dlaczego tu jest GET, niżej jest POST i wszystko OK?
public class RegisterController {

    @GetMapping("/rejestracja")
    public String register(Model model) {

        List<Course> courseList = new LinkedList<>();
        courseList.add(new Course("Java", "weekendowy"));
        courseList.add(new Course("Frontend", "wieczorowy"));
        courseList.add(new Course("Python", "wieczorowy"));

        model.addAttribute("courseList", courseList);
        model.addAttribute("user", new User());

        return "/register";
    }

    @PostMapping("/rejestracja/podsumowanie")
    public String summaryRegister(@ModelAttribute User user,
                                  Model model) {
        model.addAttribute("user", user);
        return "/summary";
    }

}
