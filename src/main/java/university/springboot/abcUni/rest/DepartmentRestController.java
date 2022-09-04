package university.springboot.abcUni.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.service.CourseService;
import university.springboot.abcUni.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {


	private DepartmentService departmentService;

	@Autowired
	public DepartmentRestController(DepartmentService theDepartmentService) {
		departmentService = theDepartmentService;
	}
	
	@GetMapping("departments")
	public List<Department> findAll(){
		return departmentService.findAll();
	}
	
	@GetMapping("departments/{departmentId}")
	public Department findById(@PathVariable int departmentId){
		Department department = departmentService.findById(departmentId);
		if(department == null) {
			throw new RuntimeException("ID:" + departmentId + " not found");
		}
		return department;
	}
	
	@PostMapping("departments")
	public Department addDepartment(@RequestBody Department department){
		department.setId(0);
		departmentService.save(department);
		 return department;
	}
	
	@PutMapping("departments")
	public Department updateDepartment(@RequestBody Department department){
		departmentService.save(department);
		 return department;
	}
	
	@DeleteMapping("departments/{departmentId}")
	public String deleteById(@PathVariable int departmentId){
		Department department = departmentService.findById(departmentId);
		if(department == null) {
			throw new RuntimeException("ID:" + departmentId + " not found");
		}
		departmentService.deleteById(departmentId);
		return "Deleted department id #" + departmentId;
	}
}
