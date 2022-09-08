package university.springboot.abcUni.rest;

import org.springframework.web.bind.annotation.*;
import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.entity.Professor;
import university.springboot.abcUni.entity.Student;
import university.springboot.abcUni.service.DepartmentService;
import university.springboot.abcUni.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorRestController {


    private ProfessorService professorService;
    private DepartmentService departmentService;

    public ProfessorRestController(ProfessorService theProfessorService,DepartmentService theDepartmentService) {
        professorService = theProfessorService;
        departmentService = theDepartmentService;
    }

    @GetMapping("professors")
    public List<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping("professors/{professorId}")
    public Professor findById(@PathVariable int professorId){
        Professor professor = professorService.findById(professorId);
        if(professor == null) {
            throw new RuntimeException("ID:" + professorId + " not found");
        }
        return professor;
    }

    @PostMapping("professors")
    public Professor addProfessor(@RequestBody Professor professor){
        professor.setId(0);
        professorService.save(professor);
        return professor;
    }

    @PutMapping("professors")
    public Professor updateProfessor(@RequestBody Professor professor){
        professorService.save(professor);
        return professor;
    }

    @DeleteMapping("professors/{professorId}")
    public String deleteById(@PathVariable int professorId){
        Professor professor = professorService.findById(professorId);
        if(professor == null) {
            throw new RuntimeException("ID:" + professorId + " not found");
        }
        professorService.deleteById(professorId);
        return "Deleted professor id #" + professorId;
    }

    @PutMapping("{depId}/professors/{professorId}")
    public String enrollProfessorToDepartment(@PathVariable int depId, @PathVariable int professorId) {
        Professor professor = professorService.findById(professorId);
        Department department = departmentService.findById(depId);

        if(department == null || professor == null) {
            throw new RuntimeException("ID:" + depId + " not found");
        }

        professor.setDepartment(department);
        professorService.save(professor);
        return "Professor: "+professor.getFirstName()+"Successfully enrolled to Department: "+department.getTitle();

    }
}

