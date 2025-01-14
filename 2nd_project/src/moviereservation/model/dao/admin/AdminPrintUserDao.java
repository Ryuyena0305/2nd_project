package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminPrintUserDto;

public class AdminPrintUserDao extends Dao {
	private AdminPrintUserDao() {
	}

	private static AdminPrintUserDao instance = new AdminPrintUserDao();

	public static AdminPrintUserDao getInstance() {
		return instance;
	}

	public ArrayList<AdminPrintUserDto> printUser() {
		ArrayList<AdminPrintUserDto> list = new ArrayList<AdminPrintUserDto>();
		
		try {
			
			String sql = "SELECT member.mname,resv.resvId,member.mId,movie.movieName,timeTable.movieDate,theater.theaterId,resvSeat.seatNum,resv.resvDate "
					+ "FROM resv JOIN member ON resv.memberId = member.memberId JOIN timeTable ON resv.timepk = timeTable.timepk JOIN movie ON timeTable.movieId = movie.movieId JOIN theater ON timeTable.theaterId = theater.theaterId JOIN resvSeat ON resv.resvId = resvSeat.resvId ORDER BY resv.resvDate,resv.resvId";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int resvId= rs.getInt("resv.resvId");
				String resvDate=rs.getString("resv.resvDate");

				AdminPrintUserDto adminPrintUserDto = new AdminPrintUserDto(resvId,resvDate);
				adminPrintUserDto.setMemberId(rs.getInt("memberId"));
				adminPrintUserDto.setmId(rs.getString("mId"));
				adminPrintUserDto.setMname(rs.getString("mname"));
				adminPrintUserDto.setMovieName(rs.getString("movieName"));
				adminPrintUserDto.setMovieDate(rs.getString("movieDate"));
				adminPrintUserDto.setTheaterId(rs.getInt("TheaterId"));
				adminPrintUserDto.setSeatNum(rs.getInt("seatNum"));
				list.add(adminPrintUserDto);
				System.out.println(adminPrintUserDto);
			} // w e
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(list);
		return list;
		
	}

}
