package pl.sda.Bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ExampleRestController {

    @Autowired
    CourseService courseService;

    @GetMapping("")
    public List<Course> getCourses() {
        return courseService.findAllSorted();
    }

}
