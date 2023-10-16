package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

/* Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: Corporation.java
 * Creation Date: 10/15/2023
 * Modified Date: 10/15/2023
 * Description: Contains the Corporation class
 *
 */
public class Corporation {
    private String name;
    private int numPeople;
    private double discount;
    private boolean discountAvailable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        this.discountAvailable = discountAvailable;
    }
}
