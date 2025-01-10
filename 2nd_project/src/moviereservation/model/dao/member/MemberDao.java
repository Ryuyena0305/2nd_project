package moviereservation.model.dao.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.member.MemberDto;

public class MemberDao extends Dao{
   private static MemberDao instance = new MemberDao();
   private MemberDao() {}
   public static MemberDao getInstance() {return instance;}
   // 1. 회원가입 SQL 처리
   public boolean signup(MemberDto memberDto) {
      if(checkId(memberDto)){
         return false;
      }
      try {
      String sql = "insert into member(mid, mpw, mname, mbirth) values('"+memberDto.getMid()+"', '"+memberDto.getMpw()+"', '"+memberDto.getMname()+"', '"+memberDto.getMbirth()+"')";
      PreparedStatement ps = conn.prepareStatement(sql);
      int count = ps.executeUpdate();
      if(count == 1) {return true;} // 회원가입 성공
      }catch (Exception e) {System.out.println(e);}
      return false;
   }
   // 1-1. 회원가입 아이디 중복검사 SQL 처리
   public boolean checkId(MemberDto memberDto) {
      try {
      String sql = "select count(*) from member where mid = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, memberDto.getMid());
      ResultSet rs = ps.executeQuery();
      if(rs.next() && rs.getInt(1) > 0) {
         return true;	// 아이디가 이미 존재
      }
      }catch (Exception e) {System.out.println(e);}
      return false;		// 아이디가 존재하지 않음
   }
   // 2. 로그인 SQL 처리
   public int login(MemberDto memberDto) {
	   try {
	   String sql = "select memberId from member where mid = ? and mpw = ?";
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ps.setString(1, memberDto.getMid());
	   ps.setString(2, memberDto.getMpw());
	   ResultSet rs = ps.executeQuery();
	   if(rs.next()) {
		   int memberId = rs.getInt("memberId");
		   return memberId;
	   }
	   }catch (Exception e) {System.out.println(e);}
	   return 0;
   }
   // 3. 회원탈퇴 SQL 처리
   public void delete(int loginMno) {
	   try {
	   String sql = "delete from member where memberId = ?";
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ps.setInt(1, loginMno);
	   int count = ps.executeUpdate();
	   if(count > 0) {
		   System.out.println("회원 탈퇴 성공");
	   }
	   else {
		   System.out.println("회원탈퇴 실패");
	   }
	   }catch (Exception e) {System.out.println(e);}
	   return;
   }
   // 3-2 비밀번호 확인 SQL 처리
   public boolean checkPw(MemberDto memberDto) {
	   try {
	   String sql = "select mpw from member where memberId = ?";
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ps.setInt(1, memberDto.getMemberId());
	   ResultSet rs = ps.executeQuery();
	   if(rs.next()) {
		   String pw = rs.getString("mpw");
		   
		   return pw.equals(memberDto.getMpw());
	   }
	   }catch (Exception e) {System.out.println(e);}
	   return false;
   }
   // 4. 회원수정 SQL 처리
   public boolean update(MemberDto memberDto) {
   try {
	   String sql = "update member set mpw = ?, mname = ?, mbirth = ? where memberId = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
   ps.setString(1, memberDto.getMpw());
   ps.setString(2, memberDto.getMname());
   ps.setString(3, memberDto.getMbirth());
   ps.setInt(4, memberDto.getMemberId());
   int count = ps.executeUpdate();
   if(count == 1) {return true;}
   }catch (Exception e) {System.out.println(e);}
   return false;
   
   }
}
