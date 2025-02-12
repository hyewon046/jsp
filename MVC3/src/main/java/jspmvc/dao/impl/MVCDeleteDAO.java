package jspmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jspmvc.dao.MVCAbstractDAO;
import jspmvc.model.MVCDTO;
import jspmvc.util.ConnectionUtil;

public class MVCDeleteDAO extends MVCAbstractDAO{
	
	@Override
	public int delete(int sid) {
		
		String sql = " delete jspmvc where sid = " + sid;
		
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}	finally {
			try {
				connUtil.closeConnection(conn);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	
	}
}
