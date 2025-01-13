package moviereservation.controller.member;

import java.util.ArrayList;

import moviereservation.model.dao.member.MemberReviewDao;
import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewController {
	private static MemberReviewController instance = new MemberReviewController();
	private MemberReviewController() {}
	public static MemberReviewController getInstance() {return instance;}
	
	public boolean regist(MemberReviewDto memberReviewDto) {
		
		//1. 로그인 회원 번호를 DTO 대입  
		memberReviewDto.setMemberId( MemberController.getInstance().getLoginMno() );
		//2. 입력받은 영화명을 영화번호 조회하는 Dao 호출
		int mno = MemberReviewDao.getInstance().checkMovie(memberReviewDto);
		memberReviewDto.setMovieId(mno);
		
		boolean result = MemberReviewDao.getInstance().regist(memberReviewDto);
		return result;
	}
	public ArrayList<MemberReviewDto> print(){
		ArrayList<MemberReviewDto> result = MemberReviewDao.getInstance().print();
		return result;
	}
}
