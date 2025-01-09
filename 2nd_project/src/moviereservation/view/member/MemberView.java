package moviereservation.view.member;

import java.util.Scanner;

import moviereservation.controller.member.MemberController;
import moviereservation.model.dto.member.MemberDto;

public class MemberView {
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			int choose = scan.nextInt();
			if(choose == 1) {signup();}
			else if(choose ==2) {}
		}
	}
	
	public void signup() {
		System.out.println("아이디"); String mid = scan.next();
		System.out.println("비밀번호"); String mpw = scan.next();
		System.out.println("이름"); String mname = scan.next();
		System.out.println("생년월일"); String mbirth = scan.next();
		MemberDto memberDto = new MemberDto(mid, mpw, mname, mbirth);
		boolean result = MemberController.getInstance().signup(memberDto);
		if(result) {System.out.println("회원가입성공");}
		else {System.out.println("회원가입실패");}
		
	}
}
