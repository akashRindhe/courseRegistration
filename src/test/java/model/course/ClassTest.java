package model.course;

import model.time.HourAndMinutes;
import model.time.StartAndEndTime;
import model.time.TimeSlot;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ClassTest {

    private static Stream<Arguments> toStringArguments() {
        return  Stream.of(
                of(Class.TypeOfCourse.LECTURE,
                        new TimeSlot(DayOfWeek.MONDAY,
                                new StartAndEndTime( new HourAndMinutes( 11,30),
                                        new HourAndMinutes(12,30))), "MONDAY 11:30 - 12:30 LECTURE"),
                of(Class.TypeOfCourse.LAB,
                        new TimeSlot(DayOfWeek.WEDNESDAY,
                                new StartAndEndTime( new HourAndMinutes( 13,30),
                                        new HourAndMinutes(14,45))), "WEDNESDAY 13:30 - 14:45 LAB")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringArguments")
    void toString(Class.TypeOfCourse typeOfCourse, TimeSlot timeSlot, String expectedResult) {
        //Arrange
        Class testSubject = new Class(typeOfCourse, timeSlot);

        //Act and Assert
        assertEquals( expectedResult, testSubject.toString() );
    }
}