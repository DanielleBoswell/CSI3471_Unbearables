package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person;

import java.util.Objects;

public class Guest extends Person {

    String billingInfo;
    int points;
    boolean isMember;
    boolean isCorporate;
    String phoneNumber;
    String card;
    String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

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
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return points == guest.points && isMember == guest.isMember && isCorporate == guest.isCorporate && Objects.equals(billingInfo, guest.billingInfo) && Objects.equals(phoneNumber, guest.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingInfo, points, isMember, isCorporate, phoneNumber);
    }
}
