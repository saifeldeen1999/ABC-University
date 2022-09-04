package university.springboot.abcUni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import university.springboot.abcUni.dao.CourseRepository;
import university.springboot.abcUni.entity.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	// need to inject customer dao
	@Autowired
	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository theCourseRepository){
		courseRepository = theCourseRepository;
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int theId) {
		Optional<Course> result = courseRepository.findById(theId);
		Course theCourse = null;
		if(result.isPresent()){
			theCourse = result.get();
		}else{
			throw new RuntimeException("did not found idddd");
		}
		return theCourse;
	}

	@Override
	public void deleteById(int theId) {
		courseRepository.deleteById(theId);
	}

	@Override
	public void save(Course theCourse) {courseRepository.save(theCourse);}

}
