package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink;
/**
 * Author: Emma Aars
 * Purpose: Basic Attributes and Methods for BillingInfo Class
 */

import java.sql.Date;
import java.util.Objects;

public class BillingInfo {
	String cardInfo;
	String billingAddress;
	String billingID;
	Date billingDate;
	Date dueDate;
	
	// constructors
	public BillingInfo() {
		cardInfo = "";
		billingAddress = "";
		billingID = "";
		billingDate = new Date(0);
		dueDate = new Date(0);
	}
	public BillingInfo(String card, String address, String ID,
		Date billed, Date due) {
		cardInfo = card;
		billingAddress = address;
		billingID = ID;
		billingDate = billed;
		dueDate = due;
	}
		
	// getters and setters
	public String getcardInfo() {
		return cardInfo;
	}
	public void setcardInfo(String card) {
		cardInfo = card;
	}
		
	public String getbillingAddress() {
		return billingAddress;
	}
	public void setbillingAddress(String address) {
		billingAddress = address;
	}
		
	public String getbillingID() {
		return billingID;
	}
	public void setbillingID(String ID) {
		billingID = ID;
	}
		
	public Date getbillingDate() {
		return billingDate;
	}
	public void setbillingDate(Date billed) {
		billingDate = billed;
	}
		
	public Date getdueDate() {
		return dueDate;
	}
	public void setdueDate(Date due) {
		dueDate = due;
	}
		
	// IDE generated hashCode override
	@Override
	public int hashCode() {
		return Objects.hash(billingAddress, billingDate, billingID, cardInfo, dueDate);
	}
		
	// IDE generated equals override
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingInfo other = (BillingInfo) obj;
		return Objects.equals(billingAddress, other.billingAddress)
				&& Objects.equals(billingDate, other.billingDate) && Objects.equals(billingID, other.billingID)
				&& Objects.equals(cardInfo, other.cardInfo) && Objects.equals(dueDate, other.dueDate);
	}
}

