package in.ineuron.vaccineservice;

import java.util.List;

import in.ineuron.model.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,String... properties);
	public CoronaVaccine getVaccineById(Long regNo);
	public String removeVaccinesByRegNo(Iterable<Long> regNo);

}
