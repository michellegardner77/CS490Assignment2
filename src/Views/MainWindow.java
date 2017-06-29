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
    private JFormattedTextField creditsFormattedTextField;
    private JList<String> courseJList;
    private DefaultListModel<String> courseJListModel = new DefaultListModel<>();

    private DepartmentController departmentController;

    private boolean displayByDepartment = false;

    public MainWindow() {
        this.setTitle("Courses");

        // Setup what happens when you click the close button
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set JFrame size
        this.setSize(500, 300);

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
                String courseTitleValue = courseNameTextField.getText();
                Department selectedDepartment = (Department) departmentCombobox.getSelectedItem();

                // check to see if all textfields have input
                if(courseIDValue.isEmpty() || courseTitleValue.isEmpty() ||  creditsFormattedTextField.getText().isEmpty()){
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

                // makes sure credits are between 0 and 6.
                if(courseCredsIntValue < 1 || courseCredsIntValue > 5) {
                    //check to see if credits are between 1 and 5
                    JOptionPane.showMessageDialog(panel1, "Credits must be greater than 0 and less than 6.", "Invalid Credit", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // called addCourse to add course to department
                addCourse(courseIDValue, courseTitleValue, courseCredsIntValue);
                clearInputFields();

                if(displayByDepartment){
                    refreshJListShowDeptCourses();
                }else{
                    refreshJListShowAllCourses();
                }

            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(displayByDepartment){
                    displayByDepartment = false;
                    refreshJListShowAllCourses();
                }

            }
        });

        displayByDepartmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!displayByDepartment){
                    displayByDepartment = true;
                    refreshJListShowDeptCourses();
                }

            }
        });


        departmentController = new DepartmentController();

        populateDepartmentUIList();
        departmentCombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(displayByDepartment){
                    refreshJListShowDeptCourses();
                }
            }
        });
    }

    private void populateDepartmentUIList(){
        ArrayList<Department> departmentList = departmentController.getDepartmentList();
        for(Department department : departmentList){
            departmentCombobox.addItem(department);
        }
    }

    private void addCourse(String courseID, String courseTitle, int credits){
        Department selectedDepartment = (Department) departmentCombobox.getSelectedItem();

        if(departmentController.getCourseById(courseID, selectedDepartment) != null){
            //checks to see if course already exists in department
            JOptionPane.showMessageDialog(panel1, "That course already exists!", "Course Exists", JOptionPane.ERROR_MESSAGE);
            return;
        }

        departmentController.addCourseToDepartment(courseID, courseTitle, credits, selectedDepartment);
        JOptionPane.showMessageDialog(panel1, "Course Added!", "Course Added", JOptionPane.INFORMATION_MESSAGE);
    }

    private void refreshJListShowAllCourses(){

        courseJListModel.removeAllElements();

        for(Course c : departmentController.getAllCourses()){
            courseJListModel.addElement(c.getCourseID() + "    " + c.getCourseTitle());
        }

        courseJList.setModel(courseJListModel);
    }

    private void refreshJListShowDeptCourses(){
        courseJListModel.removeAllElements();

        for(Course c : departmentController.getCourseListByDepartment((Department) departmentCombobox.getSelectedItem())){
            courseJListModel.addElement(c.getCourseID() + "    " + c.getCourseTitle());
        }

        courseJList.setModel(courseJListModel);
    }

    private void clearInputFields(){
        courseCodeTextField.setText("");
        courseNameTextField.setText("");
        creditsFormattedTextField.setText("");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}



