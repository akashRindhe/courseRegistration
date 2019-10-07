package model.time;

import java.util.Objects;

/**
 * Entity to store start and end times of classes
 */
public class StartAndEndTime {
    private final HourAndMinutes startTime;
    private final HourAndMinutes endTime;
    private final String stringRepresentation;

    public StartAndEndTime(HourAndMinutes startTime, HourAndMinutes endTime) {
        this.startTime = Objects.requireNonNull(startTime);
        this.endTime = Objects.requireNonNull(endTime);
        if ( startTime.compareTo(endTime) >= 0 ) {
            throw new IllegalArgumentException( "Start time should be lesser than End Time - Start Time="
                    + startTime.toString() + " End Time=" + endTime.toString() );
        }
        this.stringRepresentation = this.startTime + " - " + this.endTime;
    }

    public boolean overlapsWith(StartAndEndTime startAndEndTime) {
        // Start and end times are equal
        if ( startTime.equals(startAndEndTime.startTime) && endTime.equals(startAndEndTime.endTime) )
            return true;

        if ( startTime.compareTo(startAndEndTime.startTime) > 0 && startTime.compareTo(startAndEndTime.endTime) < 0 )
            return true;

        if ( endTime.compareTo(startAndEndTime.startTime) > 0 && endTime.compareTo(startAndEndTime.endTime) < 0 )
            return true;

        if ( startAndEndTime.startTime.compareTo(startTime) > 0 && startAndEndTime.startTime.compareTo(endTime) < 0 )
            return true;
        return false;
    }

    /**
     * Duration of StartAndEndTime object.
     * EndTime - StartTime
     * @return
     */
    public HourAndMinutes duration() {
        return this.startTime.differenceFrom(this.endTime);
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
