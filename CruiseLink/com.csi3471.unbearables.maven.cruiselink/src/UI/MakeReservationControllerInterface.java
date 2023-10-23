package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import java.sql.Date;

public interface MakeReservationControllerInterface {
	public String[] getRoomInfo();
	public boolean canReserve(String start, String end, int total);
	public void reserveRoom();
}
