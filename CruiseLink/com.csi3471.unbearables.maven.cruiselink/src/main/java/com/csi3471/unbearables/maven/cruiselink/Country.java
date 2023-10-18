package com.csi3471.unbearables.maven.cruiselink;
/* Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: TravelPath.java
 * Creation Date: 10/15/2023
 * Modified Date: 10/18/2023
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
	
	/**
	 * constructor for Country
	 * @param name
	 * @param arrivalDate
	 * @param departureDate
	 */
	public Country(String name, Date arrivalDate, Date departureDate) {
		this.name = name;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	
	/**\
	 * gets the name of the Country
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of the Country
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * confirms if the Country is a temporary stop or an end stop
	 * @return
	 */
	public boolean isTemporaryStay() {
		return isTemporaryStay;
	}
	
	/**
	 * sets if Country is a temporary stay or not
	 * @param isTemporaryStay
	 */
	public void setTemporaryStay(boolean isTemporaryStay) {
		this.isTemporaryStay = isTemporaryStay;
	}
	
	/**
	 * gets the arrival date of the Country
	 * @return
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	/**
	 * sets the arrival date of the Country
	 * @param arrivalDate
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	/**
	 * gets the departure date of the Country
	 * @return
	 */
	public Date getDepartureDate() {
		return departureDate;
	}
	
	/**
	 * sets the departure date of the Country
	 * @param departureDate
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * gets the visa requirements of the Country
	 * @return
	 */
	public String getVisaRequirements() {
		return visaRequirements;
	}
	
	/**
	 * sets the visaRequirements of the Country
	 * @param visaRequirements
	 */
	public void setVisaRequirements(String visaRequirements) {
		this.visaRequirements = visaRequirements;
	}
	
}
