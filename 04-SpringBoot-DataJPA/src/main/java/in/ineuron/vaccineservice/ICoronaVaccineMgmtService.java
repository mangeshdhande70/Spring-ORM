package in.ineuron.vaccineservice;

import java.util.List;
import java.util.Optional;

import in.ineuron.model.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public String registerVacine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
	public boolean checkAvailablityByRegNo(Long regNo);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsByID(List<Long> ids);
	public Optional<CoronaVaccine> fecthVaccineById(Long id);
	public String removeVaccineById(Long id);
	public String removeVaccineByObject(CoronaVaccine vacine);
	public String removeVaccinesById(List<Long> ids);
	
	
}
