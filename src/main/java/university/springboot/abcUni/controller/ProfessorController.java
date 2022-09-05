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
import university.springboot.abcUni.service.ProfessorService;
import university.springboot.abcUni.service.StudentService;

@Controller
@RequestMapping("/student")
public class ProfessorController {

    private StudentService studentService;
    private ProfessorService professorService;

    @Autowired
    public ProfessorController(StudentService theStudentService, ProfessorService theProfessorService) {
        studentService = theStudentService;
        professorService = theProfessorService;
    }


    @GetMapping("/viewProfessors")
    public String viewProfessors(Model model) {
        model.addAttribute("professors", professorService.findAll());
        return "view-professors";
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
