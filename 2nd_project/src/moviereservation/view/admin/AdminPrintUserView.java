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
			System.out.printf("%3s %7s %5s %8s %10s %3s %3s %8s\n",
					"회원번호","사용자이름","사용자아이디","영화이름","영화날짜","상영관","좌석","예약날짜");
			
			ArrayList<AdminPrintUserDto> result1 = AdminPrintUserController.getInstance().printUser();
			System.out.println(result1);
			for (int index = 0; index <= result1.size() - 1; index++) {
				AdminPrintUserDto adminPrintUserDto = result1.get(index);
				System.out.print(adminPrintUserDto.getMemberId() + "\t");
				System.out.print(adminPrintUserDto.getmId() + "\t");
				System.out.print(adminPrintUserDto.getMname()+"\t");
				System.out.print(adminPrintUserDto.getMovieName()+"\t");
				System.out.print(adminPrintUserDto.getMovieDate()+"\t");
				System.out.print(adminPrintUserDto.getTheaterId()+"관\t");
				System.out.print(adminPrintUserDto.getSeatNum()+"번\t");
				System.out.print(adminPrintUserDto.getRevDate()+"\t");
				
			}
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
	}
}
