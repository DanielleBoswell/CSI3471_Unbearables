package Controller;

public class MyMenuBarControllerImpl implements MyMenuBarController {
    @Override
    public void onAccountDetailsPressed() {
        System.out.println("Account Details Pressed!");
        // go to account details (ask for password before displaying info)
    }

    @Override
    public void onLogOutPressed() {
        System.out.println("Log Out Pressed!");
        // go back to login page and reset logged in account
    }
}
