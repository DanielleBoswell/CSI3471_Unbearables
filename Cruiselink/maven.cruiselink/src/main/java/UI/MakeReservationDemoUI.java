package UI;

/*
 * TableSelectionDemo.java requires no other files.
 */

import Controller.ReserveRoomController;
import Domain.Guest;
import Domain.Room;
import Domain.Ship;
import Repository.ReservationDatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeReservationDemoUI extends JPanel
        implements ActionListener {

    public Ship s = new Ship();
    public Guest g = new Guest();
    public ReservationDatabase d = new ReservationDatabase();
    public ReserveRoomController rrc = new ReserveRoomController();

    private JTable table;
    private JTextArea output;
    private TableRowSorter<MyTableModel> sorter;

    private void initTester(){
        g.setName("TESTER");
        s.setName("Baylor Boat");
        Room r1 = new Room(Boolean.TRUE, Room.BedType.QUEEN,1234,2, Room.QualityLevel.EXECUTIVE);
        Room r2 = new Room(Boolean.FALSE, Room.BedType.TWIN,1235,2, Room.QualityLevel.ECONOMY);
        Room r3 = new Room(Boolean.TRUE, Room.BedType.KING,2345,1, Room.QualityLevel.BUSINESS);
        Room r4 = new Room(Boolean.TRUE, Room.BedType.TWIN,2453,3, Room.QualityLevel.ECONOMY);
        s.roomMap.put(1234,r1);
        s.roomMap.put(1235,r2);
        s.roomMap.put(2345,r3);
        s.roomMap.put(2453,r4);

        //rrc.reserveRoom(d,g,s,r1);


//        {"1234", "Yes",
//                "EXECUTIVE", "2", "QUEEN"},
//        {"1235", "No",
//                "ECONOMY", "2", "TWIN"},
//        {"2345", "Yes",
//                "BUSINESS", "1", "KING"},
//        {"2453", "Yes",
//                "ECONOMY", "3", "TWIN"},

    }
    public MakeReservationDemoUI() {
        super();
        initTester();


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        MyTableModel model = new MyTableModel();
        sorter = new TableRowSorter<>(model);
        table = new JTable(new MyTableModel());
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(800, 70));
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(new RowListener());
        table.getColumnModel().getSelectionModel().
                addListSelectionListener(new ColumnListener());
        add(new JScrollPane(table));

//        add(new JLabel("Selection Mode"));
//        buttonGroup = new ButtonGroup();
//        addRadio("Multiple Interval Selection").setSelected(true);
//        addRadio("Single Selection");
//        addRadio("Single Interval Selection");

        JButton reserveButton = new JButton("Reserve room");
        reserveButton.addActionListener(this);
        add(reserveButton);
//        add(new JLabel("Selection Options"));
//        rowCheck = addCheckBox("Row Selection");
//        rowCheck.setSelected(true);
//        columnCheck = addCheckBox("Column Selection");
//        cellCheck = addCheckBox("Cell Selection");
//        cellCheck.setEnabled(false);

        output = new JTextArea(5, 40);
        output.setEditable(false);
        add(new JScrollPane(output));
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        //Cell selection is disabled in Multiple Interval Selection
        //mode. The enabled state of cellCheck is a convenient flag
        //for this status.
        //           ArrayList<String> data = new ArrayList<>();
//            for(int i = 1; i < table.getColumnCount(); i++){
//                data.add(table.getValueAt(table.getSelectedRow(),i).toString());
//            }
//            System.out.println(data);
        if(command.equals("Reserve room")){
            String data;
            Room reserving = new Room();
            for(int i = 0; i < table.getColumnCount(); i++){
                data = (table.getValueAt(table.getSelectedRow(),i).toString());
                System.out.println(data);
                if(i == 0){
                    reserving.setRoomNumber(Integer.parseInt(data));
                }
                else if(i == 1){
                    if(data.equals("Yes")) {
                        reserving.setSmoking(Boolean.TRUE);
                    }else {
                        reserving.setSmoking(Boolean.FALSE);
                    }
                }else if(i == 2){
                    if(data.equals("EXECUTIVE")) {
                        reserving.setQualityLevel(Room.QualityLevel.EXECUTIVE);
                    } else if (data.equals("BUSINESS")) {
                        reserving.setQualityLevel(Room.QualityLevel.BUSINESS);
                    } else {
                        reserving.setQualityLevel(Room.QualityLevel.ECONOMY);
                    }
                } else if (i == 3) {
                    reserving.setNumBeds(Integer.parseInt(data));
                }else{
                    if(data.equals("QUEEN")){
                        reserving.setBedType(Room.BedType.QUEEN);
                    } else if (data.equals("TWIN")) {
                        reserving.setBedType(Room.BedType.TWIN);
                    } else if (data.equals("KING")) {
                        reserving.setBedType(Room.BedType.KING);
                    }
                }
            }
            if(s.roomMap.containsKey(reserving.getRoomNumber())){
                output.setFont(new Font("idk", Font.BOLD,10));
                output.append("-------------------------------------\n");
                output.append("room exists: trying to reserve\n");
                if(!s.roomMap.get(reserving.getRoomNumber()).getIsReserved()){
                    output.append("room is not reserved: creating reservation\n");
                    if(!d.reservationMap.containsKey(g)){
                        output.append("guest is not in reservation database: adding guest to database\n");
                    }else {
                        output.append("guest is in reservation database: adding reservation to reservation list\n");
                    }
                    rrc.reserveRoom(d,g,s,reserving);
                    reserving.setReserved(Boolean.TRUE);
                    s.roomMap.put(reserving.getRoomNumber(),reserving);
                }else {
                    output.append("room is reserved: please try another room\n");
                }
                output.append("-------------------------------------\n");
            }
        }
        //table.setRowSelectionAllowed(rowCheck.isSelected());

        //Update checkboxes to reflect selection mode side effects.
//        rowCheck.setSelected(table.getRowSelectionAllowed());
//        columnCheck.setSelected(table.getColumnSelectionAllowed());
//        if (cellCheck.isEnabled()) {
//            cellCheck.setSelected(table.getCellSelectionEnabled());
//        }
    }
    private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            //output.append("ROW SELECTION EVENT. ");
            //outputSelection();

