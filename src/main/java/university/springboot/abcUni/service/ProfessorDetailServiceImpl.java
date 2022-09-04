package university.springboot.abcUni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.springboot.abcUni.dao.ProfessorDetailRepository;
import university.springboot.abcUni.entity.ProfessorDetail;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorDetailServiceImpl implements ProfessorDetailService {

	// need to inject ProfessorDetail dao
	@Autowired
	private ProfessorDetailRepository professorDetailRepository;

	public ProfessorDetailServiceImpl(ProfessorDetailRepository theProfessorDetailRepository){
		professorDetailRepository = theProfessorDetailRepository;
	}

	@Override
	public List<ProfessorDetail> findAll() {
		return professorDetailRepository.findAll();
	}

	@Override
	public ProfessorDetail findById(int theId) {
		Optional<ProfessorDetail> result = professorDetailRepository.findById(theId);
		ProfessorDetail theProfessorDetail = null;
		if(result.isPresent()){
			theProfessorDetail = result.get();
		}else{
			throw new RuntimeException("did not found idddd");
		}
		return theProfessorDetail;
	}

	@Override
	public void deleteById(int theId) {
		professorDetailRepository.deleteById(theId);
	}

	@Override
	public void save(ProfessorDetail theProfessorDetail) {professorDetailRepository.save(theProfessorDetail);}

}
