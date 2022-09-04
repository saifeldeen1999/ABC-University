package university.springboot.abcUni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.springboot.abcUni.dao.ProfessorRepository;
import university.springboot.abcUni.entity.Professor;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository theProfessorRepository){
        professorRepository = theProfessorRepository;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findById(int theId) {
        Optional<Professor> result = professorRepository.findById(theId);
        Professor theProfessor = null;
        if(result.isPresent()){
            theProfessor = result.get();
        }else{
            throw new RuntimeException("did not found idddd");
        }
        return theProfessor;
    }

    @Override
    public void deleteById(int theId) {
        professorRepository.deleteById(theId);
    }

    @Override
    public void save(Professor theProfessor) {
        professorRepository.save(theProfessor);
    }
}
