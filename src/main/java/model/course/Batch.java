package model.course;

import model.user.Student;

import java.util.*;

public class Batch {
    private final String id;
    private final int batchSize;
    private final Set<Class> fullSchedule;
    private final Set<Lecture> lectures;
    private final Set<Lab> labs;
    private final Set<Tutorial> tutorials;
    private Set<Student> registeredStudents;
    private final String schedule;

    Batch(String id, int batchSize, Set<Lecture> lectures,
          Set<Lab> labs, Set<Tutorial> tutorials, Set<Student> registeredStudents) {
        this.id = Objects.requireNonNull(id);
        this.batchSize = batchSize;
        this.lectures = Collections.unmodifiableSet(Objects.requireNonNull(lectures));
        this.labs = Objects.requireNonNull(labs);
        this.tutorials = Objects.requireNonNull(tutorials);
        this.registeredStudents = Objects.requireNonNull(registeredStudents);
        this.fullSchedule = new TreeSet<>(
                Comparator.comparing(firstClass -> firstClass.timeSlot));
        this.fullSchedule.addAll(this.lectures);
        this.fullSchedule.addAll(this.labs);
        this.fullSchedule.addAll(this.tutorials);
        StringBuilder stringBuilder = new StringBuilder();
        for ( Class clazz : this.fullSchedule ) {
            stringBuilder.append(clazz);
            stringBuilder.append("\n");
        }
        this.schedule = stringBuilder.toString();
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
        return id +" : Slots Left - " + getFreeSlots();
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

    public String schedule() {
        return this.schedule;
    }
}
