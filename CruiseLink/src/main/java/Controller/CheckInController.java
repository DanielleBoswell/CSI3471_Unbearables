package Controller;

import UI.UINavigator;

import javax.swing.*;

public interface CheckInController {
    void onCheckInPressed(Long customerID, Long roomNum);
    void onCheckOutPressed();
}
