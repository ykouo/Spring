package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setBid(rs.getInt("bid"));
		vo.setMid(rs.getString("mid"));
		vo.setTitle(rs.getString("title"));
		vo.setContent(rs.getString("content"));
		vo.setWdate(rs.getDate("wdate"));
		return vo;
	}
	
}

@Repository
public class SpringBoardDAO {
	
	// SQL��
	private final String insertBoardSQL = "INSERT INTO BOARD (BID,MID,TITLE,CONTENT) VALUES ((SELECT NVL(MAX(BID),0)+1 FROM BOARD),?,?,?)"; 
	private final String updateBoardSQL = "UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
	private final String deleteBoardSQL = "DELETE FROM BOARD WHERE BID=? AND MID=?";
	private final String selectAllBoardSQL = "SELECT * FROM BOARD ORDER BY BID DESC";
	private final String selectOneBoardSQL = "SELECT * FROM BOARD WHERE BID=?";
	private final String searchBoardSQL = "SELECT * FROM BOARD WHERE TITLE LIKE ? ORDER BY BID DESC";
	private final String getBoardCntSQL = "SELECT COUNT(*) FROM BOARD";
	private final String getBoardListSQL_TITLE="select * from board where title like '%'||?||'%' order by id desc";
	private final String getBoardListSQL_WRITER="select * from board where writer like '%'||?||'%' order by id desc";
	// jdbcTemplate �߰�
	
	// new �����ڻ���� �����̳ʰ� ���!
	// �����������̳ʰ� IoC�� ����
	// <bean> == ��ü�� ���
	// .xml�� �δ㽺���� ������ ���ϱ� ����
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// �޼��� 
	// C �Խñ� �߰�
	public void insertBoard(BoardVO vo) {
		jdbcTemplate.update(insertBoardSQL,vo.getMid(),vo.getTitle(),vo.getContent());
	}
	// U �Խñ� ����
	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(updateBoardSQL,vo.getTitle(),vo.getContent(),vo.getBid());
	}
	// D �Խñ� ����
	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(deleteBoardSQL,vo.getBid(),vo.getMid());
	}
	// R select one �Խñ� �󼼺���
	public BoardVO getBoard(BoardVO vo) {
		Object[] args = {vo.getBid()};
		return jdbcTemplate.queryForObject(selectOneBoardSQL, args,new BoardRowMapper());
	}
	// R - select all 1 �Խñ� ����Ʈ 
	public List<BoardVO> getBoardList(BoardVO vo){	
		return jdbcTemplate.query(selectAllBoardSQL,new BoardRowMapper());
	}
	// R - select all 2 �˻����
/*	public List<BoardVO> searchBoard(BoardVO vo){
		Object[] args = {"%"+vo.getTitle()+"%"};
		return jdbcTemplate.query(searchBoardSQL,args,new BoardRowMapper());
	}*/
	// �Խ��� ��ü�ۼ��� ī�����ϴ� �޼��� 
/*	public int getBoardCnt() {
		return jdbcTemplate.query(getBoardCntSQL);
	}*/
	// pagenation�� ���� getList
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		System.out.println("Spring dao�� getList");
		String getBoardPagingSQL = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.BID,A.MID,A.TITLE,A.CONTENT,A.WDATE FROM (SELECT * FROM BOARD ORDER BY BID DESC) A) WHERE RNUM BETWEEN "+startRow+" AND "+endRow;
		return jdbcTemplate.query(getBoardPagingSQL,new BoardRowMapper());
	}
	// �˻����
	public List<BoardVO> searchBoardList(BoardVO vo) {
		System.out.println("jdbcTemplate����searchBoardList");
		Object[] args= { vo.getKeyword() };
		if(vo.getCondition().equals("title")) {
			return jdbcTemplate.query(getBoardListSQL_TITLE,args,new BoardRowMapper());
		}
		else {
			return jdbcTemplate.query(getBoardListSQL_WRITER,args,new BoardRowMapper());
		}
	}

}
