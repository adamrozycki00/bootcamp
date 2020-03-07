package pl.sda.Bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.Bootcamp.model.User;
import pl.sda.Bootcamp.service.CourseService;
import pl.sda.Bootcamp.service.RoleService;
import pl.sda.Bootcamp.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rejestracja")
public class RegisterController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String register(Model model) {
        model.addAttribute("courseList", courseService.findAllSorted());
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/podsumowanie")
    public String summaryRegister(@Valid @ModelAttribute User user,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            model.addAttribute("courseList", courseService.findAllSorted());
//            model.addAttribute("user", new User());
            return "/register";
        } else {
            if (user.getRole() == null)
                user.setRole(roleService.findByRoleName("user"));

            /** Kodowanie hasła studenta w bazie danych */
            PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            userService.save(user);
            model.addAttribute("user", user);
            return "/summary";
        }
    }

}
