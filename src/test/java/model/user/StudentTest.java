package model.user;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class StudentTest {

    private static Stream<Arguments> hashCodeArguments() {
        return Stream.of(
                of("ID1", "Greg Wilson", "ID1".hashCode()),
                of("ID2", "Barney Stinson", "ID2".hashCode())
        );
    }

    @ParameterizedTest
    @MethodSource("hashCodeArguments")
    void hashCode(String id, String name, int expectedResult) {
        //Arrange
        Student Student = new Student(id,name);

        //Act and Assert
        assertEquals(expectedResult, Student.hashCode());
    }

    private static Stream<Arguments> equalsArguments() {
        return Stream.of(
                of(new Student("ID1", "Greg Wilson"), true),
                of( new Student("ID2", "Barney Stinson"), false),
                of(1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("equalsArguments")
    void equals( Object object, boolean expectedResult ) {
        //Arrange
        Student student = new Student( "ID1", "Greg Wilson" );

        //Act and Assert
        assertEquals(expectedResult, student.equals(object));
    }

    private static Stream<Arguments> idArguments() {
        return Stream.of(
                of(new Student("ID1", "Greg Wilson"), "ID1"),
                of( new Student("ID2", "Barney Stinson"), "ID2")
        );
    }

    @ParameterizedTest
    @MethodSource("idArguments")
    void id( Student student, String expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, student.id());
    }

    private static Stream<Arguments> nameArguments() {
        return Stream.of(
                of(new Student("ID1", "Greg Wilson"), "Greg Wilson"),
                of( new Student("ID2", "Barney Stinson"), "Barney Stinson")
        );
    }

    @ParameterizedTest
    @MethodSource("nameArguments")
    void name( Student student, String expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, student.name());
    }
}