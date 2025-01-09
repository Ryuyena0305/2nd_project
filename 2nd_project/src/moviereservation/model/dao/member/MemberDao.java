package moviereservation.model.dao.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.member.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return instance;}
	
	public boolean signup(MemberDto memberDto) {
		if(checkId(memberDto)){
			return false;
		}
		try {
		String sql = "insert into member(mid, mpw, mname, mphone) values('"+memberDto.getMid()+"', '"+memberDto.getMpw()+"', '"+memberDto.getMname()+"', '"+memberDto.getMbirth()+"')";
		PreparedStatement ps = conn.prepareStatement(sql);
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public boolean checkId(MemberDto memberDto) {
		String mid = memberDto.getMid();
		try {
		String sql = "select count(*) from member where mid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberDto.getMid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}
