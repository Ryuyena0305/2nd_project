package moviereservation.model.dao.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;

import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewDao extends Dao{
	private static MemberReviewDao instance = new MemberReviewDao();
	private MemberReviewDao() {}
	public static MemberReviewDao getInstance() {return instance;}
	
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
	public ArrayList<MemberReviewDto> print(){
		ArrayList<MemberReviewDto> list = new ArrayList<>();
		try {
		String sql = "select mr.reviewId, m.movieName, mr.reviewTitle, mr.reviewContent, mr.reviewRating, mr.reviewDate from movieReview as mr inner join movie as m on mr.movieId = m.movieId";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int reviewId = rs.getInt("reviewId");
			String movieName = rs.getString("movieName");
			String reviewTitle = rs.getString("reviewTitle");
			String reviewContent = rs.getString("reviewContent");
			int reviewRating = rs.getInt("reviewRating");
			String reviewDate = rs.getString("reviewDate");
			MemberReviewDto memberReviewDto = new MemberReviewDto(reviewId, movieName, reviewTitle, reviewRating, reviewContent, reviewDate);
			list.add(memberReviewDto);
		}
		
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
}
