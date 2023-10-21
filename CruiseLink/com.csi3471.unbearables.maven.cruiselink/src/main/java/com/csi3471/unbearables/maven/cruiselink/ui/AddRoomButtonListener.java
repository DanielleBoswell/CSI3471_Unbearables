package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.ui;

import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.Room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Room room = new Room();
    }
}
