package university.springboot.abcUni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import university.springboot.abcUni.entity.ProfessorDetail;

public interface ProfessorDetailRepository extends JpaRepository<ProfessorDetail,Integer> {
}
