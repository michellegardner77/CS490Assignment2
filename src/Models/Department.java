package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgard on 6/21/2017.
 */
public class Department {

    private String departmentID;
    private String departmentName;
    private ArrayList<Course> courseList = null;

    public Department(String departmentId, String departmentName) {
        this.departmentID = departmentId;
        this.departmentName = departmentName;
    }


    public String getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList<Course> getCourseList() { return courseList; }

    //remove from array list by ID.
    public void removeCourse(String courseID){
        courseList.removeIf(course -> course.getCourseID().equals(courseID));
    }

    //Remove from Array List by object
    public void removeCourse(Course course){
        courseList.remove(course);
    }

    public void addCourse(Course course){
        this.courseList.add(course); // added a new course to the courseList ArrayList
    }


    //Display courses to the related Department
    public List<Course> displayCourses() {
        return courseList;
    }

    //check if an ID matches to one in the list
    public boolean isDepartmentID(String ID){
        return this.departmentID.equals(ID);
    }

    public String toString(){
        return departmentID;
    }
}
