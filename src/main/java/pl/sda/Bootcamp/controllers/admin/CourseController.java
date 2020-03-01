package pl.sda.Bootcamp.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/admin/kurs")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/lista")
    public String showList(Model model) {
        List<Course> courseList = courseService.findAllSorted();
        model.addAttribute("courseList", courseList);
        return "/course/list";
    }

    @PostMapping("/lista")
    public String saveCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:lista";
    }

    @GetMapping("/dodaj")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "/course/add";
    }

    @GetMapping("/edytuj")
    public String editCourse(@RequestParam Long id,
                             Model model) {
        model.addAttribute("course", courseService.getCourse(id));
        return "/course/add";
    }

    @GetMapping("/usun")
    public String deleteCourse(@RequestParam Long id) {
        courseService.delete(id);
        return "redirect:lista";
    }


}
