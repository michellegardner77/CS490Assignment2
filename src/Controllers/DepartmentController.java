package Controllers;

import Models.Course;
import Models.Department;

import java.util.ArrayList;

/**
 * Created by mgard on 6/23/2017.
 */
public class DepartmentController {
    ArrayList<Department> departmentList = new ArrayList<>();


    // When the Department controller is created, we are pre-filling the list with hardcoded items.
    public DepartmentController() {
        departmentList.add(new Department("CS", "Computer Science"));
        departmentList.add(new Department("ZO", "Zoology"));
        departmentList.add(new Department("CH", "Chemistry"));
    }

    // department list methods and business logic
    // create, read, update, delete (CRUD)

    //creating a department with a department
    public void createDepartment(String id, String title, int credits, Department department) {
        departmentList.add(new Department(id, title));
    }

    // method to get a course by id
    public Department getDepartmentById(String id){
        for (Department course : departmentList) {
            if(course.getDepartmentID() == id ){
                return course;
            }
        }
        return null;
    }

    // method to get a department by the title
    public Department getDepartmentByTitle(String title){
        for (Department course : departmentList) {
            if(course.getDepartmentName() == title){
                return course;
            }
        }
        return null;
    }

    // method to get all courses
    public ArrayList<Department> getDepartmentList(){
        return departmentList;
    }

    //creating a new course with a department
    public void addCourseToDepartment(String id, String title, int credits, Department department) {
        Department foundDepartment = getDepartmentById(department.getDepartmentID());
        if(foundDepartment != null){
            foundDepartment.addCourse(new Course(id, title, credits, department));
        }
    }

    // method to get a course by id
    public Course getCourseById(String courseId, Department department){
        for (Course course : department.getCourseList()) {
            if(course.getCourseID() == courseId ){
                return course;
            }
        }
        return null;
    }

    // method to get a course by the title
    public Course getCourseByTitle(String courseTitle, Department department){
        for (Course course : department.getCourseList()) {
            if(course.getCourseID() == courseTitle ){
                return course;
            }
        }
        return null;
    }

    // method to get all courses
    public ArrayList<Course> getCourseListByDepartment(Department department){
        return department.getCourseList();
    }

    // method to get all courses
    public ArrayList<Course> getAllCourses(){
        ArrayList<Course> coursesList = new ArrayList<>();

        // looping through the departments and putting all the courses into an array list of courses.
        for (Department department:departmentList) {
            coursesList.addAll(department.getCourseList());
        }

        return coursesList;
    }

    public void updateCourse(Course course, Department department){
        ArrayList<Course> courseList = department.getCourseList();

        for(int i = 0; i < courseList.size(); i++){
            if (courseList.get(i).getCourseID() == course.getCourseID()) {
                courseList.set(i, course);
            }
        }
    }
}
