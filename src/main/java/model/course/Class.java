package model.course;

import model.time.TimeSlot;

import java.util.Objects;

public class Class {
    private final TypeOfCourse typeOfCourse;
    private final TimeSlot timeSlot;
    private final String stringRepresentation;

    public Class(TypeOfCourse typeOfCourse, TimeSlot timeSlot) {
        this.typeOfCourse = Objects.requireNonNull(typeOfCourse);
        this.timeSlot = Objects.requireNonNull(timeSlot);
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

    @Override
    public boolean equals(Object o) {
        if ( !( o instanceof Class ) ) {
            return false;
        }
        Class clazz = (Class)o;
        return this.typeOfCourse.equals(clazz.typeOfCourse) && this.timeSlot.equals( clazz.timeSlot );
    }

    @Override
    public int hashCode() {
        int hashCode = this.typeOfCourse.hashCode() * 31;
        hashCode = (hashCode + this.timeSlot.hashCode())*31;
        return hashCode;
    }
}