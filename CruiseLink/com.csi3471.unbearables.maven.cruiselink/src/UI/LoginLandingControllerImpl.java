package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

public class LoginLandingControllerImpl implements LoginLandingController {
    @Override
    public void onReserveCruisePressed() {
        System.out.println("Reserve a Cruise pressed!");
    }

    @Override
    public void onMyReservationsPressed() {
        System.out.println("My Reservations pressed!");
    }
}
