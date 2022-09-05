package university.springboot.abcUni.dao;

import java.util.List;

import university.springboot.abcUni.entity.Student;

public interface StudentDAO {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void deleteById(int theId);
	
	public Student save(Student theStudent);
	
}
