package UI;

import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CreateReservation_ChooseCruise extends JPanel {
    JPanel panel;
    JLabel chooseCruise;

    public CreateReservation_ChooseCruise() {
        chooseCruise = new JLabel("Choose a cruise");
        chooseCruise.setBounds(250,50,100,40);
        add(chooseCruise);

        JButton buttonCruise1 = new JButton("Cruise 1");//create button
        JButton buttonCruise2 = new JButton("Cruise 2");//create button
        JButton buttonCruise3 = new JButton("Cruise 3");//create button
        buttonCruise1.setBounds(130, 100, 100, 40);
        buttonCruise2.setBounds(250, 100, 100, 40);
        buttonCruise3.setBounds(370, 100, 100, 40);

        add(buttonCruise1);//adding button on frame
        add(buttonCruise2);//adding button on frame
        add(buttonCruise3);//adding button on frame
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
    }

    private static JPanel createPanel() {
       return new CreateReservation_ChooseCruise();
    }
public static void main(String[] args) {
    createPanel();
}
}

