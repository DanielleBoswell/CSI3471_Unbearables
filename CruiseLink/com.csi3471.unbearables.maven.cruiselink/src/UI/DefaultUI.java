package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

public class DefaultUI extends JPanel{
	protected static Font titleFont = new Font("Comic Sans MS", Font.BOLD, 18);
	public DefaultUI(){
		super();
	}
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("TableFilterDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        DefaultUI newContentPane = new DefaultUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
	public JPanel initSideMenu() {
		JPanel side = new JPanel();
		side.setLayout(new GridLayout(0,1));
		JLabel Menu = new JLabel("Menu");
		side.add(Menu);
		
		return side;
	}
	
	public static void runGUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	protected static Font getTitleFont() {
		return titleFont;
	}
}
