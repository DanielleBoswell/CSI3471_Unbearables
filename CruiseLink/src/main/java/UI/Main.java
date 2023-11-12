package UI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Call launch page
        //Ensuring the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            //Making a new UINavigator to construct the main frame with other GUIs as panels
            new UINavigator();
        });
    }
}
