package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.an.app.common.LogAdvice;
import com.an.app.common.LogPlusAdvice;

// ������ OOP ���ü�迡�� AOP�� ���� �Ѱ� 
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
	/*	if(vo.getId()==0) {
			throw new IllegalArgumentException("id PK : 0 �Ұ���!");
			// ��Ÿ�ӿ���(����ÿ� �߻�, üũ�Ǵ� ����)
		}
	*/	
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
