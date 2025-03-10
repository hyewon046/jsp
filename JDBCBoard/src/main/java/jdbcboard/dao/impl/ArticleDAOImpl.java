package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.ArticleDAO;
import jdbcboard.model.Article;
import jdbcboard.util.ConnectionUtil;

public class ArticleDAOImpl implements ArticleDAO {
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static ArticleDAOImpl articleDAOImpl = new ArticleDAOImpl(); 
	
	private ArticleDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
	
	public static ArticleDAOImpl getArticleDAOImpl() {
		return articleDAOImpl;
	}
	
	@Override
	public List<Article> selectArticle(String searchBoard, String searchClass, String searchVal) {
		try {
			//SELECT * FROM ARTICLE WHERE ADELYN='N'
			String sql = sqlProperties.getProperty("SELECT_ARTICLE");
			
			if(searchBoard!=null && !searchBoard.equals("")) {
				sql += " AND A.BID=" + searchBoard + " ";
			}
			if (searchClass != null ) {
				if (searchClass.equals("")) {
					sql += " AND (ASUBJECT LIKE '%" + searchVal + "%' OR";
					sql += " ACONTENT LIKE '%" + searchVal + "%' OR";
					sql += " MID LIKE '%" + searchVal +"%') ";
				} else if (searchClass.equals("asubject")) {
					sql += " AND ASUBJECT LIKE '%" + searchVal + "%' ";
				} else if (searchClass.equals("acontent")) {
					sql += " AND ACONTENT LIKE '%" + searchVal + "%' ";
				} else if (searchClass.equals("mid")) {
					sql += " AND MID LIKE '%" + searchVal + "%' ";
				}
			}
			
			sql += " ORDER BY AID DESC ";
			System.out.println(sql);
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Article> articleList = new ArrayList<Article>();
			while (rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setAafcnt(rs.getInt("aafcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setBid(rs.getInt("bid"));
				article.setMid(rs.getString("mid"));
				article.setBname(rs.getString("bname"));
				articleList.add(article);
			}
			return articleList;
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
	public Article getArticle(int aid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("GET_ARTICLE");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			rs = pstmt.executeQuery();
			Article article = null;
			while (rs.next()) {
				article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setAafcnt(rs.getInt("aafcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setBid(rs.getInt("bid"));
				article.setMid(rs.getString("mid"));
				article.setBname(rs.getString("bname"));
			}
			return article;
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
	public int insertArticle(Article article) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("INSERT_ARTICLE");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getAsubject());
			pstmt.setString(2, article.getAcontent());
			pstmt.setInt(3, article.getAvcnt());
			pstmt.setString(4, article.getAdelyn());
			pstmt.setInt(5, article.getAafcnt());
			pstmt.setInt(6, article.getArcnt());
			pstmt.setInt(7, article.getBid());
			pstmt.setString(8, article.getMid());
			return pstmt.executeUpdate();
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
	public int updateArticle(Article article) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("UPDATE_ARTICLE");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getAsubject());
			pstmt.setString(2, article.getAcontent());
			pstmt.setInt(3, article.getAid());
			return pstmt.executeUpdate();
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
	public int deleteArticle(int aid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("DELETE_ARTICLE");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			return pstmt.executeUpdate();
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
	public int increaseAvcnt(int aid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = sqlProperties.getProperty("INCREASE_AVCNT");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			return pstmt.executeUpdate();
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
