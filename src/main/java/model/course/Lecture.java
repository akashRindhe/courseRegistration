package model.course;

import model.Location;
import model.time.TimeSlot;
import model.user.Instructor;

import java.util.Set;

public class Lecture extends Class {

    public Lecture(TimeSlot timeSlot, Location location) {
        super(TypeOfCourse.LECTURE, timeSlot, location);
    }
}
