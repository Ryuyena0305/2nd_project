package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminTheaterDto;

public class AdminTheaterDao extends Dao{
	private AdminTheaterDao() {}
	private static AdminTheaterDao instance = new AdminTheaterDao();
	public static AdminTheaterDao getInstance() {
		return instance;
	}
	public boolean checkTheaterId(AdminTheaterDto adminTheaterDto) {
		try {
			String sql = "select Tid from Theater where Tid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,adminTheaterDto.getTid());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("Tid");
				return id==adminTheaterDto.getTid();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean addTheater() {
		// TODO Auto-generated method stub
		return false;
	}
	public void printBasicTheater() {
		
	}
	public ArrayList<AdminTheaterDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean updateTheater(AdminTheaterDto adminTheaterDto) {
		// TODO Auto-generated method stub
		return false;
	}
	public AdminTheaterDto deleteTheater(AdminTheaterDto adminTheaterDto) {
		// TODO Auto-generated method stub
		return null;
	}
	public AdminTheaterDto findupdateTheater(int tid) {
		// TODO Auto-generated method stub
		return null;
	}
	public AdminTheaterDto finddeleteTheater(int tid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}