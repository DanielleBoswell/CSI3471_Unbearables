package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

public abstract class DefaultUI {
	public abstract void createAndShowGUI();
	private JMenuBar initMenu(DefaultUI model) {
		//Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem header;
		final JMenuItem menuRemove;
		JMenuItem menuCSV;
		
		
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.add(menu);
		header = new JMenuItem("COMMANDS:");
		header.setEnabled(false);
		menu.add(header);
		menuRemove = new JMenuItem("Remove");
		menuRemove.addActionListener(null);
		menu.add(menuRemove);
		menu.addSeparator();
		
		
		return menuBar;
	}
}
