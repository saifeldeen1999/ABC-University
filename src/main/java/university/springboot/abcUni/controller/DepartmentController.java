package university.springboot.abcUni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.entity.Professor;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.StudentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private StudentService studentService;
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(StudentService theStudentService, DepartmentService theDepartmentService) {
        studentService = theStudentService;
        departmentService = theDepartmentService;
    }

    @GetMapping("/viewDepartment/{departmentId}")
    public String findById(@PathVariable int departmentId,Model model){
        model.addAttribute("department",departmentService.findById(departmentId));
        return "view-department";
    }


    @GetMapping("/viewDepartments")
    public String viewDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "view-departments";
    }

    @GetMapping("/addDepartment")
    public String addDepartmentView(Model model) {
        //new objects to be populated by the user
        model.addAttribute("Department", new Department());

        return "add-department";
    }

    @PostMapping("/addDepartment")
    public RedirectView addDepartment(
            @RequestParam String title,
            RedirectAttributes redirectAttributes) {

        Department newDepartment = new Department(title);
        final RedirectView redirectView = new RedirectView("/department/addDepartment", true);
        Department savedDepartment = departmentService.save(newDepartment);

        redirectAttributes.addFlashAttribute("savedDepartment", savedDepartment);
        redirectAttributes.addFlashAttribute("addDepartmentSuccess", true);
        return redirectView;
    }

    @DeleteMapping("/deleteDepartment/{departmentId}")
    public String deleteById(@PathVariable int departmentId){
        Department department = departmentService.findById(departmentId);
        if(department == null) {
            throw new RuntimeException("ID:" + departmentId + " not found");
        }
        departmentService.deleteById(departmentId);
        return "Deleted Department id #" + departmentId;
    }

    @GetMapping("/editDepartment/{departmentId}")
    public String updateDepartmentView(Model model,@PathVariable int departmentId){
        //new objects to be populated by the user
        model.addAttribute("Department", new Department());
        model.addAttribute("theDepartment",departmentService.findById(departmentId));


        return "edit-department";
    }

    @PutMapping("/editDepartment")
    public Department updateDepartment(@RequestBody Department department){
        departmentService.save(department);
        return department;
    }

}
