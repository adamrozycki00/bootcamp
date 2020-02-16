package pl.sda.Bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.Bootcamp.model.User;

@Controller
@RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
public class RegisterController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/podsumowanie", method = RequestMethod.GET)
    public String summary(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String mail,
                          Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("mail", mail);
        return "/summary";
    }

    @RequestMapping(value = "/podsumowanie", method = RequestMethod.POST)
    public String summaryRegister(@ModelAttribute User user,
                                  Model model) {
//        model.addAttribute("firstName", user.getFirstName());
//        model.addAttribute("lastName", user.getLastName());
//        model.addAttribute("mail", user.getMail());
        model.addAttribute("user", user);
        return "/summary";
    }

}
