package moviereservation.model.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.member.MemberRsvDetailDto;

public class MemberRsvDetailDao extends Dao {
	private static MemberRsvDetailDao instance = new MemberRsvDetailDao();
	private MemberRsvDetailDao() {}
	public static MemberRsvDetailDao getInstance() {return instance;}
	
		public ArrayList<MemberRsvDetailDto> printMovieName( ) {
			ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			try{String sql = "select movieId, movieName from movie";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
					memberRsvDetailDto.setMovieId(rs.getInt("movieId"));
					memberRsvDetailDto.setRsvMovieName(rs.getString("movieName"));
					list.add(memberRsvDetailDto);
				}
				}catch(SQLException e) {System.out.println(e);}
			return list;
			}
		
		public ArrayList<MemberRsvDetailDto> printTheater(int movieId){
			ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			try{
				String sql = "select * from timeTable t join theater ON t.theaterId = theater.theaterId where t.movieid = ?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, movieId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					MemberRsvDetailDto memberRsvdetailDto = new MemberRsvDetailDto();
					memberRsvdetailDto.setMovieId(rs.getInt("movieId"));
					memberRsvdetailDto.setTheaterId(rs.getInt("theaterId"));
					memberRsvdetailDto.setRsvScreen(rs.getString("screen"));
					list.add(memberRsvdetailDto);
			}
			}catch(SQLException e) {System.out.println(e);}
			return list;
		}
		
		public ArrayList<MemberRsvDetailDto> printTheaterTime(int movieId){
			ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			try{
				String sql = "select timepk, movieDate, startTime, finishTime from timeTable where movieId = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, movieId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
					memberRsvDetailDto.setTimepk(rs.getInt("timepk"));
					memberRsvDetailDto.setMovieDate(rs.getString("movieDate"));
					memberRsvDetailDto.setStartTime(rs.getString("startTime"));
					memberRsvDetailDto.setFinishTime(rs.getString("finishTime"));
					list.add(memberRsvDetailDto);
				}
			}catch(SQLException e) {System.out.println(e);}
			return list;
		}
}
