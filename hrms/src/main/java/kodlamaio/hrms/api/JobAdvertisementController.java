package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.entities.*;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>>  getAll(){
		
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>>  getAllActive(){
		
		return this.jobAdvertisementService.findAllByIsActive();
	}
	
	@GetMapping("/getallactivesorted")
	public DataResult<List<JobAdvertisement>>  getAllActiveSorted(){
		
		return this.jobAdvertisementService.findAllByIsActiveSorted();
	}
	
	@GetMapping("/getEmployerJobAdvertisement")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {
		
		return this.jobAdvertisementService.findAllByIsActiveAndCompanyName(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementPostDto jobAdvertisement){
		
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/jobAdvertisementDisable")
	public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {
		
		return this.jobAdvertisementService.jobAdvertisementDisabled(id);
	}
	

	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisement>>findAllByIsActiveTrueOrderByCreatedDateAsc(){
		return this.jobAdvertisementService.findAllByIsActiveTrueOrderByCreatedDateAsc();
	}
}
