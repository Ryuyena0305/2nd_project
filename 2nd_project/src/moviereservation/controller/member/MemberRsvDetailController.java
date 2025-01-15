package moviereservation.controller.member;

import java.util.ArrayList;

import moviereservation.model.dao.member.MemberRsvDetailDao;
import moviereservation.model.dto.member.MemberRsvDetailDto;

public class MemberRsvDetailController {
	private MemberRsvDetailController() {}
	private static MemberRsvDetailController instance = new MemberRsvDetailController();
	public static MemberRsvDetailController getInstance() {
		return instance;
	}
	
	public ArrayList<MemberRsvDetailDto> printMovieName(){
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printMovieName();
		return result;
	}
	
	public ArrayList<MemberRsvDetailDto> printTheater(int movieId){
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printTheater(movieId);
		return result;
	}
	
	public ArrayList<MemberRsvDetailDto> printTheaterTime(int movieId){
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printTheaterTime(movieId);
		return result;
	}
	
	//예매 취소
	public boolean rsvCan(MemberRsvDetailDto memberRsvDetailDto) {
		int loginMno = MemberController.getInstance().getLoginMno();
		int rsvId = memberRsvDetailDto.getRsvNum();
		boolean result = MemberRsvDetailDao.getInstance().rsvCheck(rsvId,loginMno);
		if(result == false) {return false;}
		boolean result2 = MemberRsvDetailDao.getInstance().rsvCan(memberRsvDetailDto);
		return result2;
	}
	
} //c end
