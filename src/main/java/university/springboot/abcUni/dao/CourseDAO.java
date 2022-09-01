package university.springboot.abcUni.dao;

import java.util.List;

import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Student;

public interface CourseDAO {
	
	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(Course theCourse);
	
}
