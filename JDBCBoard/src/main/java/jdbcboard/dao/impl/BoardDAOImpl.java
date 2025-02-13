package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import jdbcboard.dao.BoardDAO;
import jdbcboard.model.Board;
import jdbcboard.util.ConnectionUtil;

public class BoardDAOImpl implements BoardDAO {
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader("D:/embededk/jee_workspace/JDBCBoard/src/main/webapp/WEB-INF/props/sql.properties"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
	
	@Override
	public List<Board> selectBoard() {
		return BoardDAO.super.selectBoard();
	}
	
	@Override
	public Board getBoard(int bid) {
		return BoardDAO.super.getBoard(bid);
	}
	
	@Override
	public int insertBoard(Board board) {
		return BoardDAO.super.insertBoard(board);
	}
	
	@Override
	public int updateBoard(Board board) {
		return BoardDAO.super.updateBoard(board);
	}
	
	@Override
	public int deleteBoard(int bid) {
		return BoardDAO.super.deleteBoard(bid);
	}
}
