package university.springboot.abcUni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.springboot.abcUni.dao.CourseRepository;
import university.springboot.abcUni.dao.DepartmentRepository;
import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Department;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository){
		departmentRepository = theDepartmentRepository;
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(int theId) {
		Optional<Department> result = departmentRepository.findById(theId);
		Department theDepartment = null;
		if(result.isPresent()){
			theDepartment = result.get();
		}else{
			throw new RuntimeException("did not found idddd");
		}
		return theDepartment;
	}

	@Override
	public void deleteById(int theId) {
		departmentRepository.deleteById(theId);
	}

	@Override
	public void save(Department theDepartment) {departmentRepository.save(theDepartment);}

}
