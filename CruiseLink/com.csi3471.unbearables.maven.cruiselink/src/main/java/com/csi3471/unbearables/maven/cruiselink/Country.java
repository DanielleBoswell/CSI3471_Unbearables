package com.csi3471.unbearables.maven.cruiselink;
/* Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: TravelPath.java
 * Creation Date: 10/15/2023
 * Modified Date: 10/15/2023
 * Description: Contains the country specific to each
 * 				stop of the travel path
 * 
 */

import java.util.Date;

public class Country {
	private String name,
			visaRequirements;
	private boolean isTemporaryStay;
	private Date arrivalDate, 
			departureDate;
	
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isTemporaryStay() {
		return isTemporaryStay;
	}
	public void setTemporaryStay(boolean isTemporaryStay) {
		this.isTemporaryStay = isTemporaryStay;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getVisaRequirements() {
		return visaRequirements;
	}
	public void setVisaRequirements(String visaRequirements) {
		this.visaRequirements = visaRequirements;
	}
	
}
