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
import university.springboot.abcUni.entity.relations.StudentDep;
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
	
	@PostMapping("students")
	public Student addStudent(@RequestBody Student student){
		//	Department department = departmentService.findById(departmentId);
//		if(department == null) {
//			throw new RuntimeException("ID:" + departmentId + " not found");
//		}
		student.setId(0); //optional
//		student.setDepartment(department);
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

	//api to enroll student in department by sending student & department id in params
	@PutMapping("{depId}/students/{studentId}")
	public Student enrollStudentToDepartment(@PathVariable int depId,@PathVariable int studentId) {
		Department department = departmentService.findById(depId);
		Student student = studentService.findById(studentId);

		if(department == null || student == null) {
			throw new RuntimeException("ID:" + depId + " not found");
		}

		student.setDepartment(department);
		studentService.save(student);
		return student;

	}

	//api to enroll student in department by sending a body with student & department id
	@PutMapping("students/department")
	public Student enrollStudentToDepartment(@RequestBody StudentDep request) {
		Department department = departmentService.findById(request.getDepId());
		Student student = studentService.findById(request.getStudentId());

		if(department == null || student == null) {
			throw new RuntimeException("ID:" + " not found");
		}

		student.setDepartment(department);
		studentService.save(student);
		return student;

	}

	//api to enroll student in department by sending student & department id in params
//	@PutMapping("students/department/{studentId}/{depId}")
//	public Student studentEnrollDepartment(@PathVariable int depId,@PathVariable int studentId) {
//		Department department = departmentService.findById(depId);
//		Student student = studentService.findById(studentId);
//
//		if(department == null || student == null) {
//			throw new RuntimeException("ID:" + depId + " not found");
//		}
//
//		student.setDepartment(department);
//		studentService.save(student);
//		return student;
//
//	}

}
