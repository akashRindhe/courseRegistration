package model.time;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Objects;

/**
 * Entity to store DayOfWeek and Start and End times
 * of a class
 */
public class TimeSlot implements Comparable<TimeSlot>{
    private final DayOfWeek dayOfWeek;
    private final StartAndEndTime startAndEndTime;
    private final String stringRepresentation;

    public TimeSlot(DayOfWeek dayOfWeek, StartAndEndTime startAndEndTime) {
        this.dayOfWeek = Objects.requireNonNull(dayOfWeek);
        this.startAndEndTime = Objects.requireNonNull(startAndEndTime);
        this.stringRepresentation = this.dayOfWeek + " " + this.startAndEndTime;
    }

    public TimeSlot(DayOfWeek dayOfWeek, HourAndMinutes startTime, HourAndMinutes endTime) {
        this(dayOfWeek, new StartAndEndTime(startTime,endTime));
    }

    public TimeSlot(DayOfWeek dayOfWeek, int startHour, int startMinutes, int endHour, int endMinutes) {
        this(dayOfWeek, new HourAndMinutes(startHour, startMinutes), new HourAndMinutes(endHour, endMinutes));
    }

    /**
     * Method to avoid two classes with clashing slots
     * @param timeSlot
     * @return
     */
    public boolean overlapsWith(TimeSlot timeSlot) {
        return this.dayOfWeek == timeSlot.dayOfWeek && timeSlot.startAndEndTime.overlapsWith(startAndEndTime);
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }

    @Override
    public int compareTo(TimeSlot timeSlot) {
        if ( this.dayOfWeek.compareTo( timeSlot.dayOfWeek ) == 0 ) {
            return this.startAndEndTime.compareTo( timeSlot.startAndEndTime );
        }
        return Integer.compare(this.dayOfWeek.compareTo( timeSlot.dayOfWeek ), 0);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TimeSlot)) {
            return false;
        }
        TimeSlot timeSlot = (TimeSlot)o;
        return this.dayOfWeek.equals(timeSlot.dayOfWeek) &&
                this.startAndEndTime.equals(timeSlot.startAndEndTime);
    }

    @Override
    public int hashCode() {
        int hashcode = this.dayOfWeek.hashCode()*31;
        hashcode = (hashcode + this.startAndEndTime.hashCode()) * 31;
        return hashcode;
    }

}