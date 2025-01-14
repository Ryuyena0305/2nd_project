package moviereservation.model.dao.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;

import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewDao extends Dao{
	private static MemberReviewDao instance = new MemberReviewDao();
	private MemberReviewDao() {}
	public static MemberReviewDao getInstance() {return instance;}
	// 영화 확인 SQL 처리 메소드
	public int checkMovie(MemberReviewDto memberReviewDto) {
		int movieId = -1;
		try {
		String sql = "select movieId from movie where movieName = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberReviewDto.getMovieName());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			movieId = rs.getInt("movieId");
		}
		}catch (Exception e) {System.out.println(e);}
		return movieId;
	}
	// 1. 리뷰 등록 SQL 처리 메소드
	public boolean regist(MemberReviewDto memberReviewDto) {
		System.out.println(memberReviewDto);
		try {
		String sql = "insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberReviewDto.getReviewTitle());
		ps.setString(2, memberReviewDto.getReviewContent());
		ps.setInt(3, memberReviewDto.getReviewRating());
		ps.setString(4, memberReviewDto.getReviewDate());
		ps.setInt(5, memberReviewDto.getMemberId());
		ps.setInt(6, memberReviewDto.getMovieId());
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 리뷰 전체 조회 SQL 처리 메소드
	public ArrayList<MemberReviewDto> print(){
		ArrayList<MemberReviewDto> list = new ArrayList<>();
		try {
		String sql = "select * from movieReview as mr inner join movie as m on mr.movieId = m.movieId"
				+ " inner join member as mm on mr.memberId = mm.memberId";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int reviewId = rs.getInt("reviewId");
			String movieName = rs.getString("movieName");
			String reviewTitle = rs.getString("reviewTitle");
			String reviewContent = rs.getString("reviewContent");
			int reviewRating = rs.getInt("reviewRating");
			String reviewDate = rs.getString("reviewDate");
			MemberReviewDto memberReviewDto = new MemberReviewDto(reviewId, movieName, reviewTitle, reviewRating, reviewContent,  reviewDate);
			memberReviewDto.setMid(rs.getString("mid"));
			list.add(memberReviewDto);
		}
		
		}catch (SQLException e) {System.out.println(e);}
		return list;
	}
	// 내가 쓴 리뷰 확인 SQL 처리 메소드
	public boolean reviewCheck(int reviewId, int memberId) {
		try {
		String sql = "select * from movieReview where reviewId = ? and memberId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reviewId);
		ps.setInt(2, memberId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 3. 리뷰 수정 SQL 처리 메소드
	public boolean update(MemberReviewDto memberReviewDto) {
		try {
		String sql = "update movieReview set reviewTitle = ?, reviewContent = ?, reviewRating = ? where reviewId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberReviewDto.getReviewTitle());
		ps.setString(2, memberReviewDto.getReviewContent());
		ps.setInt(3, memberReviewDto.getReviewRating());
		ps.setInt(4, memberReviewDto.getReviewId());
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 5. 리뷰 삭제 SQL 처리 메소드
	public boolean delete(MemberReviewDto memberReviewDto) {
		try {
		String sql = "delete from movieReview where reviewId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, memberReviewDto.getReviewId());
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}
