package jframes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mgard on 6/22/2017.
 */
public class MainJFrame extends JFrame {
    // will have all UI logic to create the window in the constructor
    // will also have private methods for the button pressed


    public MainJFrame(String title){
        //Set the Jframes (Frames) title
        super(title);
        //Set the JFrame Size
        setSize(800, 500);
        // tell the JFrame what to do on Exit
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Move JFrame starting position to middle of Screen.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 -  this.getSize().width / 2, dim.height/2 - this.getSize().height /2 );
    }
}
