package moviereservation.controller.admin;

public class AdminMovieTimeController {
	private static AdminMovieTimeController instance = new AdminMovieTimeController();
	private AdminMovieTimeController() {}
	public static AdminMovieTimeController getInstance() {return instance;}
	
}
