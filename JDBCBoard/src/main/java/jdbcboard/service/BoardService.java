package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Board;

public interface BoardService {
	
	default List<Board> selectBoard() { return null; }
	
	default Board getBoard(int bid) { return null; }
	
	default int insertBoard(Board board) {return 0;}
	
	default int updateBoard(Board board) {return 0;}
	
	default int deleteBoard(int bid) {return 0;}

}
