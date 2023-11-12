package UI;

import javax.swing.*;
import java.awt.*;

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
