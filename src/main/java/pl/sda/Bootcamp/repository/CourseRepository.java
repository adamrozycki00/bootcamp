package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    List<Course> findByNameAndPriceGreaterThanEqual(String name, int minPrice);

    @Query("select c from Course c where c.name = ?1")
    List<Course> findByNameQuery(String name);


}
