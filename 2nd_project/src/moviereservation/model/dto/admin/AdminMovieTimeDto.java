package moviereservation.model.dto.admin;

public class AdminMovieTimeDto {

	private String startTime;
	
	public AdminMovieTimeDto() {}
	public AdminMovieTimeDto(String StartTime) {
		super();
		this.startTime = StartTime;
	}
	

	@Override
	public String toString() {
		return "AdminMovieTimeDto [startTime=" + startTime + "]";
	}
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
	
}
