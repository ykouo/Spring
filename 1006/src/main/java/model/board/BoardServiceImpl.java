package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.an.app.common.LogAdvice;
import com.an.app.common.LogPlusAdvice;

// 기존의 OOP 언어체계에서 AOP가 갖는 한계 
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	//private LogAdvice logAdvice;
	//private LogPlusAdvice logPlusAdvice;
/*	public BoardServiceImpl() {
		this.logPlusAdvice=new LogPlusAdvice();
	}*/
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);		
	}
	@Override
	public void updateBoard(BoardVO vo) {		
		boardDAO.updateBoard(vo);
	}
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}	
}
