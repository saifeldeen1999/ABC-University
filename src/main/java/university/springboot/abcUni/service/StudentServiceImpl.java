package university.springboot.abcUni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import university.springboot.abcUni.dao.StudentDAO;
import university.springboot.abcUni.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theStudentDAO) {
		studentDAO = theStudentDAO;
	}

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		return studentDAO.findById(theId);
	}

	@Override
	public void deleteById(int theId) {
		studentDAO.deleteById(theId);

	}

	@Override
	public void save(Student theStudent) {
		studentDAO.save(theStudent);

	}

}
