package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlManager {

	public static <T> T run(String sql, CallbackInterface<T> callback) {
		Connection conn = null;// 추가
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getOracleConnection();
			System.out.println("--> " + sql);
			pstmt = conn.prepareStatement(sql);
			return callback.callbackPreparedStatement(pstmt);
		} catch (Exception e) {
			System.out.println("--> sql exception : " + e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close(); // 반환하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public interface CallbackInterface<T> {
		T callbackPreparedStatement(PreparedStatement pstmt) throws SQLException;
	}
}
