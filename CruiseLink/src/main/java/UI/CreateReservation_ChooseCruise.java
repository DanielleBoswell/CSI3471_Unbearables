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
/**
 * @author Spencer Hammack
 * This frame provides the interface for choose cruise
 */
public class CreateReservation_ChooseCruise extends JPanel {
    JPanel panel;
    JLabel chooseCruise;

    UINavigator uiNavigator;

    public CreateReservation_ChooseCruise(UINavigator nav) {
        this.uiNavigator = nav;
    }

    public JPanel CreateReservation_ChooseCruise_creator() {
        chooseCruise = new JLabel("Choose a cruise");
        chooseCruise.setBounds(600, 50, 500, 40);
        chooseCruise.setFont(new Font("Arial", Font.PLAIN, 40));
        add(chooseCruise);

        JButton buttonCruise1 = new JButton("Cruise 1");//create button
        JButton buttonCruise2 = new JButton("Cruise 2");//create button
        JButton buttonCruise3 = new JButton("Cruise 3");//create button

        buttonCruise1.setBounds(350, 150, 200, 80);
        buttonCruise1.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonCruise2.setBounds(650, 150, 200, 80);
        buttonCruise2.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonCruise3.setBounds(950, 150, 200, 80);
        buttonCruise3.setFont(new Font("Arial", Font.PLAIN, 40));

        buttonCruise1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cruise 1 button pressed!");
                uiNavigator.showCard(UINavigator.CHOOSE_ROOM_PANEL);
            }
        });

        buttonCruise2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cruise 2 button pressed!");
                uiNavigator.showCard(UINavigator.CHOOSE_ROOM_PANEL);

            }
        });

        buttonCruise3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cruise 3 button pressed!");
                uiNavigator.showCard(UINavigator.CHOOSE_ROOM_PANEL);
            }
        });


        add(buttonCruise1);//adding button on frame
        add(buttonCruise2);//adding button on frame
        add(buttonCruise3);//adding button on frame

        setSize(400, 500);
        setLayout(null);
        setVisible(true);

        return this;
    }

    public static void main(String[] args) {
        UINavigator uiNavigator = new UINavigator();
        uiNavigator.showCard(UINavigator.CHOOSE_CRUISE_PANEL);
    }
}

