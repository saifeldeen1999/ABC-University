package university.springboot.abcUni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import university.springboot.abcUni.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
