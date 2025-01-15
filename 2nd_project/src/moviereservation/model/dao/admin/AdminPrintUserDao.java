package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminPrintUserDto;

public class AdminPrintUserDao extends Dao{
	private AdminPrintUserDao() {}
	private static AdminPrintUserDao instance = new AdminPrintUserDao();
	public static AdminPrintUserDao getInstance() {
		return instance;
	}
	public ArrayList<AdminPrintUserDto> printUser() {
		System.out.println("아무말");
		ArrayList<AdminPrintUserDto> list = new ArrayList<>();
		try {
		
		String sql = "SELECT \r\n"
				+ "	member.mname,resv.resvId,member.memberId,member.mId,movie.movieName,timeTable.movieDate,theater.theaterId,resvSeat.seatNum,resv.resvDate\r\n"
				+ "FROM resv \r\n"
				+ "JOIN member ON resv.memberId = member.memberId \r\n"
				+ "JOIN timeTable ON resv.timepk = timeTable.timepk \r\n"
				+ "JOIN movie ON timeTable.movieId = movie.movieId \r\n"
				+ "JOIN theater ON timeTable.theaterId = theater.theaterId \r\n"
				+ "JOIN resvSeat ON resv.resvId = resvSeat.resvId \r\n"
				+ "ORDER BY resv.resvDate,resv.resvId";
		System.out.println( sql );
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs);
		
		
		while(rs.next()) {
			System.out.println(rs);
			int memberId = rs.getInt("memberId");
			int resvId = rs.getInt("resvId");
			int theaterId = rs.getInt("theaterId");
			int seatNum = rs.getInt("seatNum");
			String mname = rs.getString("mname");
			String mId = rs.getString("mId");
			String movieName = rs.getString("movieName");
			String movieDate = rs.getString("movieDate");
			String resvDate =rs.getString("resvDate");
			
			AdminPrintUserDto adminPrintUserDto = new AdminPrintUserDto(
					memberId, mId,mname,movieName,movieDate,theaterId,
					seatNum, resvDate, resvId
					);
			System.out.println(adminPrintUserDto);
			list.add(adminPrintUserDto);
		}


		}catch(SQLException e) {
			System.out.println(e);
		}
		return list;
	}


}
