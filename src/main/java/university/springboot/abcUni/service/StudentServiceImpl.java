package university.springboot.abcUni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		return studentDAO.findById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentDAO.deleteById(theId);

	}

	@Override
	@Transactional
	public Student save(Student theStudent) {
		return studentDAO.save(theStudent);

	}

}
