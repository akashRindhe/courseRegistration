package model.time;

import java.time.DayOfWeek;
import java.util.Objects;

/**
 * Entity to store DayOfWeek and Start and End times
 * of a class
 */
public class TimeSlot {
    private final DayOfWeek dayOfWeek;
    private final StartAndEndTime startAndEndTime;
    private final String stringRepresentation;

    private TimeSlot(DayOfWeek dayOfWeek, StartAndEndTime startAndEndTime) {
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
}