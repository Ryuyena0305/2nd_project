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
	
	public ArrayList<MemberRsvDetailDto> printTheater(){
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printTheater();
		return result;
	}
	
	public ArrayList<MemberRsvDetailDto> printTheaterTime(){
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printTheaterTime();
		return result;
	}
}
