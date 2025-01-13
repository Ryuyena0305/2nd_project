package moviereservation.view.member;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.member.MemberReviewController;
import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewView {
	private static MemberReviewView instance = new MemberReviewView();
	private MemberReviewView() {}
	public static MemberReviewView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("1.리뷰등록 2.전체리뷰조회 3.리뷰삭제 4.리뷰수정 5.뒤로가기");
			int choose = scan.nextInt();
			if(choose ==1 ) {regist();}
			else if(choose == 2) {print();}
			else if(choose ==3) {}
			else if(choose ==4) {}
			else if(choose == 5) {break;}
		}
	}
	
	public void regist() {
		System.out.println("영화명"); String movieName = scan.next();
		System.out.println("리뷰제목"); String reviewTitle = scan.next();
		System.out.println("리뷰내용"); String reviewContent = scan.next();
		System.out.println("리뷰점수"); int reviewRating = scan.nextInt();
		System.out.println("리뷰작성날짜"); String reviewDate = scan.next();
		MemberReviewDto memberReviewDto = new MemberReviewDto();
		memberReviewDto.setMovieName(movieName);
		memberReviewDto.setReviewTitle(reviewTitle);
		memberReviewDto.setReviewContent(reviewContent);
		memberReviewDto.setReviewRating(reviewRating);
		memberReviewDto.setReviewDate(reviewDate);
		boolean result = MemberReviewController.getInstance().regist(memberReviewDto);
		if(result) {System.out.println("리뷰등록 성공");}
		else {System.out.println("리뷰등록 실패");}
	}
	public void print() {
		ArrayList<MemberReviewDto> result = MemberReviewController.getInstance().print();
		System.out.println("번호\t영화\t제목\t내용\t점수\t작성날짜");
		for(int i = 0; i < result.size(); i++) {
			MemberReviewDto memberReviewDto = result.get(i);
			System.out.println(memberReviewDto.getReviewId()+"\t");
			System.out.println(memberReviewDto.getMovieName()+"\t");
			System.out.println(memberReviewDto.getReviewTitle()+"\t");
			System.out.println(memberReviewDto.getReviewContent()+"\t");
			System.out.println(memberReviewDto.getReviewRating()+"\t");
			System.out.println(memberReviewDto.getReviewDate()+"\n");
		}
	}
}
