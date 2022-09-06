package university.springboot.abcUni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import university.springboot.abcUni.entity.Professor;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.ProfessorService;
import university.springboot.abcUni.service.StudentService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    private StudentService studentService;
    private ProfessorService professorService;

    @Autowired
    public ProfessorController(StudentService theStudentService, ProfessorService theProfessorService) {
        studentService = theStudentService;
        professorService = theProfessorService;
    }

    @GetMapping("/viewProfessor/{professorId}")
    public String findById(@PathVariable int professorId,Model model){
        model.addAttribute("professor",professorService.findById(professorId));
        return "view-professor";
    }


    @GetMapping("/viewProfessors")
    public String viewProfessors(Model model) {
        model.addAttribute("professors", professorService.findAll());
        return "view-professors";
    }


    @GetMapping("/addProfessor")
    public String addProfessorView(Model model) {
        //new objects to be populated by the user
        model.addAttribute("Professor", new Professor());

        return "add-professor";
    }

    @PostMapping("/addProfessor")
    public RedirectView addProfessor(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            RedirectAttributes redirectAttributes) {

        Professor newProfessor = new Professor(firstName,lastName,email);
        final RedirectView redirectView = new RedirectView("/professor/addProfessor", true);
        Professor savedProfessor = professorService.save(newProfessor);

        redirectAttributes.addFlashAttribute("savedProfessor", savedProfessor);
        redirectAttributes.addFlashAttribute("addProfessorSuccess", true);
        return redirectView;
    }

    @DeleteMapping("/deleteProfessor/{professorId}")
    public String deleteById(@PathVariable int professorId){
        Professor professor = professorService.findById(professorId);
        if(professor == null) {
            throw new RuntimeException("ID:" + professorId + " not found");
        }
        professorService.deleteById(professorId);
        return "Deleted Professor id #" + professorId;
    }

    @GetMapping("/editProfessor/{professorId}")
    public String updateProfessorView(Model model,@PathVariable int professorId){
        //new objects to be populated by the user
        model.addAttribute("Professor", new Professor());
        model.addAttribute("theProfessor",professorService.findById(professorId));

        //pre_populating the form with the departments already registered
        model.addAttribute("professors", professorService.findAll());
        return "edit-professor";
    }

    @PutMapping("/editProfessor")
    public Professor updateProfessor(@RequestBody Professor professor){
        professorService.save(professor);
        return professor;
    }

}
