package university.springboot.abcUni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.ProfessorService;
import university.springboot.abcUni.service.StudentService;

@Controller
@RequestMapping("/home")
public class HomePageController {

    private StudentService studentService;
    private DepartmentService departmentService;
    private ProfessorService professorService;

    @Autowired
    public HomePageController(StudentService theStudentService,DepartmentService theDepartmentService,ProfessorService theProfessorService) {
        studentService = theStudentService;
        departmentService = theDepartmentService;
        professorService = theProfessorService;
    }


    @GetMapping("/viewData")
    public String viewData(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("professors", professorService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "home";
    }

}
