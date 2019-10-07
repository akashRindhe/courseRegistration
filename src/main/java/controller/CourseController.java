package controller;

import model.course.Course;

import java.util.HashSet;
import java.util.Set;

public class CourseController {
    private final Set<Course> courses;

    public CourseController(Set<Course> courses) {
        this.courses = courses;
    }

    public CourseController() {
        this(new HashSet<>());
    }

    public Set<Course> courses() {
        return this.courses;
    }


}
