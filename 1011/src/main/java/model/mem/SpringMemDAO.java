package model.mem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


class MemRowMapper implements RowMapper<MemVO>{

	@Override
	public MemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemVO data=new MemVO();
		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}
@Repository
public class SpringMemDAO extends JdbcDaoSupport{
	
	private final String insertSQL="INSERT INTO MEM (ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
	private final String updateSQL="UPDATE MEM SET NAME=?, PASSWORD=? where ID=?";
	private final String deleteSQL="DELETE MEM WHERE ID=?";
	private final String getMemSQL="SELECT * FROM MEM WHERE ID=? AND PASSWORD=?";
	private final String getMemListSQL="SELECT * FROM MEM";
	

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertMem(MemVO vo) {
		System.out.println("jdbcTemplate Mem로 insert");
		//insertSQL="INSERT INTO MEM (ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
		jdbcTemplate.update(insertSQL,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
	public void updateMem(MemVO vo) {
		System.out.println("jdbcTemplate Mem로 update");
		//updateSQL="UPDATE MEM SET NAME=?, PASSWORD=? where ID=?";
		jdbcTemplate.update(updateSQL,vo.getName(),vo.getPassword(),vo.getId());

	}
	public void deleteMem(MemVO vo) {
		System.out.println("dao로 delete");
		//deleteSQL="DELETE MEM WHERE ID=?";
		jdbcTemplate.update(deleteSQL,vo.getId());

	}
	public List<MemVO> getMemList(MemVO vo) {
		System.out.println("jdbcTemplate Mem로 getList");
		// getBoardListSQL="SELECT * FROM MEM";
		return jdbcTemplate.query(getMemListSQL,new MemRowMapper());
	}
	public MemVO getMem(MemVO vo) {
		System.out.println("jdbcTemplate Mem로 get");
		Object[] args = {vo.getId(),vo.getPassword()};
		// getMemSQL="SELECT * FROM MEM WHERE ID=? AND PASSWORD=?";
		return jdbcTemplate.queryForObject(getMemSQL, args,new MemRowMapper());
	}
}
