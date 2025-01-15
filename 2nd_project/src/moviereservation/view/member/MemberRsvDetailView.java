package moviereservation.view.member;


import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.PrintServiceAttribute;

import moviereservation.controller.member.MemberRsvDetailController;

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
				rsvCan();
			}
		} // f end
	
		public void movieRsvRes() {
			while(true) {
				printMovieName();
				System.out.println("영화 선택 : ");
				int rsvMovieName = scan.nextInt();
				printTheaterTime(rsvMovieName);
				System.out.println("영화 상영 시간 선택 : ");
				int rsvTime = scan.nextInt();
				printTheater(rsvMovieName);
				System.out.println("영화 상영관 선택 : ");
				int rsvTheater = scan.nextInt();
				System.out.println("영화 관람 인원 수 선택 : ");
				int rsvPerson = scan.nextInt();
				System.out.println("영화 좌석 선택 : ");
				//printSeat();
				int rsvSeat = scan.nextInt();
				
			}
		}
		//영화 선택
		public void printMovieName() {
			ArrayList<MemberRsvDetailDto> result1 = MemberRsvDetailController.getInstance().printMovieName();
			for(int index = 0; index <= result1.size()-1; index++) {
				MemberRsvDetailDto memberRsvDetailDto = result1.get(index);
				System.out.println(memberRsvDetailDto.getMovieId() + "." + memberRsvDetailDto.getRsvMovieName());
				
			}
		} // printMovieName end
		
		//영화 상영관 선택
		public void printTheater(int movieId) {
			ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().printTheater(movieId);
			for(int i = 0; i <= result.size()-1; i++) {
				MemberRsvDetailDto memberRsvDetailDto = result.get(i);
				System.out.println(memberRsvDetailDto.getTheaterId() +"."+ memberRsvDetailDto.getRsvScreen());
			}
		}
		
		//영화 상영 시간 선택
		public void printTheaterTime(int movieId) {
			ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().printTheaterTime(movieId);
			for(int i = 0; i <= result.size()-1; i++) {
				MemberRsvDetailDto memberRsvDetailDto = result.get(i);
				System.out.println("상영번호 / 상영날짜 / 시작시간 / 종료시간");
				System.out.println(memberRsvDetailDto.getTimepk() +"."+ memberRsvDetailDto.getMovieDate() +" / "+ memberRsvDetailDto.getStartTime() +" / "+ memberRsvDetailDto.getFinishTime());
			}
		}
		
		//영화 좌석 출력
//		   public void printDetailTheater(MemberRsvDetailDto memberRsvDetailDto) {
//
//			      MemberRsvDetailDto result = MemberRsvDetailController.getInstance().printDetailTheater(memberRsvDetailDto);
//			   
//			      if(result !=null) {
//			         System.out.print("전체좌석수\t스크린\n");
//			         System.out.print(result.getTotalSeat()+"석\t");
//			         System.out.print(result.getRsvScreen()+"\n");
//			         System.out.print("--------------SCREEN--------------"+"\n");
//			         System.out.printf("  %2d %2d %2d %2d %2d %2d %2d %2d %2d %3d\n",1,2,3,4,5,6,7,8,9,10);
//			          int rows = result.getTotalSeat() / 10 ;  // 전체 좌석을 10으로 나누어서 행 수 구하기
//			             int remainSeat = result.getTotalSeat() % 10;  // 나머지 좌석 처리
//			             
//			             // 행 출력
//			             for (int row = 0; row <= rows-1; row++) {  // 각 행에 대해
//			                 System.out.printf("%2d",row);  // 행 번호 출력
//			                 for (int col = 1; col <= 10; col++) {  // 각 행에 대해 10개의 "□" 출력
//			                     System.out.printf("%2s ","□");
//			                 }
//			                 System.out.println();
//			             }
//			             if (remainSeat > 0) {
//			                 System.out.printf("%2d",rows);  // 마지막 행 번호 출력
//			                 for (int i = 1; i <= remainSeat; i++) {
//			                     System.out.printf("%2s ","□");
//			                 }
//			                 System.out.println();  
//			             }
//			      }
//			   }
			   
			
		//영화 좌석 선택
		   
		   
		// 영화 예매 내역 출력
		   public void rsvContent() {
			
		}
		// 영화 예매 취소
		   public void rsvCan() {
			   System.out.println("취소할 예매 번호");
			   int rsvNum = scan.nextInt();
			   MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
			   memberRsvDetailDto.setRsvNum(rsvNum);
			   boolean result = MemberRsvDetailController.getInstance().rsvCan(memberRsvDetailDto);
			   if(result) {System.out.println("취소 성공");}
			   else {System.out.println("취소 실패");}
			
		}
		
		 
} // c end