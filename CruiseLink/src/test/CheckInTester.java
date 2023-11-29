import InfoExpert.guestInfoExpert;
import UI.UINavigator;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.sql.SQLException;

public class CheckInTester {
    @Test
    public void testShowCard() {
        guestInfoExpert some = null;
        try{
            some = new guestInfoExpert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Call launch page
        //Ensuring the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            //Making a new UINavigator to construct the main frame with other GUIs as panels
            //UINavigator uiNavigator =
            new UINavigator();
            //uiNavigator.setVisible(true);
            //UINavigator.showCard(UINavigator.CHECK_IN_PANEL);
        });

        //UINavigator.showCard(UINavigator.CHECK_IN_PANEL);
        some.deleteAccountDatabase();
    }
}
