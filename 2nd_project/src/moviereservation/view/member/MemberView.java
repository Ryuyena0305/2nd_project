package moviereservation.view.member;

import java.util.Scanner;

public class MemberView {
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			int choose = scan.nextInt();
			if(choose == 1) {}
			else if(choose ==2) {}
		}
	}
	
	public void signup() {
		System.out.println("아이디"); 
	}
}
