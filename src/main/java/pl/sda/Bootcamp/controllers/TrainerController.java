package pl.sda.Bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.Bootcamp.model.User;
import pl.sda.Bootcamp.service.CourseService;
import pl.sda.Bootcamp.service.RoleService;
import pl.sda.Bootcamp.service.UserService;

@Controller
@RequestMapping("/user/trenerzy")
public class TrainerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/lista")
    public String showTrainerList(Model model) {
        model.addAttribute("trainerList", userService.findAllTrainers());
        model.addAttribute("coursesOfTrainers", courseService.findCoursesOTrainers());
        return "/user/trainer-list";
    }

    @GetMapping("/edytuj")
    public String editTrainer(@RequestParam Long id,
                              Model model) {
        model.addAttribute("courseList", courseService.findAllSorted());
        model.addAttribute("user", userService.getUser(id));
        return "/register";
    }

    @GetMapping("/usun")
    public String deleteTrainer(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:lista";
    }

    @GetMapping("/dodaj")
    public String addTrainer(Model model) {
        User trainer = new User();
        trainer.setRole(roleService.findByRoleName("trainer"));
        model.addAttribute("user", trainer);
        model.addAttribute("courseList", courseService.findAllSorted());
        return "/register";
    }


}
