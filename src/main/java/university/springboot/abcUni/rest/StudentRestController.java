package university.springboot.abcUni.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	private StudentService studentService;
	private DepartmentService departmentService;
	
	@Autowired
	public StudentRestController(StudentService theStudentService,DepartmentService theDepartmentService) {
		studentService = theStudentService;
		departmentService = theDepartmentService;
	}
	
	@GetMapping("students")
	public List<Student> findAll(){
		return studentService.findAll();
	}

	@GetMapping("viewStudents")
	public String viewStudents(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "view-students";
	}
	
	@GetMapping("students/{studentId}")
	public Student findById(@PathVariable int studentId){
		Student student = studentService.findById(studentId);
		if(student == null) {
			throw new RuntimeException("ID:" + studentId + " not found");
		}
		return student;
	}
	
	@PostMapping("students/{departmentId}")
	public Student addStudent(@RequestBody Student student,@PathVariable int departmentId){
		Department department = departmentService.findById(departmentId);
		System.out.println(departmentId);
		if(department == null) {
			throw new RuntimeException("ID:" + departmentId + " not found");
		}
		student.setId(0); //optional
		student.setDepartment(department);
		studentService.save(student);
		 return student;
	}
	
	@PutMapping("students")
	public Student updateStudent(@RequestBody Student student){
		studentService.save(student);
		 return student;
	}
	
	@DeleteMapping("students/{studentId}")
	public String deleteById(@PathVariable int studentId){
		Student student = studentService.findById(studentId);
		if(student == null) {
			throw new RuntimeException("ID:" + studentId + " not found");
		}
		studentService.deleteById(studentId);
		return "Deleted Student id #" + studentId;
	}
}
