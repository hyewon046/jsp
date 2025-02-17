package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.MemberDAO;
import jdbcboard.model.Member;
import jdbcboard.util.ConnectionUtil;

public class MemberDAOImpl implements MemberDAO{
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<Member> list = null;
	
	//singleton패턴
	//private static 객체 생성 - private 생성자 생성 - public static으로 가져갈 수있는거 하나 만들고 private 객체 리턴
	
	private static MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
	
	private MemberDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
	
	public static MemberDAOImpl getMemberDAOImpl() {
		return memberDAOImpl;
	}
			
	@Override
	public List<Member> selectMember() {
		String selectSQL = sqlProperties.getProperty("SELECT_MEMBER");
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			if (rs!=null) {
				list = new ArrayList<Member>();
				while(rs.next()) {
					Member mem = new Member();
					mem.setMid(rs.getString("mid"));
					mem.setMname(rs.getString("mname"));
					mem.setMalias(rs.getString("malias"));
					mem.setMpass(rs.getString("mpass"));
					mem.setMemail(rs.getString("memail"));
					mem.setMcp(rs.getString("mcp"));
					mem.setMdelyn(rs.getString("mdelyn"));
					list.add(mem);
				}
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public Member getMember(String mid) {
		String getSQL = sqlProperties.getProperty("GET_MEMBER");
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(getSQL);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			Member mem = null;
			if (rs!=null && rs.next()) {
				mem = new Member();
				mem.setMid(rs.getString("mid"));
				mem.setMname(rs.getString("mname"));
				mem.setMalias(rs.getString("malias"));
				mem.setMpass(rs.getString("mpass"));
				mem.setMemail(rs.getString("memail"));
				mem.setMcp(rs.getString("mcp"));
				mem.setMdelyn(rs.getString("mdelyn"));
			} return mem;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int insertMember(Member member) {
		String insertSQL = sqlProperties.getProperty("INSERT_MEMBER");
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMalias());
			pstmt.setString(4, member.getMpass());
			pstmt.setString(5, member.getMemail());
			pstmt.setString(6, member.getMcp());
			pstmt.setString(7, "N");
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int updateMember(Member member) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("UPDATE_MEMBER"));
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMalias());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMcp());
			pstmt.setString(5, member.getMid());
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int deleteMember(String mid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("DELETE_MEMBER"));
			pstmt.setString(1, mid);
			return pstmt.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
}
