package university.springboot.abcUni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import university.springboot.abcUni.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
