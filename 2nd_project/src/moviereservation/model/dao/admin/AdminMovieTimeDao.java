package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminMovieTimeDto;

public class AdminMovieTimeDao extends Dao {
		private static AdminMovieTimeDao instance = new AdminMovieTimeDao();
		private AdminMovieTimeDao() {}
		public static AdminMovieTimeDao getInstance() {
			return instance;
		}
		public boolean movieTimeRes(AdminMovieTimeDto adminMovieTimeDto) {
			try {
			String sql = "insert into timeTable(startTime, finishTime, movieDate)";
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = ps.executeUpdate();
			if (count == 1 ) {return true;}
			} catch(SQLException e) {
				System.out.println(e);
			}
			return false;
		}
}



