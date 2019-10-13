package model.course;

import model.time.HourAndMinutes;
import model.time.StartAndEndTime;
import model.time.TimeSlot;
import model.user.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class BatchTest {

    private static Stream<Arguments> freeSlotsArguments() {
        return Stream.of(
                of(10, new HashSet<Student>(), 10),
                of(2, new HashSet<>(Collections.singletonList(new Student("ID", "ABC"))), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("freeSlotsArguments")
    void getFreeSlots(int initalCapacity, Set<Student> registeredStudents, int expectedResult) {
        //Arrange
        Batch batch =  new Batch("ID", initalCapacity, Collections.EMPTY_SET, Collections.EMPTY_SET,
                Collections.EMPTY_SET, registeredStudents);

        //Act and Assert
        assertEquals(expectedResult, batch.getFreeSlots());
    }

    private static Stream<Arguments> toStringArguments() {
        return Stream.of(
                of("ID1", 10, new HashSet<Student>(), "ID1 : Slots Left - 10"),
                of("ID2", 2, new HashSet<>(Collections.singletonList(new Student("ID", "ABC"))), "ID2 : Slots Left - 1")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringArguments")
    void toString(String id, int initalCapacity, Set<Student> registeredStudents, String expectedResult) {
        //Arrange
        Batch batch =  new Batch(id, initalCapacity, Collections.EMPTY_SET, Collections.EMPTY_SET,
                Collections.EMPTY_SET, registeredStudents);

        //Act and Assert
        assertEquals(expectedResult, batch.toString());
    }

    private static Stream<Arguments> equalsArguments() {
        return Stream.of(
                of( new Batch("ID1", 10, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.EMPTY_SET), true),
                of(new Batch("ID2", 10, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.EMPTY_SET), false),
                of(1, false));
    }

    @ParameterizedTest
    @MethodSource("equalsArguments")
    void equals(Object o, boolean expectedResult) {
        //Arrange
        Batch batch =  new Batch("ID1", 10, Collections.EMPTY_SET, Collections.EMPTY_SET,
                Collections.EMPTY_SET);

        //Act and Assert
        assertEquals(expectedResult, batch.equals(o));
    }

    private static Stream<Arguments> printableScheduleArguments() {
        return Stream.of(
                of( new Batch("ID1", 10,
                        new HashSet<>(Collections.singletonList( new Lecture(new TimeSlot(DayOfWeek.WEDNESDAY,
                                new StartAndEndTime( new HourAndMinutes( 11,30),
                                        new HourAndMinutes(12,30)))))),
                        new HashSet<>(Collections.singletonList( new Lab(new TimeSlot(DayOfWeek.MONDAY,
                                new StartAndEndTime( new HourAndMinutes( 11,30),
                                        new HourAndMinutes(12,30)))))),
                                new HashSet<>(Collections.singletonList( new Tutorial(new TimeSlot(DayOfWeek.TUESDAY,
                                        new StartAndEndTime( new HourAndMinutes( 11,30),
                                                new HourAndMinutes(12,30))))))),
                        "MONDAY 11:30 - 12:30 LAB" + "\n" +
                                "TUESDAY 11:30 - 12:30 TUTORIAL" + "\n" +
                                "WEDNESDAY 11:30 - 12:30 LECTURE" + "\n"
                        ));
    }

    @ParameterizedTest
    @MethodSource("printableScheduleArguments")
    void printableSchedule(Batch batch, String expectedResult) {
        //Arrange, Act and Assert
        assertEquals( expectedResult, batch.printableSchedule() );
    }

}