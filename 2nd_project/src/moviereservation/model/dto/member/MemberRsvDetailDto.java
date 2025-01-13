package moviereservation.model.dto.member;

public class MemberRsvDetailDto {
	private int rsvNum;
	private String rsvMovieName;
	private String rsvTheater;
	private String rsvTime;
	private int rsvPerson;
	private String rsvSeat;
	
	public MemberRsvDetailDto() {}
	public MemberRsvDetailDto(int rsvNum, String rsvMovieName, String rsvTheater, String rsvTime, int rsvPerson,
			String rsvSeat) {
		super();
		this.rsvNum = rsvNum;
		this.rsvMovieName = rsvMovieName;
		this.rsvTheater = rsvTheater;
		this.rsvTime = rsvTime;
		this.rsvPerson = rsvPerson;
		this.rsvSeat = rsvSeat;
	}
	public int getRsvNum() {
		return rsvNum;
	}
	public void setRsvNum(int rsvNum) {
		this.rsvNum = rsvNum;
	}
	public String getRsvMovieName() {
		return rsvMovieName;
	}
	public void setRsvMovieName(String rsvMovieName) {
		this.rsvMovieName = rsvMovieName;
	}
	public String getRsvTheater() {
		return rsvTheater;
	}
	public void setRsvTheater(String rsvTheater) {
		this.rsvTheater = rsvTheater;
	}
	public String getRsvTime() {
		return rsvTime;
	}
	public void setRsvTime(String rsvTime) {
		this.rsvTime = rsvTime;
	}
	public int getRsvPerson() {
		return rsvPerson;
	}
	public void setRsvPerson(int rsvPerson) {
		this.rsvPerson = rsvPerson;
	}
	public String getRsvSeat() {
		return rsvSeat;
	}
	public void setRsvSeat(String rsvSeat) {
		this.rsvSeat = rsvSeat;
	}
	@Override
	public String toString() {
		return "MemberRsvDetailDto [rsvNum=" + rsvNum + ", rsvMovieName=" + rsvMovieName + ", rsvTheater=" + rsvTheater
				+ ", rsvTime=" + rsvTime + ", rsvPerson=" + rsvPerson + ", rsvSeat=" + rsvSeat + "]";
	}
	
	public MemberRsvDetailDto(String rsvMovieName) {
		super();
		this.rsvMovieName = rsvMovieName;
	}
}
