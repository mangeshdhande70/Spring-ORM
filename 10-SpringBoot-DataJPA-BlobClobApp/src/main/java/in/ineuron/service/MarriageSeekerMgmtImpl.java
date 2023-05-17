package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IMarriageSeekerRepo;
import in.ineuron.model.MarriageSeeker;


@Service
public class MarriageSeekerMgmtImpl implements IMarriageSeekerMgmt {
	
	@Autowired
	private IMarriageSeekerRepo repo;

	@Override
	public String registerSeeker(MarriageSeeker marriageSeeker) {
		return "Marriage  Seeker info is saved with id "+repo.save(marriageSeeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) {		
		return repo.findById(id);
	}

}
