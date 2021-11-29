package model.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class EmployeeRowMapper implements RowMapper<EmployeeVO>{

	@Override
	public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeVO vo = new EmployeeVO();
		vo.setNum(rs.getInt("num"));
		vo.setEname(rs.getString("ename"));
		vo.setGrade(rs.getString("grade"));
		vo.setPhone(rs.getString("phone"));
		vo.setEmail(rs.getString("email"));
		System.out.println("vo : " + vo);
		return vo;
	}
}


@Repository
public class EmployeeDAO {
	// SQL구문 
	// C
	private final String insertEmployeeSQL = "INSERT INTO EMPLOYEE (NUM,ENAME,PHONE,GRADE,EMAIL) VALUES ((SELECT NVL(MAX(NUM),999)+1 FROM EMPLOYEE),?,?,?,?)";
	// R
	private final String getAllEmployeeListSQL = "SELECT * FROM EMPLOYEE ORDER BY ENAME ASC";
	private final String getEmployeeSQL = "SELECT * FROM EMPLOYEE WHERE NUM=?";
	// U
	private final String updateEmployeeSQL = "UPDATE EMPLOYEE SET ENAME=?, GRADE=?, PHONE=?,EMAIL=? WHERE NUM=?";
	// D
	// 직원삭제시 삭제는 pk값인 num을 통해 진행한다. 
	private final String deleteEmployeeSQL = "DELETE FROM EMPLOYEE WHERE NUM = ?";
	
	
	// JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertEmployee(EmployeeVO vo) {
		Object[] args = {vo.getEname(),vo.getPhone(),vo.getGrade(),vo.getEmail()};
		jdbcTemplate.update(insertEmployeeSQL,args);
	}
	public EmployeeVO getEmployee(EmployeeVO vo) {
		Object[] args = {vo.getNum()};
		return jdbcTemplate.queryForObject(getEmployeeSQL,new EmployeeRowMapper(),args);
	}
	public List<EmployeeVO> getAllEmployeeList(EmployeeVO vo) {
		return jdbcTemplate.query(getAllEmployeeListSQL,new EmployeeRowMapper());
	}
	public List<EmployeeVO> searchEmployeeList(EmployeeVO vo) {
		String searchEmployeeSQL ="SELECT * FROM EMPLOYEE WHERE "+ vo.getCondition() +" LIKE %'"+ vo.getKeyword()+"'% ORDER BY ENAME ASC";
		return jdbcTemplate.query(searchEmployeeSQL,new EmployeeRowMapper());
	}
	public void updateEmployee(EmployeeVO vo) {
		System.out.println("update"+vo);
		Object[] args = {vo.getEname(),vo.getGrade(),vo.getPhone(),vo.getEmail(),vo.getNum()};
		jdbcTemplate.update(updateEmployeeSQL,args);
	}
	
	public void deleteEmployee(EmployeeVO vo) {
		jdbcTemplate.update(deleteEmployeeSQL,vo.getNum());
	}

}
