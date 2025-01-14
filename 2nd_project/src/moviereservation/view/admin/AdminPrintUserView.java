package moviereservation.view.admin;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.admin.AdminInfoController;
import moviereservation.controller.admin.AdminPrintUserController;
import moviereservation.controller.admin.AdminTheaterController;
import moviereservation.model.dto.admin.AdminDto;
import moviereservation.model.dto.admin.AdminPrintUserDto;


public class AdminPrintUserView {
	private static AdminPrintUserView instance = new AdminPrintUserView();

	private AdminPrintUserView() {
	}

	public static AdminPrintUserView getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);

	public void printUser() {
		// 아직 구현 안함 : 전체 회원 출력 or 출력할 회원의 이름 생년월일 갖고와서 그 회원을 출력
		// 만약 이름+생년월일 갖고오면 어떤 정보들을 출력할건지
		System.out.println("관리자 비밀번호를 입력하세요 : ");
		String apw = scan.next();
		AdminDto adminDto = new AdminDto();
		adminDto.setApw(apw);
		boolean result = AdminInfoController.getInstance().checkPw(adminDto);

		if (result) {
			
			ArrayList<AdminPrintUserDto> result1 = AdminPrintUserController.getInstance().printUser();
			System.out.printf("%4s %5s %6s %4s %7s %8s %3s %6s %7s\n",
					"회원번호","사용자이름","사용자아이디","영화이름","영화날짜","상영관","좌석","예약날짜","예약번호");
			for(int index=0;index<=result1.size()-1;index++) {
				AdminPrintUserDto adminPrintUserDto = result1.get(index);
				System.out.printf("%4d ",adminPrintUserDto.getMemberId());
				System.out.printf("%6s ",adminPrintUserDto.getMname());
				System.out.printf("%9s ",adminPrintUserDto.getmId());
				System.out.printf("%5s ",adminPrintUserDto.getMovieName());
				System.out.printf("%13s ",adminPrintUserDto.getMovieDate());
				System.out.printf("%4d관 ",adminPrintUserDto.getTheaterId());
				System.out.printf("%4d ",adminPrintUserDto.getSeatNum());
				System.out.printf("%11s ",adminPrintUserDto.getRevDate());
				System.out.printf("%4d\n",adminPrintUserDto.getResvId());
			}
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
	}
}
