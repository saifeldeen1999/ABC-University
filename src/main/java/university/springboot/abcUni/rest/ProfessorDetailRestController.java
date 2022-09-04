package university.springboot.abcUni.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import university.springboot.abcUni.entity.ProfessorDetail;
import university.springboot.abcUni.service.ProfessorDetailService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorDetailRestController {


	private ProfessorDetailService professorDetailService;

	@Autowired
	public ProfessorDetailRestController(ProfessorDetailService theProfessorDetailService) {
		professorDetailService = theProfessorDetailService;
	}
	
	@GetMapping("profDetails")
	public List<ProfessorDetail> findAll(){
		return professorDetailService.findAll();
	}
	
	@GetMapping("profDetails/{profDetailId}")
	public ProfessorDetail findById(@PathVariable int profDetailId){
		ProfessorDetail professorDetail = professorDetailService.findById(profDetailId);
		if(professorDetail == null) {
			throw new RuntimeException("ID:" + profDetailId + " not found");
		}
		return professorDetail;
	}
	
	@PostMapping("profDetails")
	public ProfessorDetail addProfessorDetail(@RequestBody ProfessorDetail professorDetail){
		professorDetail.setId(0);
		professorDetailService.save(professorDetail);
		 return professorDetail;
	}
	
	@PutMapping("profDetails")
	public ProfessorDetail updateProfessorDetail(@RequestBody ProfessorDetail professorDetail){
		professorDetailService.save(professorDetail);
		 return professorDetail;
	}
	
	@DeleteMapping("profDetails/{profDetailId}")
	public String deleteById(@PathVariable int profDetailId){
		ProfessorDetail professorDetail = professorDetailService.findById(profDetailId);
		if(professorDetail == null) {
			throw new RuntimeException("ID:" + profDetailId + " not found");
		}
		professorDetailService.deleteById(profDetailId);
		return "Deleted profDetail id #" + profDetailId;
	}
}
