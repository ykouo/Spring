package model.employee;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisEmployeeDAO {

	@Autowired 
	private SqlSessionTemplate mybatis;
	
	public EmployeeVO getEmployee(EmployeeVO vo) {
		return mybatis.selectOne("employeeDao.getEmployee", vo);
	}
	public List<EmployeeVO> getAllEmployeeList(EmployeeVO vo) {
		System.out.println("마이바티스 스프링 연동실습중...");
		System.out.println(vo.getCondition()+" "+vo.getKeyword());
		return mybatis.selectList("employeeDao.getAllEmployee", vo);
	}
	
	public void insertEmployee(EmployeeVO vo) {
		mybatis.insert("employeeDao.insertEmployee",vo);
	}
	
	public void updateEmployee(EmployeeVO vo) {
		mybatis.insert("employeeDao.updateEmployee",vo);
	}
	
	public void deleteEmployee(EmployeeVO vo) {
		mybatis.insert("employeeDao.deleteEmployee",vo);
	}
	
}
