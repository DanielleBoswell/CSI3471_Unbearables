package UI;

import Controller.AllReservationsGuestViewController;

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

public class ViewReservationsGUI extends JPanel {
    /**
     * to navigate between pages
     */
    private UINavigator uiNavigator;
    /**
     * for page functionality
     */
    public AllReservationsGuestViewController reservationController;

    boolean DEBUG = false;
    private JTable table;
    private JTextField filterText;
    private JTextField statusText;
    private JButton viewButton, backButton;
    private TableRowSorter<DefaultTableModel> sorter;
    private String[] columnNames = {"ID","Cruise","Quality","Start Date","End Date"};
    private Object[][] data;

    /**
     * constructor to create all elements on the UI
     * to view all reservations of Guest
     *
     * @param uiNavigator uiNavigator
     * @author Danielle Boswell
     */
    public ViewReservationsGUI(UINavigator uiNavigator){
        super();
        this.uiNavigator = uiNavigator;
        this.reservationController  = new AllReservationsGuestViewController();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final Class<?>[] columnClass = new Class[] {
                String.class, String.class, String.class, String.class, String.class,
                String.class, String.class, String.class
        };

        data = reservationController.viewReservationsGuest();

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


        Box b1 = Box.createHorizontalBox();
        b1.add(Box.createHorizontalGlue());
        add(b1);


        sorter = new TableRowSorter<DefaultTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        ViewReservationFromTableAction viewAction = new ViewReservationFromTableAction(table, (DefaultTableModel)table.getModel());

        // Better to have a single selection.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        table.getSelectionModel().addListSelectionListener(
//                new ListSelectionListener() {
//                    public void valueChanged(ListSelectionEvent event) {
//                        int viewRow = table.getSelectedRow();
//                        if (viewRow < 0) {
//                            //Selection got filtered away.
//                            //statusText.setText("");
//                        } else {
//                            int modelRow =
//                                    table.convertRowIndexToModel(viewRow);
////                            statusText.setText(
////                                    String.format("Selected Row in view: %d. " +
////                                                    "Selected Row in model: %d.",
////                                            viewRow, modelRow));
//                        }
//                    }
//                }
//        );


        //Create a separate form for filterText and statusText
        JPanel form = new JPanel();
        backButton = new JButton("Go Back");
        backButton.addActionListener(e -> UINavigator.showCard(UINavigator.GUEST_LANDING_PANEL));
        form.add(backButton);
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

        add(form);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.createVerticalScrollBar();
        add(scrollPane);


        JButton dialogButton = new JButton("View Reservation");
        dialogButton.addActionListener(viewAction);
        add(dialogButton);
        setOpaque(true);
    }

    /**
     *
     * Reservation view
     *
     * @param <T>
     * @param <M>
     * @author Danielle Boswell
     */
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

    /**
     * For selecting and viewing a single reservation
     * @author Danielle Boswell
     */
    public class ViewReservationFromTableAction extends AbstractTableAction<JTable, DefaultTableModel> {

        /**
         * Enacting selecting and viewing a single reservation
         * @param table the table
         * @param model the model of reservations
         * @author Danielle Boswell
         */
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

        /**
         * Views the reservation and switches the page
         * @param e the event to be processed
         * @author Danielle Boswell
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("...");
            JTable table = getTable();
            int row = table.getSelectedRowCount();

            if (row > 1) {
                JOptionPane.showMessageDialog(table, "Cannot view multiple reservations");
            } else {
                int viewRow = table.getSelectedRow();
                int modelRow =
                        table.convertRowIndexToModel(viewRow);
                UINavigator.addCard(new ReservationViewUI(uiNavigator, reservationController.viewReservationGuest(modelRow)),
                        UINavigator.RESERVATION_VIEW);
                UINavigator.showCard(UINavigator.RESERVATION_VIEW);
            }
        }

    }

    /**
     * Filters the reservations
     */
    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0, 1, 2);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
}
