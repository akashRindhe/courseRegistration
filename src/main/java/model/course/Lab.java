package model.course;

import model.Location;
import model.time.TimeSlot;
import model.user.Instructor;

import java.util.Set;

public class Lab extends Class {

    public Lab(TimeSlot timeSlot, Set<Instructor> instructors, Location location) {
        super(TypeOfCourse.LAB, timeSlot, instructors, location);
    }
}
