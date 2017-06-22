package Models;

import java.util.List;

/**
 * Created by mgard on 6/21/2017.
 */
public class Course {

    private String courseID;
    private String courseTitle;
    private int credits;
    private Department department = null;

    public Course(String courseID, String courseTitle, int credits, Department department){
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.department = department;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCredits() {
        return credits;
    }

    public Department getDepartment(){
        return department;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
