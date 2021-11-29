package model.employee;

import java.util.List;

public interface EmployeeService {
	void insertEmployee(EmployeeVO vo);
	EmployeeVO getEmployee(EmployeeVO vo);
	List<EmployeeVO> getAllEmployeeList(EmployeeVO vo);
	List<EmployeeVO> searchEmployeeList(EmployeeVO vo);
	void updateEmployee(EmployeeVO vo);
	void deleteEmployee(EmployeeVO vo);
		
	
}
