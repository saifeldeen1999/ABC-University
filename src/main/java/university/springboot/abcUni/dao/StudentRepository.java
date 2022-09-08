package university.springboot.abcUni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
