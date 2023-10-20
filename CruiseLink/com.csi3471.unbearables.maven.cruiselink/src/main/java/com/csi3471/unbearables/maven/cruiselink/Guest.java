package com.csi3471.unbearables.maven.cruiselink;

import java.util.Objects;

public class Guest extends Person {

    String billingInfo;
    int points;
    boolean isMember;
    boolean isCorporate;
    String phoneNumber;

    public String getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(String billingInfo) {
        this.billingInfo = billingInfo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public boolean isCorporate() {
        return isCorporate;
    }

    public void setCorporate(boolean corporate) {
        isCorporate = corporate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().equals(o.getClass()) ) return false;
        Guest guest = (Guest) o;
        return points == guest.points && isMember == guest.isMember && isCorporate == guest.isCorporate && Objects.equals(billingInfo, guest.billingInfo) && Objects.equals(phoneNumber, guest.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), billingInfo, points, isMember, isCorporate, phoneNumber);
    }
}
