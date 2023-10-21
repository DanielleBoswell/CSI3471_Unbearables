package com.csi3471.unbearables.maven.cruiselink.ui;

public class MakeReservationController implements MakeReservationControllerInterface{
	public String[] getRoomInfo() {
		//connect to services
		String[] a = {"Executive", "Queen", "1", "No"};
		return a;
	}

}
