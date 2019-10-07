package model.user;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class InstructorTest {

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
        Instructor instructor = new Instructor(id,name);

        //Act and Assert
        assertEquals(expectedResult, instructor.hashCode());
    }

    private static Stream<Arguments> equalsArguments() {
        return Stream.of(
                of(new Instructor("ID1", "Greg Wilson"), true),
                of( new Instructor("ID2", "Barney Stinson"), false),
                of(1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("equalsArguments")
    void equals( Object object, boolean expectedResult ) {
        //Arrange
        Instructor instructor1 = new Instructor( "ID1", "Greg Wilson" );

        //Act and Assert
        assertEquals(expectedResult, instructor1.equals(object));
    }

    private static Stream<Arguments> idArguments() {
        return Stream.of(
                of(new Instructor("ID1", "Greg Wilson"), "ID1"),
                of( new Instructor("ID2", "Barney Stinson"), "ID2")
        );
    }

    @ParameterizedTest
    @MethodSource("idArguments")
    void id( Instructor instructor, String expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, instructor.id());
    }

    private static Stream<Arguments> nameArguments() {
        return Stream.of(
                of(new Instructor("ID1", "Greg Wilson"), "Greg Wilson"),
                of( new Instructor("ID2", "Barney Stinson"), "Barney Stinson")
        );
    }

    @ParameterizedTest
    @MethodSource("nameArguments")
    void name( Instructor instructor, String expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, instructor.name());
    }

}