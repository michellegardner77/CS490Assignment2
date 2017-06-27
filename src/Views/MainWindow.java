package Views;

import Controllers.DepartmentController;
import Models.Course;
import Models.Department;
import javafx.scene.effect.DropShadow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javafx.scene.paint.Color.BLACK;

/**
 * Created by mgard on 6/22/2017.
 */
public class MainWindow extends JFrame {
    private JPanel panel1;
    private JButton addCoursebutton;
    private JComboBox<Department> departmentCombobox;
    private JTextField courseCodeTextField;
    private JTextField courseNameTextField;
    private JButton displayAllButton;
    private JButton displayByDepartmentsButton;
    private JTextArea listTextArea;
    private JFormattedTextField creditsFormattedTextField;

    private DepartmentController departmentController;

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
                //read input for each input field
                String courseIDValue = courseCodeTextField.getText();
                String courseNameValue = courseNameTextField.getText();
                Department selectedDepartment = (Department) departmentCombobox.getSelectedItem();

                // check to see if all textfields have input
                if(courseIDValue.isEmpty() || courseNameValue.isEmpty() ||  creditsFormattedTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(panel1, "Please provide required information.", "Empty Fields", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int courseCredsIntValue = 0;
                try{
                // Makes sure the number is valid
                    courseCredsIntValue = Integer.parseInt(creditsFormattedTextField.getText());
                }catch(Exception ex){
                    //check to see if credits are between 1 and 5
                    JOptionPane.showMessageDialog(panel1, "Number of credits must be a number greater than 0 and less than 6.", "Invalid Credit", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if(courseCredsIntValue < 0 || courseCredsIntValue > 5) {
                    //check to see if credits are between 1 and 5
                    JOptionPane.showMessageDialog(panel1, "Credits must be greater than 0 and less than 6.", "Invalid Credit", JOptionPane.ERROR_MESSAGE);
                    return;
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


        departmentController = new DepartmentController();

        populateDepartmentUIList();
    }

    private void populateDepartmentUIList(){
        ArrayList<Department> departmentList = departmentController.getDepartmentList();
        for(Department department : departmentList){
            departmentCombobox.addItem(department);
        }
    }

    private void addCourse(String courseID, String courseTitle, int credits){
        Department selectedDepartment = (Department) departmentCombobox.getSelectedItem();
        departmentController.addCourseToDepartment(courseID, courseTitle, credits, selectedDepartment);
    }

    private void createUIComponents() {
        // TODO: place custom component creation codkdje here
    }
}



