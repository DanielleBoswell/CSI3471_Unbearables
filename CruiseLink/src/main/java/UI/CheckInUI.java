package UI;

import javax.swing.*;
import java.awt.*;

public class CheckInUI extends JPanel {
    // Constant for setting the text box width
    public static final int TEXT_BOX_WIDTH = 25;

    // Labels
    //private Label cruiseLinkLabel;
    private Label firstNameLabel;
    private Label lastNameLabel;

    // Making a CheckIn controller impl object
    private CheckInControllerImpl checkInController;

    // Making a UINavigator instance for check in
    private UINavigator uiNavigator;
}
