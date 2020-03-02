package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByOrderByNameAscModeAsc();

//    @Query(value = "select" +
//            "   uc.user_id" +
//            "   , c.name" +
//            "   , c.mode" +
//            "   , c.date_start" +
//            "   , c.date_end " +
//            "from" +
//            "   user_courses uc" +
//            "   , course c" +
//            "   , user u " +
//            "where" +
//            "   uc.courses_id = c.id " +
//            "   and uc.user_id = u.id " +
//            "   and u.role_id = (select id from role where role_name = 'trainer')",
//            nativeQuery = true)
//    List<Object> findCoursesOfTrainers();

//    @Query(value = "select c.* from Course c where c.name = ?", nativeQuery = true)
//    List<Course> findByNameQuery(String name);
//
//    @Query(name = "Course.findByMode")
//    List<Course> findByModeQuery(@Param("mode") String mode);


}
