package pl.sda.Bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.Bootcamp.model.Course;
import pl.sda.Bootcamp.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course getCourse(Long id) {
        return courseRepository.getOne(id);
    }

    public List<Course> findAllSorted() {
        return courseRepository.findAllByOrderByNameAscModeAsc();
    }

}
