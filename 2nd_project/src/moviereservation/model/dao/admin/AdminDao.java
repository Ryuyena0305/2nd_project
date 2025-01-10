package moviereservation.model.dao.admin;

import moviereservation.model.dao.Dao;

public class AdminDao extends Dao {
	private static AdminDao instance = new AdminDao();
	private AdminDao() {}
	public static AdminDao getInstance() {
		return instance;
	}
	
}
