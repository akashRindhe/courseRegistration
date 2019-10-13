package controller;

import provider.course.CourseProvider;
import provider.student.StudentProvider;

public class CourseRegistrar {
    private final CourseProvider courseProvider;
    private final StudentProvider studentProvider;


    public CourseRegistrar(CourseProvider courseProvider, StudentProvider studentProvider) {
        this.courseProvider = courseProvider;
        this.studentProvider = studentProvider;
    }



}
