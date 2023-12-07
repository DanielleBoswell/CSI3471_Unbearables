package UI;

import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Spencer Hammack
 * This frame provides the interface for choose guest
 */

public class CreateReservation_ChooseGuest extends JPanel {

    UINavigator uiNavigator;
    private boolean DEBUG = false;
    private JTable table;
    private JTextField selectedText;
    private JTextField statusText;
    private TableRowSorter<DefaultTableModel> sorter;


    public abstract class AbstractTableAction<T extends JTable, M extends TableModel> extends AbstractAction {

        private T table;
        private M model;

        public AbstractTableAction(T table, M model) {
            this.table = table;
            this.model = model;
        }

        public T getTable() {
            return table;
        }

        public M getModel() {
            return model;
        }

    }

    public CreateReservation_ChooseGuest(UINavigator nav) {
        this.uiNavigator = nav;
    }

    public JPanel CreateReservation_ChooseGuest_creator() {
        TableFilterHeader filterHeader = new TableFilterHeader(table, AutoChoices.ENABLED);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GuestTableModel m = new GuestTableModel();

        //Create a table with a sorter.
        //DefaultTableModel model = new DefaultTableModel(m.data, m.columnNames);
        final Class<?>[] columnClass = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class
        };
        DefaultTableModel model = new DefaultTableModel(m.data, m.columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };

        Box b1 = Box.createHorizontalBox();
        b1.add(Box.createHorizontalGlue());
        add(b1);


        sorter = new TableRowSorter<DefaultTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);

        //Create a separate form for selectedText and statusText
        JPanel form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter:", SwingConstants.LEADING);
        form.add(l1);
        selectedText = new JTextField();
        //Whenever selectedText changes, invoke newFilter.
        selectedText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
        l1.setLabelFor(selectedText);
        form.add(selectedText);
        SpringUtilities.makeCompactGrid(form, 2, 1, 6, 6, 6, 6);
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert function here todo
                System.out.println("Submit button clicked!");
                uiNavigator.showCard(UINavigator.CHOOSE_CRUISE_PANEL);
            }
        });
        JButton dialogButton = new JButton("Cancel");
        dialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel button clicked!");
                uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
            }
        });

        add(dialogButton);
        add(button);
        add(form);

        return this;
    }

    /**
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(selectedText.getText(), 0, 1, 2);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }


//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }

    private final class RemoveLineActionLister implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int viewRow = table.getSelectedRow();
            if (viewRow < 0) {
                JOptionPane.showMessageDialog(null, "No row selected!");
            } else {
                int modelRow = table.convertRowIndexToModel(viewRow);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int answer = JOptionPane
                        .showConfirmDialog(null,
                                "Do you want to remove " + model.getValueAt(modelRow, 0) + " "
                                        + model.getValueAt(modelRow, 1) + "?",
                                "Warning", JOptionPane.YES_NO_OPTION);
                if (answer == 0) {
                    model.removeRow(modelRow);
                }
            }
        }
    }
}