/*package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SpringBoardDAO boardDAO; // alt+shift+R -> �̸� �ѹ��� ���� ����!
	
	@Override
	public void insertBoard(BoardVO vo) {
		if(vo.getId()==0) {
			throw new IllegalArgumentException("id PK : 0 �Ұ���!");
			// ��Ÿ�� ����(����ÿ� �߻�,üũ�Ǵ� ����)
		}
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
*/