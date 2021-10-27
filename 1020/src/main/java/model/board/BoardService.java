package model.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO vo); //C
	void updateBoard(BoardVO vo); //U
	void deleteBoard(BoardVO vo); //D
	BoardVO getBoard(BoardVO vo);	  // R - select one
	List<BoardVO> getBoardList(BoardVO vo); // R - select all 1
	List<BoardVO> searchBoardList(BoardVO vo);  // R - select all 2
	List<BoardVO> getBoardList(int startRow, int endRow); // R - ���������̼ǿ�
	int getBoardCnt(); // R - ���̺� ��ü �� �� �� ī���� 
	
}
