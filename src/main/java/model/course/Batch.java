package model.course;

import model.user.Student;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Batch {
    private final String id;
    private final int batchSize;
    private final Set<Lecture> lectures;
    private final Set<Lab> labs;
    private final Set<Tutorial> tutorials;
    private Set<Student> registeredStudents;

    Batch(String id, int batchSize, Set<Lecture> lectures,
          Set<Lab> labs, Set<Tutorial> tutorials, Set<Student> registeredStudents) {
        this.id = Objects.requireNonNull(id);
        this.batchSize = batchSize;
        this.lectures = Objects.requireNonNull(lectures);
        this.labs = Objects.requireNonNull(labs);
        this.tutorials = Objects.requireNonNull(tutorials);
        this.registeredStudents = Objects.requireNonNull(registeredStudents);
    }

    public Batch(String id, int batchSize, Set<Lecture> lectures,
                 Set<Lab> labs, Set<Tutorial> tutorials) {
        this(id, batchSize, lectures, labs, tutorials, new HashSet<>());
    }

    public int getFreeSlots() {
        return batchSize - registeredStudents.size();
    }

    @Override
    public String toString() {
        return id +":  Slots Left - " + getFreeSlots();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Batch)) {
            return false;
        }
        Batch batch = (Batch)o;
        return this.id.equals(batch.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
