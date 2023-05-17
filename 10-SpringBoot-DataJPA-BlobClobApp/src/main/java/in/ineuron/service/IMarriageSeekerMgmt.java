package in.ineuron.service;

import java.util.Optional;

import in.ineuron.model.MarriageSeeker;

public interface IMarriageSeekerMgmt {
	
	
	public String registerSeeker(MarriageSeeker marriageSeeker  );
	
	public Optional<MarriageSeeker> searchSeekerById(Long id);

}