//            ArrayList<String> data = new ArrayList<>();
//            for(int i = 1; i < table.getColumnCount(); i++){
//                data.add(table.getValueAt(table.getSelectedRow(),i).toString());
//            }
//            System.out.println(data);
        }
    }

    private class ColumnListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            //output.append("COLUMN SELECTION EVENT. ");
            //outputSelection();
        }
    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Room #",
                "isSmoking",
                "Room Quality Level",
                "# of beds",
                "Bed Type"};
        private Object[][] data = {
//                Boolean.TRUE,Room.BedType.KING,1234,2, Room.QualityLevel.EXECUTIVE
                {"1234", "Yes",
                        "EXECUTIVE", "2", "QUEEN"},
                {"1235", "No",
                        "ECONOMY", "2", "TWIN"},
                {"2345", "Yes",
                        "BUSINESS", "1", "KING"},
                {"2453", "Yes",
                        "ECONOMY", "3", "TWIN"},
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a checkbox.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public Room getRoom(){
            Room selectedRoom = new Room();

            return selectedRoom;
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
//        public boolean isCellEditable(int row, int col) {
//            //Note that the data/cell address is constant,
//            //no matter where the cell appears onscreen.
//            if (col < 2) {
//                return false;
//            } else {
//                return true;
//            }
//        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
//        public void setValueAt(Object value, int row, int col) {
//            data[row][col] = value;
//            fireTableCellUpdated(row, col);
//        }

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Disable boldface controls.
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Create and set up the window.
        JFrame frame = new JFrame("Make Reservation Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MakeReservationDemoUI newContentPane = new MakeReservationDemoUI();
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
