package Views;

import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javafx.scene.paint.Color.BLACK;

/**
 * Created by mgard on 6/22/2017.
 */
public class MainWindow extends JFrame {
    private JPanel panel1;
    private JButton addCoursebutton;
    private JComboBox departmentCombobox;
    private JTextField courseCodeTextField;
    private JTextField courseNameTextField;
    private JTextField creditsTextField;
    private JButton displayAllButton;
    private JButton displayByDepartmentsButton;
    private JTextArea listTextArea;

    public MainWindow() {
        this.setTitle("Courses");

        // Setup what happens when you click the close button
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set JFrame size
        this.setSize(500, 200);

        // disable window resizing
        this.setResizable(false);

        // place planel1 object which holds all the content
        this.setContentPane(panel1);

//        frame.setBounds(new EmptyBorder(10,10,10,10));

        // Window shadow
        DropShadow border = new DropShadow();
        border.setColor(BLACK);
        border.setOffsetX(150);

        addCoursebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){

                String getCoursecode = courseCodeTextField.getText();
                String getCourseName = courseNameTextField.getText();
                int getNumOfCreds = creditsTextField.;
                String getDepartment = departmentCombobox.getSelectedItem().toString();

                // TODO: add in credits. 
                if(courseCodeTextField.getText().isEmpty() || courseCodeTextField.getText().isEmpty() || ){
                    JOptionPane.showMessageDialog(null, "Need to fill in all boxes.");
                }else{
                    JOptionPane.showMessageDialog(null, "Added Course.");
                    //TODO: Add courses to list.
                    // TODO: make sure Credits are ints, 1-5
                }




                }
            });


        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        displayByDepartmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation codkdje here
    }
}

