package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    List<Course> findByNameAndPriceGreaterThanEqual(String name, int minPrice);

    @Query(value = "select c.* from Course c where c.name = ?1", nativeQuery = true)
    List<Course> findByNameQuery(String name);

    @Query(name = "Course.findByMode")
    List<Course> findByModeQuery(@Param("mode") String mode);



}
