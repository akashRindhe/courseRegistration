package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class LocationTest {

    private static Stream<Arguments> idArguments() {
        return Stream.of(
                of(new Location("ID1", "Greg Wilson"), "ID1"),
                of( new Location("ID2", "Barney Stinson"), "ID2")
        );
    }

    @ParameterizedTest
    @MethodSource("idArguments")
    void id( Location location, String expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, location.id());
    }

    private static Stream<Arguments> nameArguments() {
        return Stream.of(
                of(new Location("ID1", "Greg Wilson"), "Greg Wilson"),
                of( new Location("ID2", "Barney Stinson"), "Barney Stinson")
        );
    }

    @ParameterizedTest
    @MethodSource("nameArguments")
    void name( Location location, String expectedResult ) {
        //Arrange Act and Assert
        assertEquals(expectedResult, location.name());
    }

    @Test
    void testToString() {
    }

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
        IdName idName = new IdName(id, name) {
            @Override
            public String id() {
                return super.id();
            }
        };

        //Act and Assert
        assertEquals(expectedResult, idName.hashCode());
    }

}