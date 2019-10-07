package controller;

import provider.CourseProvider;
import provider.StudentProvider;

public class CourseRegistrar {
    private final CourseProvider courseProvider;
    private final StudentProvider studentProvider;


    public CourseRegistrar(CourseProvider courseProvider, StudentProvider studentProvider) {
        this.courseProvider = courseProvider;
        this.studentProvider = studentProvider;
    }



}
