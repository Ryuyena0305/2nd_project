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
		ArrayList<AdminPrintUserDto> list = new ArrayList<>();
		try {
			String sql = "SELECT memberId,mid AS mId,mname,movieName,movieDate,theaterId,seatNum,resvDate AS revDate\r\n"
					+ "FROM resv JOIN member ON resv.memberId=member.memberId JOIN timeTable ON resv.timepk=timeTable.timepk JOIN movie ON timeTable.movieId=movie.movieId JOIN theater ON timeTable.theaterId=theater.theaterId JOIN resvSeat ON resv.resvId=resvSeat.resvId\r\n"
					+ "ORDER BY resvDate,memberId;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				int tid = rs.getInt("theaterId");
//				int tseat = rs.getInt("seat");
//				String tscreen = rs.getString("screen");
				int memberId= rs.getInt("memberId");
				String mId=rs.getString("mId");
				String mname=rs.getString("mname");
				String movieName=rs.getString("movieName");
				String movieDate=rs.getString("movieDate");
				int theaterId=rs.getInt("theaterId");
				String seatNum=rs.getString("seatNum");
				String resvDate=rs.getString("resvDate");

				AdminPrintUserDto adminPrintUserDto = new AdminPrintUserDto(
						memberId,mId,mname,movieName,movieDate,theaterId,seatNum,resvDate);
				list.add(adminPrintUserDto);
			} // w e
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
