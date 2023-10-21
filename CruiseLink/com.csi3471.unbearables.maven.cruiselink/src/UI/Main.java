package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Making sure it is running on the correct thread
        SwingUtilities.invokeLater(() -> {

            //Need to create an instance of the concrete implementation of LoginController
            LoginController controller = new LoginControllerImpl();

            //Will pass controller to LoginGUI and create the login GUI
            LoginGUI loginGUI = new LoginGUI(controller);

            //Create login GUI
            loginGUI.createGUI();
        });
    }
}