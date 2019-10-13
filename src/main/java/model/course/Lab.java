package model.course;

import model.Location;
import model.time.TimeSlot;

public class Lab extends Class {

    public Lab(TimeSlot timeSlot) {
        super(TypeOfCourse.LAB, timeSlot);
    }
}
