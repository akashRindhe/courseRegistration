package model.time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class TimeSlotTest {

    private static Stream<Arguments> overlapsWithArguments() {
        return Stream.of(
                of(DayOfWeek.WEDNESDAY, new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30 ), true),
                of(DayOfWeek.WEDNESDAY, new HourAndMinutes(11, 0),
                        new HourAndMinutes(12, 0), true),
                of(DayOfWeek.WEDNESDAY, new HourAndMinutes(11, 30),
                        new HourAndMinutes(12, 0), true),
                of(DayOfWeek.WEDNESDAY, new HourAndMinutes(11, 45),
                        new HourAndMinutes(12, 45), true),
                of(DayOfWeek.THURSDAY, new HourAndMinutes(11, 0),
                        new HourAndMinutes(12, 0), false)
        );
    }

    @ParameterizedTest
    @MethodSource("overlapsWithArguments")
    void overlapsWith(DayOfWeek dayOfWeek, HourAndMinutes startTime,
                      HourAndMinutes endTime, boolean expectedResult ) {
        //Arrange
        TimeSlot timeSlot = new TimeSlot(DayOfWeek.WEDNESDAY,
                new HourAndMinutes(11,0), new HourAndMinutes(12,0));

        //Act and Assert
        assertEquals( expectedResult, timeSlot.overlapsWith( new TimeSlot(dayOfWeek, startTime, endTime) ) );
    }

    private static Stream<Arguments> toStringArguments() {
        return Stream.of(
                of(DayOfWeek.WEDNESDAY, new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30 ), "WEDNESDAY 10:30 - 11:30"),
                of(DayOfWeek.FRIDAY, new HourAndMinutes(11, 0),
                        new HourAndMinutes(12, 0), "FRIDAY 11:0 - 12:0")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringArguments")
    void toString(DayOfWeek dayOfWeek, HourAndMinutes startTime,
                      HourAndMinutes endTime, String expectedResult ) {
        //Arrange
        TimeSlot timeSlot = new TimeSlot(dayOfWeek, startTime,endTime);

        //Act and Assert
        assertEquals( expectedResult, timeSlot.toString() );
    }

    private static Stream<Arguments> compareToArguments() {
        return Stream.of(
                of(DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        DayOfWeek.THURSDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        -1),
                of(DayOfWeek.SUNDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        DayOfWeek.MONDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        1),
                of(DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 31),
                        new HourAndMinutes(11, 30),
                        -1),
                of(DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 29),
                        new HourAndMinutes(11, 30),
                        1),
                of(DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        DayOfWeek.WEDNESDAY,
                        new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30),
                        0)
        );
    }

    @ParameterizedTest
    @MethodSource("compareToArguments")
    void compareTo( DayOfWeek firstDayOfWeek,
                    HourAndMinutes firstStartTime,
                    HourAndMinutes firstEndTime,
                    DayOfWeek secondDayOfWeek,
                    HourAndMinutes secondStartTime,
                    HourAndMinutes secondEndtime,
                    int expectedResult ) {
        //Arrange
        TimeSlot testSubject = new TimeSlot( firstDayOfWeek, new StartAndEndTime(firstStartTime,firstEndTime));
        TimeSlot comparisonObject = new TimeSlot(secondDayOfWeek, new StartAndEndTime(secondStartTime,secondEndtime));

        //Act
        int result = testSubject.compareTo(comparisonObject);

        //Assert
        assertEquals( expectedResult, result );
    }

}