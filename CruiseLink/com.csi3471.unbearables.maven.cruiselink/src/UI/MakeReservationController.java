package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import java.sql.Date;

public class MakeReservationController implements MakeReservationControllerInterface{ // FIXME: connect to services
	public String[] getRoomInfo() {
		//connect to services
		String[] a = {"Executive", "Queen", "1", "No"};
		return a;
	}
	
	public boolean canReserve(String start, String end, int total) { // FIXME: connect to services
		return false;
	}
	
	public void reserveRoom() {} // FIXME: connect to services

}
