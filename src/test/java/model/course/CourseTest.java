package model.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class CourseTest {

    private static Stream<Arguments> pointsArguments() {
        return Stream.of(
                of(10),
                of(2)
        );
    }

    @ParameterizedTest
    @MethodSource("pointsArguments")
    void points(int points) {
        //Arrange
        Course course = new Course("ID", "Name", points, new HashSet<>());

        //Act and Assert
        assertEquals(points, course.points());
    }

    private static Stream<Arguments> illegalPointsArguments() {
        return Stream.of(
                of(0),
                of(-2)
        );
    }

    @ParameterizedTest
    @MethodSource("illegalPointsArguments")
    void illegalPoints(int points) {
        //Arrange Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course("ID", "Name", points, new HashSet<>());
        });
    }


    private static Stream<Arguments> freeBatchesArguments() {
        return Stream.of(
                of(new HashSet<Batch>(), new HashSet<>(Collections.singletonList(EmptyBatch.instance))),
                of(new HashSet<>(Collections.singletonList(new Batch("EMPTY_BATCH", 0, Collections.EMPTY_SET, Collections.EMPTY_SET,
                          Collections.EMPTY_SET, Collections.EMPTY_SET))), new HashSet<>(Collections.singletonList(EmptyBatch.instance)
                  )),
                of(new HashSet<>(Collections.singletonList(new Batch("BATCH", 20, Collections.EMPTY_SET, Collections.EMPTY_SET,
                        Collections.EMPTY_SET, Collections.EMPTY_SET))), new HashSet<>(Collections.singletonList(new Batch("BATCH", 20, Collections.EMPTY_SET, Collections.EMPTY_SET,
                        Collections.EMPTY_SET, Collections.EMPTY_SET)))));
    }


    @ParameterizedTest
    @MethodSource("freeBatchesArguments")
    void getFreeBatches(Set<Batch> batches, Set<Batch> expectedResult) {
        //Arrange
        Course course = new Course("ID", "name", 2, batches);

        //Act and Assert
        assertEquals(expectedResult, course.getFreeBatches());
    }
}