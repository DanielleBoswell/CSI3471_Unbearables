package UI;

import Controller.ReservationGuestViewController;
import Domain.Reservation;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

public class ViewReservationsGUI extends JPanel {
    private UINavigator uiNavigator;

    public ViewReservationsGUI(UINavigator uiNavigator){
        this.uiNavigator = uiNavigator;
    }

    public ReservationGuestViewController reservationController = new ReservationGuestViewController();

    //Minitask1
//    private final class RemoveLineActionListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int viewRow = table.getSelectedRow();
//            if (viewRow < 0) {
//                JOptionPane.showMessageDialog(null, "No row selected!");
//            } else {
//                int modelRow = table.convertRowIndexToModel(viewRow);
//                DefaultTableModel model = (DefaultTableModel) table.getModel();
//                int answer = JOptionPane
//                        .showConfirmDialog(null,
//                                "Do you want to remove " + model.getValueAt(modelRow, 0) + " "
//                                        + model.getValueAt(modelRow, 1) + "?",
//                                "Warning", JOptionPane.YES_NO_OPTION);
//                if (answer == 0) model.removeRow(modelRow);
//            }
//        }
//    }

    boolean DEBUG = false;
    private JTable table;
    private JTextField filterText;
    private JTextField statusText;
    private TableRowSorter<DefaultTableModel> sorter;
    private String[] columnNames = {"ID","Cruise","Quality","Start Date","End Date"};
    private Object[][] data = {{"123", "AA", "Executive", "12/31/23","1/14/24"},
                                {"333", "EA", "Business", "12/31/23","1/14/24"}};


    public ViewReservationsGUI() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a table with a sorter.
        //TASK2
        //TASK6
        //DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final Class<?>[] columnClass = new Class[] {
                String.class, String.class, String.class, String.class, String.class,
                String.class, String.class, String.class
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
        };

        //get from CSV file
//        try (BufferedReader br = new BufferedReader(
//                new InputStreamReader(getClass().getResourceAsStream("/cars.csv")))) {
//            String line;
//            br.readLine();
//            while ((line = br.readLine()) != null) {
//                // System.out.println(line);
//                String[] row = line.split(",");
//                Vector<Object> correction = new Vector<>();
//                for (int i = 0; i < 5; i++) {
//                    correction.add(row[i]);
//                }
//                model.addRow(correction);
//            }
//        }
//        catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//        catch(NullPointerException e) {
//            e.printStackTrace();
//        }

        Box b1 = Box.createHorizontalBox();
        //b1.add(initMenu(model));
        b1.add(Box.createHorizontalGlue());
        add(b1);


        sorter = new TableRowSorter<DefaultTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //TASK5
        ViewReservationFromTableAction viewAction = new ViewReservationFromTableAction(table, (DefaultTableModel)table.getModel());
//        JToolBar toolbar = new JToolBar();
//        Box floatRightBox = Box.createHorizontalBox();
//        floatRightBox.add(Box.createHorizontalGlue());
//        toolbar.add(viewAction);
//        floatRightBox.add(toolbar);
//        add(floatRightBox);

        //For the purposes of this example, better to have a single
        //selection.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //TASK5
        //table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //TASK7
        //TableFilterHeader filterHeader = new TableFilterHeader(table, AutoChoices.ENABLED);

        //When selection changes, provide user with row numbers for
        //both view and model.
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            //Selection got filtered away.
                            //statusText.setText("");
                        } else {
                            int modelRow =
                                    table.convertRowIndexToModel(viewRow);
//                            statusText.setText(
//                                    String.format("Selected Row in view: %d. " +
//                                                    "Selected Row in model: %d.",
//                                            viewRow, modelRow));
                        }
                    }
                }
        );


        //Create a separate form for filterText and statusText
        JPanel form = new JPanel();
        JLabel l1 = new JLabel("Search:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField(20);
        //Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener(
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
        l1.setLabelFor(filterText);
        form.add(filterText);
//        JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
//        //form.add(l2);
//        statusText = new JTextField();
//        l2.setLabelFor(statusText);
//        //form.add(statusText);
        //TASK
        add(form);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.createVerticalScrollBar();


        //Add the scroll pane to this panel.
        add(scrollPane);




        //TASK4
        JButton dialogButton = new JButton("View Reservation");
        dialogButton.addActionListener(viewAction);
        add(dialogButton);

        //SpringUtilities.makeCompactGrid(form, 2, 2, 6, 6, 6, 6);

    }

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

    public class ViewReservationFromTableAction extends AbstractTableAction<JTable, DefaultTableModel> {

        public ViewReservationFromTableAction(JTable table, DefaultTableModel model) {
            super(table, model);
            putValue(NAME, "View Selected Reservation");
            putValue(SHORT_DESCRIPTION, "View A Selected Reservation");
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    setEnabled(getTable().getSelectedRowCount() > 0);
                }
            });
            setEnabled(getTable().getSelectedRowCount() > 0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("...");
            JTable table = getTable();
            int row = table.getSelectedRowCount();
            if (row > 1) {
                JOptionPane.showMessageDialog(table, "Cannot view multiple reservations");
            } else {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //MyDialog dialog = new MyDialog(table);
                    }
                });
            }
        }

    }

    /**
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0, 1, 2);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }




    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Table View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ViewReservationsGUI newContentPane = new ViewReservationsGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
