package in.ineuron.dao;

import java.util.Optional;

import in.ineuron.model.CoronaVaccine;

public class CorononaVacchinImpl implements ICoronaVaccineRepo {

	@Override
	public <S extends CoronaVaccine> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CoronaVaccine> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CoronaVaccine> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CoronaVaccine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CoronaVaccine> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CoronaVaccine entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends CoronaVaccine> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
