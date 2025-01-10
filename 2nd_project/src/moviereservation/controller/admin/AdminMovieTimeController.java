package moviereservation.controller.admin;

import java.util.ArrayList;

import moviereservation.model.dao.admin.AdminMovieTimeDao;
import moviereservation.model.dto.admin.AdminMovieTimeDto;

public class AdminMovieTimeController {
	private static AdminMovieTimeController instance = new AdminMovieTimeController();
	private AdminMovieTimeController() {}
	public static AdminMovieTimeController getInstance() {return instance;}
	public ArrayList<AdminMovieTimeDto> movieTimeShow() {
		ArrayList<AdminMovieTimeDto> show = AdminMovieTimeDao.getInstance().movieTimeShow();
		return show;
	}
	
}
