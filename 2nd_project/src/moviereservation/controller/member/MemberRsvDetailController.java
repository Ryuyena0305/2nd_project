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
	   
	   public ArrayList<MemberRsvDetailDto> printTheaterTime(int movieId){
	      ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printTheaterTime(movieId);
	      return result;
	   }
	    public MemberRsvDetailDto printTheater(int timeId) {
	           return MemberRsvDetailDao.getInstance().printTheater(timeId);
	       }
	    
	   public ArrayList<MemberRsvDetailDto> getRsvSeat(MemberRsvDetailDto memberRsvDetailDto, int rsvTime) {
	      
	      return MemberRsvDetailDao.getInstance().getRsvSeat(memberRsvDetailDto,rsvTime);
	   }
	
	// 영화 예매 내역 전체 출력
	public ArrayList<MemberRsvDetailDto> printRsv(){
		int loginMno = MemberController.getInstance().getLoginMno();
		if (loginMno == 0) {
	        System.out.println("로그인되지 않은 상태입니다.");
	        return new ArrayList<>(); // 빈 리스트 반환
	    }
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printRsv(loginMno);
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
