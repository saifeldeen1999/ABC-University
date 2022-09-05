package university.springboot.abcUni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    private Map<Integer, Student> studentMap = new HashMap<>();


    private StudentService studentService;
    private DepartmentService departmentService;

    @Autowired
    public StudentController(StudentService theStudentService,DepartmentService theDepartmentService) {
        studentService = theStudentService;
        departmentService = theDepartmentService;
    }


    @GetMapping("/viewStudents")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "view-students";
    }

    @GetMapping("/addStudent")
    public String addStudentView(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentService.findAll());
        return "add-student";
    }

    @PostMapping("/addStudent")
    public RedirectView addStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes, BindingResult result, ModelMap model) {

        model.addAttribute("firstName",student.getFirstName());
        model.addAttribute("lastName",student.getLastName());
        model.addAttribute("email",student.getEmail());
        model.addAttribute("department",student.getDepartment());

        studentMap.put(student.getId(), student);


        final RedirectView redirectView = new RedirectView("/student/addStudent", true);

        Student savedStudent = studentService.save(student);

        redirectAttributes.addFlashAttribute("savedStudent", savedStudent);
        redirectAttributes.addFlashAttribute("addStudentSuccess", true);
        return redirectView;
    }
}
