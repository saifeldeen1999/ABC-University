package university.springboot.abcUni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.springboot.abcUni.dao.StudentDAO;
import university.springboot.abcUni.dao.StudentRepository;
import university.springboot.abcUni.entity.Professor;
import university.springboot.abcUni.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		Student theStudent = null;
		if(result.isPresent()){
			theStudent = result.get();
		}else{
			throw new RuntimeException("did not found idddd");
		}
		return theStudent;
	}

	@Override

	public void deleteById(int theId) {
		studentRepository.deleteById(theId);

	}

	@Override
	@Transactional
	public Student save(Student theStudent) {
		return studentRepository.save(theStudent);

	}

	@Override
	@Transactional
	public Student getOne(int studentId){
		return studentRepository.getOne(studentId);
	}

}
