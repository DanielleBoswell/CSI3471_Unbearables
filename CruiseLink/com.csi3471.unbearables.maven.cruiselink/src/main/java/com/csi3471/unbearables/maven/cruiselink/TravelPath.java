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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TravelPath {
	private int days;
	private Date startDate;
	private Date endDate;
	private Map<Date,Country> path = null;
	
	
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
	public Map<Date,Country> getPath() {
		return path;
	}
	public void setPath(Map<Date,Country> path) {
		this.path = path;
	}
	
	public void addCountry(Country c) { // FIXME: automatically find start/end date
		if(path == null) {
			path = new TreeMap<Date,Country>();
		}
		
		path.put(c.getArrivalDate(),c);
		
	}
	
	public Country checkStartDate(Date date) {
		Country temp = null;
		if(!date.equals(endDate)) { // makes sure guest not registering for last day
			if(path.containsKey(date)) {
				temp = path.get(date);
			}
			else {
				for(Map.Entry<Date,Country> y : path.entrySet()) {
					if(date.after(y.getKey()) && date.before(y.getValue().getDepartureDate())) {
						temp = y.getValue();
					}
				}
			}
		}
		
		return temp;
	}
	
	public Country checkEndDate(Date date) {
		Country temp = null;
		if(!date.equals(startDate)) { // makes sure guest not registering for first day
			if(path.containsKey(date)) {
				temp = path.get(date);
			}
			else {
				for(Map.Entry<Date,Country> y : path.entrySet()) {
					if(date.after(y.getKey()) && date.before(y.getValue().getDepartureDate())) {
						temp = y.getValue();
					}
				}
			}
		}
		
		return temp;
	}
	
	public boolean checkDates(Date start, Date end) {
		if(checkEndDate(end) != null && checkStartDate(start) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
