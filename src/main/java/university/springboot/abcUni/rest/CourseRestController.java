package university.springboot.abcUni.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {


	private CourseService courseService;

	@Autowired
	public CourseRestController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	@GetMapping("courses")
	public List<Course> findAll(){
		return courseService.findAll();
	}
	
	@GetMapping("courses/{courseId}")
	public Course findById(@PathVariable int courseId){
		Course course = courseService.findById(courseId);
		if(course == null) {
			throw new RuntimeException("ID:" + courseId + " not found");
		}
		return course;
	}
	
	@PostMapping("courses")
	public Course addCourse(@RequestBody Course course){
		course.setId(0);
		courseService.save(course);
		 return course;
	}
	
	@PutMapping("courses")
	public Course updateCourse(@RequestBody Course course){
		courseService.save(course);
		 return course;
	}
	
	@DeleteMapping("courses/{courseId}")
	public String deleteById(@PathVariable int courseId){
		Course course = courseService.findById(courseId);
		if(course == null) {
			throw new RuntimeException("ID:" + courseId + " not found");
		}
		courseService.deleteById(courseId);
		return "Deleted Course id #" + courseId;
	}
}
