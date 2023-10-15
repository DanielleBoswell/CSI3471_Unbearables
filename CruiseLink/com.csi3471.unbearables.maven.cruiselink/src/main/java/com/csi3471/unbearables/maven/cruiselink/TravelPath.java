package com.csi3471.unbearables.maven.cruiselink;
/* Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: TravelPath.java
 * Creation Date: 10/15/2023
 * Modified Date: 10/15/2023
 * Description: Contains the travel path of Ship
 * 
 */

import java.util.Date;
import java.util.List;

public class TravelPath {
	private int days;
	private Date startDate;
	private Date endDate;
	private List<Country> path;
	
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Country> getPath() {
		return path;
	}
	public void setPath(List<Country> path) {
		this.path = path;
	}
	
	
}
