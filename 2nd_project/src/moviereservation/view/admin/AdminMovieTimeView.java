package moviereservation.view.admin;

import java.util.Scanner;

import moviereservation.model.dto.admin.AdminMovieTimeDto;

public class AdminMovieTimeView {
	Scanner scan = new Scanner(System.in);
	private static AdminMovieTimeView instance = new AdminMovieTimeView();
	private AdminMovieTimeView() {}
	public static AdminMovieTimeView getInstance() {return instance;}
		public void MovieTimeView() {
		System.out.println("상영시간표 관리");
		while(true) {
			System.out.println("1. 상영시간표 등록 2. 상영시간표 수정 3. 상영시간표 출력 4. 상영시간표 삭제 5. 뒤로가기");
			int movieTime = scan.nextInt();
			if(movieTime == 1) {
				System.out.println("상영시간표 등록");
				movieTimeRes();
			}else if(movieTime == 2) {
				System.out.println("상영시간표 수정");
			}else if(movieTime == 3) {
				System.out.println("상영시간표 출력");
			}else if(movieTime == 4) {
				System.out.println("상영시간표 삭제");
			}else if(movieTime == 5) {
				break;
			}
		}
	}
		public void movieTimeRes() {
			System.out.println("시작시간입력");
			String startTime = scan.next(); 
			AdminMovieTimeDto adminMovieTimeDto = new AdminMovieTimeDto();
			
			//boolean result = AdminMovieTimeController.getInstance().movieTimeRes();
			
		}
		
}