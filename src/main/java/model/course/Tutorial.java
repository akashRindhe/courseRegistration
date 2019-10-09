package model.course;

import model.Location;
import model.time.TimeSlot;
import model.user.Instructor;

import java.util.Set;

public class Tutorial extends Class {
    public Tutorial(TimeSlot timeSlot, Location location) {
        super(TypeOfCourse.TUTORIAL, timeSlot, location);
    }
}
