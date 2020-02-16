package pl.sda.Bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/student", method = RequestMethod.GET)
public class StudentController {

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public String home() {
        return "/student/list";
    }


}
