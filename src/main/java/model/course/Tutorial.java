package model.course;

import model.Location;
import model.time.TimeSlot;

public class Tutorial extends Class {
    public Tutorial(TimeSlot timeSlot) {
        super(TypeOfCourse.TUTORIAL, timeSlot);
    }
}
