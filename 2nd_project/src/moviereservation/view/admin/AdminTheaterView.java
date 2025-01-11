package moviereservation.view.admin;

import java.util.Scanner;

import moviereservation.controller.admin.AdminTheaterController;
import moviereservation.model.dto.admin.AdminTheaterDto;

public class AdminTheaterView {
	private static AdminTheaterView instance = new AdminTheaterView();
	private AdminTheaterView() {}
	public static AdminTheaterView getInstance() {
		return instance;
	}
	Scanner scan = new Scanner(System.in);
	public void TheaterView() {
		System.out.println("영화상영관 관리");
		while(true) {
			System.out.println("1. 상영관 정보 등록 ");
			System.out.println("2. 상영관 정보 출력 ");
			System.out.println("3. 상영관 정보 수정 ");
			System.out.println("4. 상영관 정보 삭제 ");
			System.out.println("5. 뒤로가기 ");
			int theaterInfo = scan.nextInt();
			if(theaterInfo==1) {
				System.out.println("상영관 정보 등록");
			}else if(theaterInfo==2) {
				System.out.println("상영관 정보 출력 ");
			}else if(theaterInfo==3) {
				System.out.println("상영관 정보 수정 ");
			}else if(theaterInfo==4) {
				System.out.println("상영관 정보 삭제");
			}else if(theaterInfo==5) {
				break;
			}
			else {
				System.out.println("숫자로 다시 입력하세요.");
			}
		}
		
	}
	public void addTheater() {
		System.out.println("상영관 번호 : "); int Tid = scan.nextInt();
		System.out.println("전체 좌석 수 : "); int Tseat = scan.nextInt();
		System.out.println("스크린 : "); String Tscreen =scan.next();
		AdminTheaterDto adminTheaterDto = new AdminTheaterDto();
		boolean result = AdminTheaterController.getInstance().addTheater();
		if(result) {System.out.println("[ 상영관 정보등록 성공 ]");}
		else {System.out.println("[ 상영관 정보등록 실패 ]");}
	}
	public void updateTheater() {
		
	}
	public void showAllTheaters() {
	
	}
	public void deleteTheater() {
	
	}
	public void AdminTheatermenu() {
		
		
	}

}
