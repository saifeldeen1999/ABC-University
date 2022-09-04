package university.springboot.abcUni.service;

import university.springboot.abcUni.entity.Department;

import java.util.List;

public interface DepartmentService {


    public List<Department> findAll();

    public Department findById(int theId);

    public void deleteById(int theId);

    public void save(Department theDepartment);

}
