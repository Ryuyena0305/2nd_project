package moviereservation.view.admin;

import java.util.Scanner;

public class AdminView {
	private static AdminView instance = new AdminView();
	private AdminView() {}
	public static AdminView getInstance() {return instance;}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("1. 영화정보 관리\r\n"
					+ "2. 사용자 계정출력\r\n"
					+ "3. 상영시간표 관리\r\n"
					+ "4.영화 상영관 관리\r\n"
					+ "5. 회원정보 수정\r\n"
					+ "6. 회원정보 삭제\r\n"
					+ "7. 로그아웃");
			int adminChoose = scan.nextInt();
			if (adminChoose == 1) {
				AdminMovieInfoView.getInstance().MovieInfoView();
			}else if(adminChoose == 2) {
				
			}else if(adminChoose == 3) {
				AdminMovieTimeView.getInstance().MovieTimeView();
			}else if(adminChoose == 4) {
				
			}else if(adminChoose == 5) {
				
			}else if(adminChoose == 6) {
				
			}else if(adminChoose == 7) {
				
			}
			
		}
	}
	
	
}
