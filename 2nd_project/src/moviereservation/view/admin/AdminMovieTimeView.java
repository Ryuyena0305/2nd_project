package moviereservation.view.admin;

import java.util.Scanner;

public class AdminMovieTimeView {
	private static AdminMovieTimeView instance = new AdminMovieTimeView();
	private AdminMovieTimeView() {}
	public static AdminMovieTimeView getInstance() {return instance;}
		public void MovieTimeView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("상영시간표 관리");
		while(true) {
			System.out.println("1. 상영시간표 등록 2. 상영시간표 수정 3. 상영시간표 출력 4. 상영시간표 삭제 5. 뒤로가기");
			int movieTime = scan.nextInt();
			if(movieTime == 1) {
				AdminMovieTimeView.getInstance().movieTimeRes();
			}else if(movieTime == 2) {
				
			}else if(movieTime == 3) {
				
			}else if(movieTime == 4) {
				
			}else if(movieTime == 5) {
				break;
			}
		}
	}
		public void movieTimeRes() {
			
		}
}