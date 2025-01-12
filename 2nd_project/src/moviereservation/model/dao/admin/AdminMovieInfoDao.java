package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminMovieInfoDto;

public class AdminMovieInfoDao extends Dao {
    private static AdminMovieInfoDao instance = new AdminMovieInfoDao();
    private AdminMovieInfoDao() {}
    public static AdminMovieInfoDao getInstance() {
        return instance;  
    }
    public boolean movieInfoRes(AdminMovieInfoDto adminMovieInfoDto) {
		try {
		String sql = "insert into movie(movieName, runTime, movieGrade, genreId ) values (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql); 
		ps.setString(1, adminMovieInfoDto.getMovieName());
		ps.setInt(2, adminMovieInfoDto.getRunTime());
		ps.setString(3, adminMovieInfoDto.getMovieGrade());
		ps.setInt(4, adminMovieInfoDto.getGenreId());
		int count = ps.executeUpdate();
		if(count == 1) {
			return true;	
		}
		} catch(SQLException e) {
			System.out.println(e);
		}
    	return false;
    	 
    }
}

