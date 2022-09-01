package university.springboot.abcUni.service;

import java.util.List;

import university.springboot.abcUni.entity.Course;

public interface CourseService {

	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(Course theCourse);
	
}
