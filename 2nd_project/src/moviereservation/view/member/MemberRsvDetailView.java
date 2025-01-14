package moviereservation.view.member;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.member.MemberRsvDetailController;
import moviereservation.model.dao.member.MemberRsvDetailDao;
import moviereservation.model.dto.member.MemberRsvDetailDto;

public class MemberRsvDetailView {
	Scanner scan = new Scanner(System.in);
	private static MemberRsvDetailView instance = new MemberRsvDetailView();
	private MemberRsvDetailView() {}
	public static MemberRsvDetailView getInstance() {return instance;}
		public void MemberRsvDetail() {
			System.out.println("1.예매하기 2.예매 확인 3.예매 취소");
			int rsvInfo = scan.nextInt();
			if( rsvInfo == 1) {
				System.out.println("예매하기");
				movieRsvRes();
			}else if (rsvInfo == 2) {
				System.out.println("예매 확인");
			}else if (rsvInfo == 3) {
				System.out.println("예매 취소");
			}
		} // f end
	
		public void movieRsvRes() {
			while(true) {
				printMovieName();
				System.out.println("영화 선택 : ");
				String rsvMovieName = scan.next();
				printTheaterTime();
				System.out.println("영화 상영 시간 선택 : ");
				String rsvTime = scan.next();
				printTheater();
				System.out.println("영화 상영관 선택 : ");
				String rsvTheater = scan.next();
				System.out.println("영화 관람 인원 수 선택 : ");
				int rsvPerson = scan.nextInt();
				System.out.println("영화 좌석 선택 : ");
				String rsvSeat = scan.next();
				
			}
				
		}
		
		public void printMovieName() {
			ArrayList<MemberRsvDetailDto> result1 = MemberRsvDetailController.getInstance().printMovieName();
			for(int index = 0; index <= result1.size()-1; index++) {
				MemberRsvDetailDto memberRsvDetailDto = result1.get(index);
				System.out.println(memberRsvDetailDto.getMovieId() + "." + memberRsvDetailDto.getRsvMovieName());
				
			}
		} // printMovieName end
		
		public void printTheater() {
			ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().printTheater();
			for(int i = 0; i <= result.size()-1; i++) {
				MemberRsvDetailDto memberRsvDetailDto = result.get(i);
				System.out.println(memberRsvDetailDto.getTheaterId() +"."+ memberRsvDetailDto.getRsvScreen());
			}
		}
		
		public void printTheaterTime() {
			ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().printTheaterTime();
			for(int i = 0; i <= result.size()-1; i++) {
				MemberRsvDetailDto memberRsvDetailDto = result.get(i);
				System.out.println(memberRsvDetailDto.getMovieDate() +"."+ memberRsvDetailDto.getStartTime() +"."+ memberRsvDetailDto.getFinishTime());
			}
		}
} // c end