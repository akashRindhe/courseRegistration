package model.course;

import model.Location;
import model.time.TimeSlot;

import java.util.Objects;

public class Class {
    private final TypeOfCourse typeOfCourse;
    private final TimeSlot timeSlot;
    private final Location location;
    private final String stringRepresentation;

    public Class( TypeOfCourse typeOfCourse, TimeSlot timeSlot, Location location) {
        this.typeOfCourse = Objects.requireNonNull(typeOfCourse);
        this.timeSlot = Objects.requireNonNull(timeSlot);
        this.location = Objects.requireNonNull(location);
        this.stringRepresentation = this.timeSlot + " " + this.typeOfCourse;
    }

    TimeSlot timeSlot() {
        return this.timeSlot;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }

    public enum TypeOfCourse {
        LECTURE,
        TUTORIAL,
        LAB;
    }
}