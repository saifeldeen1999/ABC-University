package university.springboot.abcUni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import university.springboot.abcUni.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
