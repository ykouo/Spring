package model.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private MybatisEmployeeDAO employeeDAO;
	
	@Override
	public void insertEmployee(EmployeeVO vo) {
		employeeDAO.insertEmployee(vo);
	}
	@Override
	public EmployeeVO getEmployee(EmployeeVO vo) {
		return employeeDAO.getEmployee(vo);
	}

	@Override
	public List<EmployeeVO> getAllEmployeeList(EmployeeVO vo) {
		return employeeDAO.getAllEmployeeList(vo);
	}

	@Override
	public void updateEmployee(EmployeeVO vo) {
		System.out.println("여기왔니00");
		employeeDAO.updateEmployee(vo);
	}

	@Override
	public void deleteEmployee(EmployeeVO vo) {
		employeeDAO.deleteEmployee(vo);
	}



}
