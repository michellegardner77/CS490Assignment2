package Views;

import Models.Course;
import Models.Department;
import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
    private JButton displayAllButton;
    private JButton displayByDepartmentsButton;
    private JTextArea listTextArea;
    private JFormattedTextField creditsFormattedTextField;

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

        NumberFormat numberFormat = NumberFormat.getIntegerInstance(); // Specify specific format here.
        numberFormat.setMinimumIntegerDigits(0);
        numberFormat.setMaximumIntegerDigits(1);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(numberFormatter);
        creditsFormattedTextField.setFormatterFactory(factory);

        // Window shadow
        DropShadow border = new DropShadow();
        border.setColor(BLACK);
        border.setOffsetX(150);

        addCoursebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                //read input for each textfield
                String getCoursecode = courseCodeTextField.getText();
                String getCourseName = courseNameTextField.getText();
                int getNumOfCreds = Integer.parseInt(creditsFormattedTextField.getText());
                String getDept = departmentCombobox.getSelectedItem().toString();

                // check to see if all textfields have input
                if(courseCodeTextField.getText().isEmpty() || courseNameTextField.getText().isEmpty() || getNumOfCreds == 0 ){
                    JOptionPane.showMessageDialog(null, "Need to fill in all boxes.");
                }else if(getNumOfCreds < 0 || getNumOfCreds >5) {
                    //check to see if credits are between 1 and 5
                    JOptionPane.showMessageDialog(null, "Credits must be between 1 and 5.");
                }
//                else{
//                    //add course to list of courses in department
//                    Course course = new Course(getCoursecode,getCourseName, getNumOfCreds, getDept);
//                    this.addCourse(course);
//                    JOptionPane.showMessageDialog(null, "Added Course.");
//                    listTextArea.display(getDept.getDepartmentID());
//                }

            }
        });



        //TODO:display the list within the scrollpane
        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display a list of all Departments and courses within
//                Department selectedDepartment = departmentCombobox.getValue();
//                listTextArea.display();

            }
        });
        displayByDepartmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display single department with its related courses
//                Department selectedDepartment = departmentCombobox.getValue();
//                listTextArea.display(selectedDepartment.getDepartmentID());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation codkdje here
    }
}



