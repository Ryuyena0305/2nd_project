package moviereservation.controller.member;

import moviereservation.model.dao.member.MemberDao;
import moviereservation.model.dto.member.MemberDto;

public class MemberController {
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() {return instance;}
	
	public boolean signup(MemberDto memberDto) {
		boolean result = MemberDao.getInstance().signup(memberDto);
		return result;
	}
}
