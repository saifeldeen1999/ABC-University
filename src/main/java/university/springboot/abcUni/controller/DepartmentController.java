package university.springboot.abcUni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.StudentService;

@Controller
@RequestMapping("/student")
public class DepartmentController {

    private StudentService studentService;
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(StudentService theStudentService, DepartmentService theDepartmentService) {
        studentService = theStudentService;
        departmentService = theDepartmentService;
    }


    @GetMapping("/viewDepartments")
    public String viewDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "view-departments";
    }

//    @GetMapping("/addStudent")
//    public String addStudentView(Model model) {
//        model.addAttribute("student", new Student());
//        return "add-student";
//    }
//
//    @PostMapping("/addStudent")
//    public RedirectView addStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("/student/addStudent", true);
//        Student savedStudent = studentService.save(student);
//        redirectAttributes.addFlashAttribute("savedStudent", savedStudent);
//        redirectAttributes.addFlashAttribute("addStudentSuccess", true);
//        return redirectView;
//    }
}
