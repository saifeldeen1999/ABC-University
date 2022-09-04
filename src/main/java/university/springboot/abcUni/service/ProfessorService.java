package university.springboot.abcUni.service;

import university.springboot.abcUni.entity.Professor;

import java.util.List;

public interface ProfessorService {

	public List<Professor> findAll();
	
	public Professor findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(Professor theProfessor);
	
}
