package university.springboot.abcUni.service;

import university.springboot.abcUni.entity.ProfessorDetail;

import java.util.List;

public interface ProfessorDetailService {

	public List<ProfessorDetail> findAll();
	
	public ProfessorDetail findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(ProfessorDetail theProfessorDetail);
	
}
