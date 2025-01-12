package moviereservation.view.admin;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.admin.AdminTheaterController;
import moviereservation.model.dao.admin.AdminTheaterDao;
import moviereservation.model.dto.admin.AdminDto;
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
				addTheater();
			}else if(theaterInfo==2) {
				System.out.println("상영관 정보 출력 ");
				showAllTheaters();
			}else if(theaterInfo==3) {
				System.out.println("상영관 정보 수정 ");
				findupdateTheater();
			}else if(theaterInfo==4) {
				System.out.println("상영관 정보 삭제");
				finddeleteTheater();
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

	public void showAllTheaters() {
		System.out.println("1. 상영관 간결한 정보 출력");
		System.out.println("2. 상영관 정보와 배치가 포함된 상세 정보 출력");
		int theaterSeat = scan.nextInt();
		if(theaterSeat==1) {
			System.out.println("1. 상영관 간결한 정보 출력");
			printBasicTheater();
			
		}else if(theaterSeat==2) {
			System.out.println("2. 상영관 정보와 배치가 포함된 상세 정보 출력");
			printDetailTheater();
		}else {
			System.out.println("1 2 중 선택하세요");
		}

	}
	
	public void updateTheater(AdminTheaterDto adminTheaterDto) {
			System.out.println("수정할 전체 좌석 수 : "); int Tseat = scan.nextInt();
			System.out.println("수정할 스크린(상영관 종류) : " ); String Tscreen = scan.next();
			adminTheaterDto.setTseat(Tseat); adminTheaterDto.setTscreen(Tscreen);
			boolean result1 = AdminTheaterController.getInstance().updateTheater(adminTheaterDto);
			if(result1) {
				System.out.println("상영관 정보 수정완료");
			}
			else {System.out.println("상영관 정보 수정실패");}
		}
	
	
	public void findupdateTheater() {
		System.out.println("수정할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterDto result = AdminTheaterController.getInstance().finddeleteTheater(Tid);
		if(result!=null)
		{
			updateTheater(result);
		}else {
			System.out.println("동일한 상영관 정보가 없습니다.");
		}
	}
	public void deleteTheater(AdminTheaterDto adminTheaterDto) {
		System.out.println("삭제할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterController.getInstance().deleteTheater(adminTheaterDto);
		System.out.println("상영관 정보가 삭제되었습니다.");
	}
	
	public void finddeleteTheater() {
		System.out.println("삭제할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterDto result = AdminTheaterController.getInstance().finddeleteTheater(Tid);
		if(result!=null)
		{
			deleteTheater(result);
		}else {
			System.out.println("동일한 상영관 정보가 없습니다.");
		}
	}
	
	public void printBasicTheater() {
		ArrayList<AdminTheaterDto>result = AdminTheaterController.getInstance().printBasicTheater();
		for(int index=0;index<=result.size()-1;index++) {
			AdminTheaterDto adminTheaterDto = result.get(index);
			System.out.println("상영관번호\t전체좌석수\t스크린");
			System.out.print(adminTheaterDto.getTid()+"관\t");
			System.out.print(adminTheaterDto.getTseat()+"\t");
			System.out.print(adminTheaterDto.getTscreen()+"\t");
		}
		
	}
	
	public void printDetailTheater() {
		System.out.println("출력할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterDto result = AdminTheaterController.getInstance().printDetailTheater(Tid);
		
		if(result !=null) {
			
			System.out.println("상영관번호\t전체좌석수\t스크린");
			System.out.print(result.getTid()+"관\t");
			System.out.print(result.getTseat()+"\t");
			System.out.print(result.getTscreen()+"\t");
		}

	
	}

}
