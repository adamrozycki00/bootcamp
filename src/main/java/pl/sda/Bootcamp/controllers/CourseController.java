package pl.sda.Bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/kurs")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/lista")
    public String showList(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "/course/list";
    }

    @PostMapping("/lista")
    public String saveCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:lista";
    }

    @GetMapping("/dodaj-kurs")
    public String addCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "/addCourse";
    }

    @GetMapping("/usun")
    public String deleteCourse(@RequestParam Long id) {
        courseService.delete(id);
        return "redirect:lista";
    }

}
