package model.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class HourAndMinutesTest {

    private static Stream<Arguments> comparisonTestArguments() {
        return Stream.of(
                of(11, 0, -1),
                of(10,30,0),
                of(10,29,1),
                of(10,31,-1),
                of(0,0,1),
                of(23,59,-1)
        );
    }

    @ParameterizedTest
    @MethodSource("comparisonTestArguments")
    void validComparison( int hours, int minutes, int expectedResult ) {
        //Arrange
        HourAndMinutes testSubject = new HourAndMinutes(10,30);
        HourAndMinutes comparisonObject = new HourAndMinutes(hours,minutes);

        //Act
        int result = testSubject.compareTo(comparisonObject);

        //Assert
        assertEquals( expectedResult, result );
    }

    @Test
    void invalidComparison() {
        HourAndMinutes testSubject = new HourAndMinutes(10,30);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testSubject.compareTo(10);
        });
    }

    private static Stream<Arguments> equalsTestArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30), true),
                of(new HourAndMinutes(10, 29), false),
                of(new HourAndMinutes(0,0), false),
                of(1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("equalsTestArguments")
    void equals( Object o, boolean expectedResult ) {
        //Arrange
        HourAndMinutes hourAndMinutes = new HourAndMinutes(10,30);

        //Act and Assert
        assertEquals(expectedResult, hourAndMinutes.equals(o));
    }

    private static Stream<Arguments> illegalConstructorArguments() {
        return Stream.of(
                of(-1,30),
                of(24,10),
                of(0,-1),
                of(12,60)
        );
    }

    @ParameterizedTest
    @MethodSource("illegalConstructorArguments")
    void illegalHoursAndMinutes( int hours, int minutes ) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new HourAndMinutes(hours,minutes);
        });
    }

    private static Stream<Arguments> stringArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30), "10:30"),
                of(new HourAndMinutes(0, 29), "0:29"),
                of(new HourAndMinutes(22,0), "22:0"),
                of(new HourAndMinutes(23,59), "23:59")
        );
    }

    @ParameterizedTest
    @MethodSource("stringArguments")
    void toString(HourAndMinutes hourAndMinutes, String expectedResult ) {
        assertEquals(expectedResult, hourAndMinutes.toString());
    }

    private static Stream<Arguments> differenceFromArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30), new HourAndMinutes(1,15)),
                of(new HourAndMinutes(9, 29), new HourAndMinutes(0,14)),
                of(new HourAndMinutes(9, 15), new HourAndMinutes(0,0)),
                of(new HourAndMinutes(10,0), new HourAndMinutes(0,45))
        );
    }

    @ParameterizedTest
    @MethodSource("differenceFromArguments")
    void differenceFrom(HourAndMinutes hourAndMinutes, HourAndMinutes expectedResult ) {
        //Arrange
        HourAndMinutes testSubject = new HourAndMinutes(9,15);

        //Act and Assert
        assertEquals(expectedResult, testSubject.differenceFrom(hourAndMinutes));
    }

    private static Stream<Arguments> hashCodeArguments() {
        return Stream.of(
                of(new HourAndMinutes(10, 30), new HourAndMinutes(10,30), true),
                of(new HourAndMinutes(9, 0), new HourAndMinutes(0,9), false),
                of(new HourAndMinutes(1, 1), new HourAndMinutes(1,1), true)
        );
    }

    @ParameterizedTest
    @MethodSource("hashCodeArguments")
    void hashCode(HourAndMinutes testSubject1, HourAndMinutes testSubject2, boolean expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, testSubject1.hashCode() == testSubject2.hashCode());
    }
}