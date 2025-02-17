package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.ReplyDAO;
import jdbcboard.model.Reply;
import jdbcboard.util.ConnectionUtil;

public class ReplyDAOImpl implements ReplyDAO {
	
	private static ReplyDAOImpl replyDAOImpl = new ReplyDAOImpl();
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private ReplyDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
	
	public static ReplyDAOImpl getReplyDAOImpl() {
		return replyDAOImpl;
	}
	@Override
	public List<Reply> selectReply() {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("SELECT_REPLY");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Reply> replyList = new ArrayList<Reply>();
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setRid(rs.getInt("rid"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRregdate(rs.getTimestamp("rregdate"));
				reply.setRdelyn(rs.getString("rdelyn"));
				reply.setMid(rs.getString("mid"));
				reply.setAid(rs.getInt("aid"));
				replyList.add(reply);
			}
			return replyList;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public Reply getReply(int rid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("GET_REPLY");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rid);
			rs = pstmt.executeQuery();
			Reply reply = null;
			if (rs.next()) {
				reply = new Reply();
				reply.setRid(rs.getInt("rid"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRregdate(rs.getTimestamp("rregdate"));
				reply.setRdelyn(rs.getString("rdelyn"));
				reply.setMid(rs.getString("mid"));
				reply.setAid(rs.getInt("aid"));
			}
			return reply;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int insertReply(Reply Reply) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("INSERT_REPLY");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Reply.getRcontent());
			pstmt.setString(2, Reply.getRdelyn());
			pstmt.setString(3, Reply.getMid());
			pstmt.setInt(4, Reply.getAid());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int updateReply(Reply Reply) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("UPDATE_REPLY");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Reply.getRcontent());
			pstmt.setInt(2, Reply.getRid());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int deleteReply(int rid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("DELETE_REPLY");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rid);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
