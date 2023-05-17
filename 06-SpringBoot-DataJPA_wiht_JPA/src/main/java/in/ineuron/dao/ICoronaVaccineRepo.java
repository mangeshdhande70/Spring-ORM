package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

}
