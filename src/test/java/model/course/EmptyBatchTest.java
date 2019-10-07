package model.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyBatchTest {

    @Test
    void numberOfFreeSlots() {
        assertEquals(0, EmptyBatch.instance.getFreeSlots());
    }

    @Test
    void string() {
        assertTrue( EmptyBatch.instance.toString().toLowerCase().contains("no empty batches") );
    }
}