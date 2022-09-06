package university.springboot.abcUni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.StudentService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

  //  private Map<Integer, Student> studentMap = new HashMap<>();


    private StudentService studentService;
    private DepartmentService departmentService;

    @Autowired
    public StudentController(StudentService theStudentService,DepartmentService theDepartmentService) {
        studentService = theStudentService;
        departmentService = theDepartmentService;
    }

    @GetMapping("/viewStudent/{studentId}")
    public String findById(@PathVariable int studentId,Model model){
        model.addAttribute("student",studentService.findById(studentId));
        return "view-student";
    }

    @GetMapping("/viewStudents")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "view-students";
    }

    @GetMapping("/addStudent")
    public String addStudentView(Model model) {

        //new objects to be populated by the user
        model.addAttribute("student", new Student());

        //pre_populating the form with the departments already registered
        model.addAttribute("departments", departmentService.findAll());

        return "add-student";
    }

//    @PostMapping("/addStudent")
//    public RedirectView addStudent(
//            @ModelAttribute("student") Student student,
//            @ModelAttribute("department") Department department,
//            RedirectAttributes redirectAttributes,
//            BindingResult result,
//            ModelMap model) {
//
//        model.addAttribute("firstName",student.getFirstName());
//        model.addAttribute("lastName",student.getLastName());
//        model.addAttribute("email",student.getEmail());
//        model.addAttribute("department_id",department.getId());
//
//        studentMap.put(student.getId(), student);
//
//        final RedirectView redirectView = new RedirectView("/student/addStudent", true);
//
//        Student savedStudent = studentService.save(student);
//
//        redirectAttributes.addFlashAttribute("savedStudent", savedStudent);
//        redirectAttributes.addFlashAttribute("addStudentSuccess", true);
//        return redirectView;
//    }

    @PostMapping("/addStudent")
    public RedirectView addStudent(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            RedirectAttributes redirectAttributes) {

        Student newStudent = new Student(firstName,lastName,email);
        final RedirectView redirectView = new RedirectView("/student/addStudent", true);
        Student savedStudent = studentService.save(newStudent);

        redirectAttributes.addFlashAttribute("savedStudent", savedStudent);
        redirectAttributes.addFlashAttribute("addStudentSuccess", true);
        return redirectView;
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteById(@PathVariable int studentId){
        Student student = studentService.findById(studentId);
        if(student == null) {
            throw new RuntimeException("ID:" + studentId + " not found");
        }
        studentService.deleteById(studentId);
        return "Deleted Student id #" + studentId;
    }

    @GetMapping("/editStudent/{studentId}")
    public String updateStudentView(Model model,@PathVariable int studentId){
        //new objects to be populated by the user
        model.addAttribute("student", new Student());
        model.addAttribute("theStudent",studentService.findById(studentId));

        //pre_populating the form with the departments already registered
        model.addAttribute("departments", departmentService.findAll());
        return "edit-student";
    }

    @PutMapping("/editStudent")
    public Student updateStudent(@RequestBody Student student){
        studentService.save(student);
        return student;
    }



}
