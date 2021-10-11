package model.board;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
}

// 1. extends ��ӹ޾Ƽ� ����
// 2. JdbcTemplate�� <bean>���, ����������

@Repository()
public class SpringBoardDAO extends JdbcDaoSupport{

	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="select * from board where id=?";
	private final String getBoardListSQL="select * from board order by id desc";

	// �����ͼҽ� �߰�
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate�� insert");
		getJdbcTemplate().update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate�� update");
		getJdbcTemplate().update(updateSQL,vo.getTitle(),vo.getContent(),vo.getId());

	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("jdbcTemplate�� delete");
		getJdbcTemplate().update(deleteSQL,vo.getId());
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("jdbcTemplate�� getBoardList");
		return getJdbcTemplate().query(getBoardListSQL,new BoardRowMapper());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� getBoard");
		Object[] args = { vo.getId() };
		return getJdbcTemplate().queryForObject(getBoardSQL, args, new BoardRowMapper());
	}

}
