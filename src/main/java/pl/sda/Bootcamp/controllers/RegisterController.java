package pl.sda.Bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.model.User;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
public class RegisterController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());

        List<Course> courseList = new LinkedList<>();

        courseList.add(new Course("Java", "weekendowy"));
        courseList.add(new Course("Frontend", "wieczorowy"));
        courseList.add(new Course("Python", "wieczorowy"));

        model.addAttribute("courseList", courseList);
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value = "/podsumowanie", method = RequestMethod.POST)
    public String summaryRegister(@ModelAttribute User user,
                                  Model model) {
        model.addAttribute("user", user);
        return "/summary";
    }

}
