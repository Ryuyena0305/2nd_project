package moviereservation.view.admin;

import java.util.Scanner;

public class AdminMovieInfoView {
	private static AdminMovieInfoView instance = new AdminMovieInfoView();
	private AdminMovieInfoView() {}
	public static AdminMovieInfoView getInstance() {return instance;}
		public void MovieInfoView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("영화정보 관리");
		while(true) {
			System.out.println("1.영화정보 등록 2. 영화정보 수정 3. 영화정보 출력 4. 영화정보 삭제 5.뒤로가기");
			int movieInfo = scan.nextInt();
			if (movieInfo == 1) {
				System.out.println("영화정보 등록");
			}else if(movieInfo == 2) {
				System.out.println("영화정보 수정");
			}else if(movieInfo == 3) {
				System.out.println("영화정보 출력");
			}else if(movieInfo == 4) {
				System.out.println("영화정보 삭제");
			}else if(movieInfo == 5) {
				break;
			}
			
		}
	}
}
