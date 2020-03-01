package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByOrderByNameAscMode();

//    @Query(value = "select c.* from Course c where c.name = ?", nativeQuery = true)
//    List<Course> findByNameQuery(String name);
//
//    @Query(name = "Course.findByMode")
//    List<Course> findByModeQuery(@Param("mode") String mode);






}
