package model.course;

import model.Location;
import model.time.TimeSlot;
import model.user.Instructor;

import java.util.Set;

public class Class {
    final TypeOfCourse typeOfCourse;
    final TimeSlot timeSlot;
    final Set<Instructor> instructors;
    final Location location;

    public Class( TypeOfCourse typeOfCourse, TimeSlot timeSlot, Set<Instructor> instructors, Location location) {
        this.typeOfCourse = typeOfCourse;
        this.timeSlot = timeSlot;
        this.instructors = instructors;
        this.location = location;
    }



    public enum TypeOfCourse {
        LECTURE,
        TUTORIAL,
        LAB;
    }
}
