package moviereservation.view.member;

import java.util.Scanner;

public class MemberResvView {
	private static MemberResvView instance = new MemberResvView();
	private MemberResvView() {}
	public static MemberResvView getInstance() {return instance;}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("====메뉴 선택====");
		while(true) {
			System.out.println("1.예매등록 2.리뷰 3.예매확인 4.예매삭제 5.회원정보 수정 6.회원탈퇴 7.로그아웃");
			int choose = scan.nextInt();
			if (choose == 1) {}
			else if(choose == 2) {}
			else if(choose == 3) {}
			else if(choose == 4) {}
			else if(choose == 5) {MemberView.getInstance().update();}
			else if(choose == 6) {MemberView.getInstance().delete();}
			else if(choose == 7) {MemberView.getInstance().logout(); break;}
		}
	}
}
