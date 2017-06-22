package Models;

import java.util.List;

/**
 * Created by mgard on 6/21/2017.
 */
public class Department {

    private String departmentId;
    private String departmentName;
    private List<Course> courseList = null;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

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
}
