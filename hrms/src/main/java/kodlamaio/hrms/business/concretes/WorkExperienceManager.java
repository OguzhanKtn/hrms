package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.WorkExperienceDao;
import kodlamaio.hrms.entities.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{

	  private WorkExperienceDao workExperienceDao;
	  
	  @Autowired
	  public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		  super();
		  this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience workExperience) {
		
		if(workExperience.getEndingDate().isEmpty()) {
			
			workExperience.setEndingDate("Still working");
		}
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("Work experience has added");
	}
	

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
	}

	
	  @Override public DataResult<List<WorkExperience>>
	  getAllByCv_CvIdOrderByEndingDateDesc(int cvId) {
	  
	  return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.
	  getAllByCv_CvIdOrderByEndingDateDesc(cvId)); }
	 

}
