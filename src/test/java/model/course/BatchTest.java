package model.course;

import model.user.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
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
}