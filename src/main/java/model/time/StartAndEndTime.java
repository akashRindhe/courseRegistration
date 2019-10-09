package model.time;

import java.util.Objects;

/**
 * Entity to store start and end times of classes
 */
public class StartAndEndTime implements Comparable<StartAndEndTime>{
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

    public HourAndMinutes startTime() {
        return this.startTime;
    }

    public HourAndMinutes endTime() {
        return this.endTime;
    }

    public boolean overlapsWith(StartAndEndTime startAndEndTime) {
        HourAndMinutes otherStartTime = startAndEndTime.startTime();
        HourAndMinutes otherEndTime = startAndEndTime.endTime();

        // Start and end times are equal
        if ( this.startTime.equals(otherStartTime) && this.endTime.equals(otherEndTime) )
            return true;

        if ( this.startTime.compareTo(otherStartTime) > 0 && this.startTime.compareTo(otherEndTime) < 0 )
            return true;

        if ( this.endTime.compareTo(otherStartTime) > 0 && this.endTime.compareTo(otherEndTime) < 0 )
            return true;

        if ( otherStartTime.compareTo(this.startTime) > 0 && otherStartTime.compareTo(this.endTime) < 0 )
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

    @Override
    public int compareTo(StartAndEndTime startAndEndTime) {
        if ( this.startTime.compareTo(startAndEndTime.startTime) == 0 ) {
            return this.endTime.compareTo( startAndEndTime.endTime );
        }
        return this.startTime.compareTo(startAndEndTime.startTime);
    }
}
