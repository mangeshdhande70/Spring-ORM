package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ineuron.dao.IEmployeeDao;
import in.ineuron.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao iEmployeeDao;

	@Override
	public void save(Employee employee) {

		iEmployeeDao.save(employee);
		
	}
	
	
	
	

}
