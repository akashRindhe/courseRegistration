package model.course;

import model.Location;
import model.time.TimeSlot;

public class Lecture extends Class {

    public Lecture(TimeSlot timeSlot) {
        super(TypeOfCourse.LECTURE, timeSlot);
    }
}
