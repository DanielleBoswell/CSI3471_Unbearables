package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import javax.swing.*;

public interface AddRoomController {
    //void onAddPressed(JComboBox, JComboBox, JComboBox, JTextField, JCheckBox);
    void onCancelPressed();

    void onAddPressed(JComboBox qualityLvl, JComboBox bedType, JComboBox bedNum, JTextField roomNum, JCheckBox isSmoking);
}
