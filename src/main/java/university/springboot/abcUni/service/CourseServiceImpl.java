package university.springboot.abcUni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import university.springboot.abcUni.dao.CourseDAO;
import university.springboot.abcUni.entity.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	// need to inject customer dao
	@Autowired
	private CourseDAO courseDAO;

	@Override
	@Transactional
	public List<Course> findAll() {
		return courseDAO.findAll();
	}

	@Override
	@Transactional
	public Course findById(int theId) {
		return courseDAO.findById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		courseDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public void save(Course theCourse) {courseDAO.save(theCourse);}

}
