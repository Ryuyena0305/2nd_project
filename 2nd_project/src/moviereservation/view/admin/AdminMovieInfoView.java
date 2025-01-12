package moviereservation.view.admin;

import java.util.Scanner;

import moviereservation.model.dao.admin.AdminMovieInfoDao;
import moviereservation.model.dto.admin.AdminMovieInfoDto;

public class AdminMovieInfoView {
	Scanner scan = new Scanner(System.in);
	private static AdminMovieInfoView instance = new AdminMovieInfoView();
	private AdminMovieInfoView() {}
	public static AdminMovieInfoView getInstance() {return instance;}
		public void MovieInfoView() {
		System.out.println("영화정보 관리");
		while(true) {
			System.out.println("1.영화정보 등록 2. 영화정보 수정 3. 영화정보 출력 4. 영화정보 삭제 5.뒤로가기");
			int movieInfo = scan.nextInt();
			if (movieInfo == 1) {
				System.out.println("영화정보 등록");
				movieInfoRes();
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
		public void movieInfoRes() {
			System.out.println("영화이름 : ");
			String movieName = scan.next(); 
			System.out.println("런닝타임 : ");
			int runTime = scan.nextInt(); 
			System.out.println("관람 등급 :");
			String movieGrade = scan.next();
			System.out.println("영화장르 번호 : ");
			int genreId = scan.nextInt();
			AdminMovieInfoDto adminMovieInfoDto = new AdminMovieInfoDto(movieName, runTime, movieGrade, genreId);
			boolean result = AdminMovieInfoDao.getInstance().movieInfoRes(adminMovieInfoDto);
			if(result) {
				System.out.println("등록 성공");
			}else {
				System.out.println("등록 실패");
			}
		}
}
