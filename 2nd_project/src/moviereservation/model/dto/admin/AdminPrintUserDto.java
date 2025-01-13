package moviereservation.model.dto.admin;

public class AdminPrintUserDto {
	private int memberId;
	private String mId;
	private String mname;
	private String movieName;
	private String movieDate;
	private int theaterId;
	private String seatNum;
	private String revDate;
	public AdminPrintUserDto() {}
	
	public AdminPrintUserDto(int memberId, String mId, String mname, String movieName, String movieDate, int theaterId,
			String seatNum, String revDate) {
		this.memberId = memberId;
		this.mId = mId;
		this.mname = mname;
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.theaterId = theaterId;
		this.seatNum = seatNum;
		this.revDate = revDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}

	@Override
	public String toString() {
		return "AdminPrintUserDto [memberId=" + memberId + ", mId=" + mId + ", mname=" + mname + ", movieName="
				+ movieName + ", movieDate=" + movieDate + ", theaterId=" + theaterId + ", seatNum=" + seatNum
				+ ", revDate=" + revDate + "]";
	}
	

	

}
