package university.springboot.abcUni.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.entity.Professor;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.entity.relations.CourseProf;
import university.springboot.abcUni.service.CourseService;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.ProfessorService;
import university.springboot.abcUni.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {


	private CourseService courseService;
	private ProfessorService professorService;
	private StudentService studentService;
	private DepartmentService departmentService;

	@Autowired
	public CourseRestController(
			CourseService theCourseService,
			ProfessorService theProfessorService,
			StudentService theStudentService,
			DepartmentService theDepartmentService
	) {
		courseService = theCourseService;
		professorService = theProfessorService;
		studentService = theStudentService;
		departmentService = theDepartmentService;
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

	//api to link courses to a professor
	@PutMapping("{profId}/courses/{courseId}")
	public Professor enrollCourseToProfessor(@PathVariable int courseId,@PathVariable int profId){
		Course course = courseService.findById(courseId);
		Professor professor = professorService.findById(profId);

		course.setProfessor(professor);
		courseService.save(course);
		return professor;
	}

	//api to link courses to a professor
	@PutMapping("courses/professor")
	public Professor enrollCourseToProfessor(@RequestBody CourseProf request){
		Course course = courseService.findById(request.getCourseId());
		Professor professor = professorService.findById(request.getProfId());

		course.setProfessor(professor);
		courseService.save(course);
		return professor;
	}

	@PutMapping("{courseId}/students/{studentId}")
	public Course enrollStudentToCourse(@PathVariable int courseId,@PathVariable int studentId){
		Course course = courseService.findById(courseId);
		Student student = studentService.findById(studentId);
		course.enrollStudent(student);
		return courseService.save(course);
	}

	@PutMapping("{depId}/courses/{courseId}/")
	public Course enrollCourseToDepartment(@PathVariable int courseId,@PathVariable int depId){
		Course course = courseService.findById(courseId);
		Department department = departmentService.findById(depId);

		course.setDepartment(department);
		return course;
	}
}
