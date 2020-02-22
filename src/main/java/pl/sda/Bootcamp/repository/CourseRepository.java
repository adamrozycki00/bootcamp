package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
