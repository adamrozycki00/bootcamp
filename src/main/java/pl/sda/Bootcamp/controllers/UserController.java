package pl.sda.Bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.Bootcamp.service.CourseService;
import pl.sda.Bootcamp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String dashboard() {
        return "/user/dashboard";
    }

    @GetMapping("/lista")
    public String showStudentList(Model model) {
        System.out.println("Inside method showStudentList()");
        model.addAttribute("studentList", userService.findAllStudents());
        return "/user/list";
    }

    @GetMapping("/edytuj")
    public String editUser(@RequestParam Long id,
                             Model model) {
        model.addAttribute("courseList", courseService.findAllSorted());
        model.addAttribute("user", userService.getUser(id));
        return "/register";
    }

    @GetMapping("/usun")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:lista";
    }


}
