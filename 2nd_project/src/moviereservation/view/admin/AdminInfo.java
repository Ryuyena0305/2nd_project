package moviereservation.view.admin;

public class AdminInfo {
	private AdminInfo() {}
	private static AdminInfo instance = new AdminInfo();
	public static AdminInfo getInstance() {
		return instance;
	}
	
	public void adminUpdate() {}
	public void adminDelete() {}
	public void adminLogout() {}
}
