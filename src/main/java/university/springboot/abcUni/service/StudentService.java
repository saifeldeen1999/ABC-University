package university.springboot.abcUni.service;

import java.util.List;

import university.springboot.abcUni.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(Student theStudent);
	
}
