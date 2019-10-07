package model.course;

import model.IdName;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course extends IdName<Course> {
    private final Set<Batch>batches;
    private final int points;

    public Course(String courseId, String courseName, int points, Set<Batch> batches) {
        super(courseId, courseName);
        if (points <= 0) {
            throw new IllegalArgumentException("Course points need to be greater than zero");
        }
        this.points = points;
        this.batches = Objects.requireNonNull(batches);
    }

    public int points() {
        return this.points;
    }

    public Set<Batch> getFreeBatches() {
        Set<Batch> freeBatches = new HashSet<>();
        for (Batch batch : this.batches) {
            if ( batch.getFreeSlots() > 0 ) {
                freeBatches.add(batch);
            }
        }
        if (freeBatches.isEmpty()) {
            freeBatches.add(EmptyBatch.instance);
        }
        return freeBatches;
    }
}