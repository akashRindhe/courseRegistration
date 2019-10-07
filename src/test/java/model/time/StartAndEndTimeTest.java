package model.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class StartAndEndTimeTest {

    private static Stream<Arguments> overlapsWithTestArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30),
                        new HourAndMinutes(11, 30 ), true),
                of(new HourAndMinutes(11, 0),
                        new HourAndMinutes(12, 0), true),
                of(new HourAndMinutes(10,0),
                        new HourAndMinutes(11,0), false),
                of(new HourAndMinutes(0,0),
                        new HourAndMinutes(1,30), false),
                of(new HourAndMinutes(10,0),
                        new HourAndMinutes(12,0), true),
                of(new HourAndMinutes(11,15),
                        new HourAndMinutes(11,45), true),
                of(new HourAndMinutes(11,15),
                        new HourAndMinutes(12,45), true),
                of(new HourAndMinutes(12,0),
                        new HourAndMinutes(12,45), false),
                of(new HourAndMinutes(10,0),
                        new HourAndMinutes(12,30), true)
        );
    }

    @ParameterizedTest
    @MethodSource("overlapsWithTestArguments")
    void overlapsWith(HourAndMinutes startTime, HourAndMinutes endTime, boolean expectedResult ) {
        //Arrange
        StartAndEndTime startAndEndTime = new StartAndEndTime(startTime, endTime);
        StartAndEndTime testSubject = new StartAndEndTime( new HourAndMinutes( 11, 0 ),
                new HourAndMinutes(12,0) );

        //Act and Assert
        assertEquals(expectedResult, testSubject.overlapsWith( startAndEndTime ));
    }

    @Test
    void illegalStartAndEndTime() {
        int startHour = ThreadLocalRandom.current().nextInt(1, 24);
        int endHour = ThreadLocalRandom.current().nextInt(0, startHour);
        int startMinute = ThreadLocalRandom.current().nextInt(1, 60);
        int endMinute = ThreadLocalRandom.current().nextInt(0, startMinute);
        HourAndMinutes startTime = new HourAndMinutes(startHour,startMinute);
        HourAndMinutes endTime = new HourAndMinutes(endHour, endMinute);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new StartAndEndTime(startTime, endTime);
        });
    }


    private static Stream<Arguments> durationArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30),
                        new HourAndMinutes(13, 30 ), new HourAndMinutes(3,0)),
                of(new HourAndMinutes(11, 0),
                        new HourAndMinutes(12, 0), new HourAndMinutes(1,0)),
                of(new HourAndMinutes(10,15),
                        new HourAndMinutes(11,0), new HourAndMinutes(0, 45)));
    }

    @ParameterizedTest
    @MethodSource("durationArguments")
    void duration(HourAndMinutes startTime, HourAndMinutes endTime, HourAndMinutes expectedResult){
        //Arrange
        StartAndEndTime testSubject = new StartAndEndTime(startTime, endTime);

        //Act and Assert
        assertEquals(expectedResult, testSubject.duration());
    }

    private static Stream<Arguments> toStringArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30),
                        new HourAndMinutes(13, 30 ), "10:30 - 13:30"),
                of(new HourAndMinutes(11, 0),
                        new HourAndMinutes(12, 0), "11:0 - 12:0"),
                of(new HourAndMinutes(10,15),
                        new HourAndMinutes(11,0), "10:15 - 11:0"));
    }

    @ParameterizedTest
    @MethodSource("toStringArguments")
    void toString(HourAndMinutes startTime, HourAndMinutes endTime, String expectedResult){
        //Arrange
        StartAndEndTime testSubject = new StartAndEndTime(startTime, endTime);

        //Act and Assert
        assertEquals(expectedResult, testSubject.toString());
    }

}