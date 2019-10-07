package controller;

import model.course.Course;

import java.util.Set;

public interface CourseManager {

    boolean addCourse();

    Set<Course> getCourses();

    boolean removeCourse();

}
