package UI;

/*
 * TableFilterDemo.java requires SpringUtilities.java
 */
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CreateReservation_ChooseRoom extends JPanel {
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
    public class DeleteRowFromTableAction extends AbstractTableAction<JTable, DefaultTableModel> {

        public DeleteRowFromTableAction(JTable table, DefaultTableModel model) {
            super(table, model);
            putValue(NAME, "Delete selected rows");
            putValue(SHORT_DESCRIPTION, "Delete selected rows");
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
            if (table.getSelectedRowCount() > 0) {
                List<Vector> selectedRows = new ArrayList<Vector>(25);
                DefaultTableModel model = getModel();
                Vector rowData = model.getDataVector();
                for (int row : table.getSelectedRows()) {
                    int modelRow = table.convertRowIndexToModel(row);
                    Vector rowValue = (Vector) rowData.get(modelRow);
                    selectedRows.add(rowValue);
                }

                for (Vector rowValue : selectedRows) {
                    int rowIndex = rowData.indexOf(rowValue);
                    model.removeRow(rowIndex);
                }
            }
        }

    }

    public class MyDialog extends JDialog {
        private JTable table;
        public MyDialog(JTable owner) {
            super(javax.swing.SwingUtilities.windowForComponent(owner));
            table = owner;
            createGUI();
        }
        private void createGUI() {
            setPreferredSize(new Dimension(600, 400));
            setTitle(getClass().getSimpleName());
            JPanel listPane = new JPanel();
            listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
            JLabel label = new JLabel("Hello:");
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPane.add(label);
            int row = table.getSelectedRow();
            JLabel dataLabel = null;
            if(row < 0) {
                dataLabel = new JLabel("no row selected");
            } else {
                dataLabel = new JLabel(table.getModel().getValueAt(row, 0)+" "+table.getModel().getValueAt(row, 1));
            }
            dataLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPane.add(dataLabel);

            JButton addButton = new JButton("Add row");
            addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                ((DefaultTableModel) table.getModel()).addRow(new Object[]{"Coolio", "Noman", "Karate", 1, true});
                                                dispose();
                                                JOptionPane.showMessageDialog(table, "Added new record");
                                            }
                                        }
            );
            listPane.add(addButton);
            add(listPane);
            pack();
            setLocationRelativeTo(getParent());
        }
        @Override
        public void dispose() {
            super.dispose();
        }
    }
//    private JMenuBar initMenu() {
//        JMenuBar menuBar;
//        JMenu menu;
//        JMenuItem header,menuItem, menuCSV;
//        menuBar = new JMenuBar();
//        menu = new JMenu("Menu");
//        menuBar.add(menu);
//        header = new JMenuItem("COMMANDS:");
//        header.setEnabled(false);
//        menu.add(header);
//        menuItem = new JMenuItem("Remove");
//        menuItem.addActionListener(null);
//        menu.add(menuItem);
//        menu.addSeparator();
//        menuCSV = new JMenuItem("Load CSV");
//        menu.add(menuCSV);
//        menuItem.addActionListener(new RemoveLineActionLister());
//        menuCSV.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                DefaultTableModel model = (DefaultTableModel) table.getModel();
//                try (BufferedReader br = new BufferedReader(
//                        new FileReader(new File(this.getClass().getResource("/data.csv").getFile())))) {
//                    String line;
//                    while ((line = br.readLine()) != null) {
//// System.out.println(line);
//                        String[] row = line.split(",");
//                        Vector<Object> correction = new Vector<>();
//                        for (int i = 0; i < 3; i++) {
//                            correction.add(row[i]);
//                        }
//                        correction.add(Integer.parseInt(row[3]));
//                        correction.add(Boolean.parseBoolean(row[4]));
//                        model.addRow(correction);
//                    }
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });
//
//        menu.addMenuListener(new MenuListener() {
//            @Override
//            public void menuSelected(MenuEvent e) {
//                int viewRow = table.getSelectedRow();
//                if (viewRow < 0) {
//                    //menuRemove.setEnabled(false);
//                } else {
//                    //menuRemove.setEnabled(true);
//                }
//            }
//            @Override
//            public void menuDeselected(MenuEvent e) {}
//
//            @Override
//            public void menuCanceled(MenuEvent e) {}
//
//        });
//
//        return menuBar;
//    }


    public CreateReservation_ChooseRoom() {
        super();
        TableFilterHeader filterHeader = new TableFilterHeader(table, AutoChoices.ENABLED);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        MyTableModel m = new MyTableModel();
        //Create a table with a sorter.
        //DefaultTableModel model = new DefaultTableModel(m.data, m.columnNames);
        final Class<?>[] columnClass = new Class[] {
                String.class, String.class, String.class, Integer.class, Boolean.class
        };
        DefaultTableModel model = new DefaultTableModel(m.data, m.columnNames) {
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
        //b1.add(initMenu());
        b1.add(Box.createHorizontalGlue());
        add(b1);


        sorter = new TableRowSorter<DefaultTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);


//        DeleteRowFromTableAction deleteAction = new DeleteRowFromTableAction(table, (DefaultTableModel)table.getModel());
//        JToolBar toolbar = new JToolBar();
//        Box floatRightBox = Box.createHorizontalBox();
//        floatRightBox.add(Box.createHorizontalGlue());
//        toolbar.add(deleteAction);
//        floatRightBox.add(toolbar);
//        add(floatRightBox);

        //For the purposes of this example, better to have a single
        //selection.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//        //When selection changes, provide user with row numbers for
//        //both view and model.
//        table.getSelectionModel().addListSelectionListener(
//                new ListSelectionListener() {
//                    public void valueChanged(ListSelectionEvent event) {
//                        int viewRow = table.getSelectedRow();
//                        if (viewRow < 0) {
//                            //Selection got filtered away.
//                            statusText.setText("");
//                        } else {
//                            int modelRow =
//                                    table.convertRowIndexToModel(viewRow);
//                            statusText.setText(
//                                    String.format("Selected Row in view: %d. " +
//                                                    "Selected Row in model: %d.",
//                                            viewRow, modelRow));
//                        }
//                    }
//                }
//        );


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
//        JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
//        form.add(l2);
//        statusText = new JTextField();
//        l2.setLabelFor(statusText);
//        form.add(statusText);
        SpringUtilities.makeCompactGrid(form, 2, 1, 6, 6, 6, 6);
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit button clicked!");
            }
        });
        JButton dialogButton = new JButton("Cancel");
        dialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel button clicked!");

            }
        });

        add(dialogButton);
        add(button);
        add(form);

    }

    /**
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(selectedText.getText(), 0,1,2);
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
        JFrame frame = new JFrame("TableFilterDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CreateReservation_ChooseRoom newContentPane = new CreateReservation_ChooseRoom();
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
    }}