package pl.sda.Bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/kurs", method = RequestMethod.GET)
public class CourseController {

    @GetMapping("/lista")
    public String course() {
        return "/course/list";
    }

}
