package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class IdNameTest {

    private static Stream<Arguments> idArguments() {
        return Stream.of(
                of("ID1", "Greg Wilson", "ID1"),
                of("ID2", "Barney Stinson", "ID2")
        );
    }

    @ParameterizedTest
    @MethodSource("idArguments")
    void id( String id, String name, String expectedResult) {
        //Arrange
        IdName idName = new IdName(id, name) {
            @Override
            public String id() {
                return super.id();
            }
        };
        //Act and Assert
        assertEquals(expectedResult, idName.id());
    }

    private static Stream<Arguments> nameArguments() {
        return Stream.of(
                of("ID1", "Greg Wilson", "Greg Wilson"),
                of( "ID2", "Barney Stinson", "Barney Stinson")
        );
    }

    @ParameterizedTest
    @MethodSource("nameArguments")
    void name( String id, String name, String expectedResult) {
        //Arrange
        IdName idName = new IdName(id, name) {
            @Override
            public String id() {
                return super.id();
            }
        };
        //Act and Assert
        assertEquals(expectedResult, idName.name());
    }

    private static Stream<Arguments> toStringArguments() {
        return Stream.of(
                of("ID1", "Greg Wilson", "ID1 : Greg Wilson"),
                of( "ID2", "Barney Stinson", "ID2 : Barney Stinson")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringArguments")
    void toString(String id, String name, String expectedResult) {
        //Arrange
        IdName idName = new IdName(id, name) {
            @Override
            public String id() {
                return super.id();
            }
        };

        //Act and Assert
        assertEquals(expectedResult, idName.toString());
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