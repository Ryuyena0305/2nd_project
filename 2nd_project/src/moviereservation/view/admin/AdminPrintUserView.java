package moviereservation.view.admin;

import java.util.Scanner;

import moviereservation.controller.admin.AdminInfoController;
import moviereservation.model.dto.admin.AdminDto;

public class AdminPrintUserView {
	private static AdminPrintUserView instance = new AdminPrintUserView();
	private AdminPrintUserView() {}
	public static AdminPrintUserView getInstance() {
		return instance;
	}
	Scanner scan = new Scanner(System.in);
	
	public void PrintUser() {
		//아직 구현 안함 : 전체 회원 출력 or 출력할 회원의 이름 생년월일 갖고와서 그 회원을 출력
		//만약 이름+생년월일 갖고오면 어떤 정보들을 출력할건지
		System.out.println("관리자 비밀번호를 입력하세요 : "); String apw = scan.next();
		AdminDto adminDto = new AdminDto();
		adminDto.setApw(apw);
		boolean result = AdminInfoController.getInstance().checkPw(adminDto);
		if(result) {
			System.out.println("출력할 회원 이름 : "); 
			System.out.println("출력할 회원 생년월일 : "); 
		}
		else {System.out.println("비밀번호가 일치하지 않습니다.");}
	}
}

