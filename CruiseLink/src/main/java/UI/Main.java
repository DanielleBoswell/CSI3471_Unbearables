package UI;

import javax.swing.*;
import InfoExpert.guestInfoExpert;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try{
            guestInfoExpert some = new guestInfoExpert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Call launch page
        //Ensuring the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            //Making a new UINavigator to construct the main frame with other GUIs as panels
            new UINavigator();
        });
    }
}
