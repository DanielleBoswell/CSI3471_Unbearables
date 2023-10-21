package com.csi3471.unbearables.maven.cruiselink;
/**
 * Author: Emma Aars
 * Purpose: Basic Attributes and Methods for Billing Class
 */

import java.util.Objects;

public class Billing {
	final int penaltyPercent = 80;
	
	double totalAmount;
	double taxRate;
	boolean isPaid;
	double finalAmount;
	double cancellationPenalty;
	
	// constructors
	public Billing() {
		totalAmount = 0;
		taxRate = 0;
		isPaid = false;
		finalAmount = 0;
		cancellationPenalty = 0;
	}
	public Billing(double total, double rate) {
		totalAmount = total;
		taxRate = rate;
		isPaid = false;
		finalAmount = totalAmount + (totalAmount * taxRate);
		cancellationPenalty = totalAmount / 80;
	}
	
	// getters and setters
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double total) {
		totalAmount = total;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double rate) {
		taxRate = rate;
	}
	
	public boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(boolean status) {
		isPaid = status;
	}
	
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double total) {
		finalAmount = total;
	}
	
	public double getCancellationPenalty() {
		return cancellationPenalty;
	}
	public void setCancellationPenalty(double penalty) {
		cancellationPenalty = penalty;
	}
	
	// IDE generated hashCode override
	@Override
	public int hashCode() {
		return Objects.hash(cancellationPenalty, finalAmount, isPaid, penaltyPercent, taxRate, totalAmount);
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
		Billing other = (Billing) obj;
		return Double.doubleToLongBits(cancellationPenalty) == Double.doubleToLongBits(other.cancellationPenalty)
				&& Double.doubleToLongBits(finalAmount) == Double.doubleToLongBits(other.finalAmount)
				&& isPaid == other.isPaid && penaltyPercent == other.penaltyPercent
				&& Double.doubleToLongBits(taxRate) == Double.doubleToLongBits(other.taxRate)
				&& Double.doubleToLongBits(totalAmount) == Double.doubleToLongBits(other.totalAmount);
	}	
}

