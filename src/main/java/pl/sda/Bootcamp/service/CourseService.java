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

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course getCourse(Long id) {
        return courseRepository.getOne(id);
    }

    public List<Course> findByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> findByNameQuery(String name) {
        return courseRepository.findByNameQuery(name);
    }

    public List<Course> findByModeQuery(String mode) {
        return courseRepository.findByModeQuery(mode);
    }

    public List<Course> findByNameAndPriceGreaterThanEqual(String name, int minPrice) {
        return courseRepository.findByNameAndPriceGreaterThanEqual(name, minPrice);
    }

    public List<Course> findAllSorted() {
        return courseRepository.findAllSorted();
    }


}
