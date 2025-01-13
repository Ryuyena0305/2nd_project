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
	
		public ArrayList<MemberRsvDetailDto> movieRsv(MemberRsvDetailDto memberRsvDeatilDto) {
			ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			
			try{String sql = "select movieId from movie";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
					memberRsvDeatilDto.setRsvMovieName(rs.getString("movieId"));
					list.add(memberRsvDetailDto);
					
				}
				}catch(SQLException e) {System.out.println(e);}
			return list;		}
		public ArrayList<MemberRsvDetailDto> movieRsv() {
			// TODO Auto-generated method stub
			return null;
		}
	
}
