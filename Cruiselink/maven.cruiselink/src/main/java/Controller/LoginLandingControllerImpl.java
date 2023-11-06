package Controller;

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
