package model.course;

import java.util.Collections;

public final class EmptyBatch extends Batch{
    static final Batch instance = new EmptyBatch();

    private EmptyBatch() {
        super("EMPTY_BATCH", 0, Collections.EMPTY_SET, Collections.EMPTY_SET,
                Collections.EMPTY_SET, Collections.EMPTY_SET);
    }

    @Override
    public String toString() {
        return "No Empty Batches for this course";
    }
}