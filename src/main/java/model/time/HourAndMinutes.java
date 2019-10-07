package model.time;

/**
 * Entity to store hours and minutes - HH:MM in the 24 hour format.
 * Implements comparable for time comparison.
 */
public final class HourAndMinutes implements Comparable{
    private final int hour;
    private final int minutes;
    private final String stringRepresentation;
    private static final String INCORRECT_HOUR_ARGUMENT = "Incorrect hours - 0 <= hours < 24";
    private static final String INCORRECT_MINUTE_ARGUMENT = "Incorrect minutes - 0 <= minutes < 60";

    public HourAndMinutes(int hour, int minutes) {
        if ( 0 > hour || hour > 23  ) {
            throw new IllegalArgumentException(INCORRECT_HOUR_ARGUMENT);
        } else if (0 > minutes || minutes > 59) {
            throw new IllegalArgumentException(INCORRECT_MINUTE_ARGUMENT );
        }
        this.hour = hour;
        this.minutes = minutes;
        this.stringRepresentation = hour + ":" + minutes;
    }

    @Override
    public int compareTo(Object o) {
        if (!( o instanceof HourAndMinutes)) {
            throw new IllegalArgumentException("Invalid comparison");
        }
        HourAndMinutes hourAndMinutes = (HourAndMinutes)o;
        if ( this.hour <  hourAndMinutes.hour || ( this.hour == hourAndMinutes.hour && this.minutes < hourAndMinutes.minutes ) )
            return -1;
        else if (this.hour > hourAndMinutes.hour || this.minutes > hourAndMinutes.minutes)
            return 1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!( o instanceof HourAndMinutes)) {
            return false;
        }
        HourAndMinutes hourAndMinutes = (HourAndMinutes)o;
        return this.hour == hourAndMinutes.hour && this.minutes == hourAndMinutes.minutes;
    }

    @Override
    public int hashCode() {
        int hash = this.hour * 33;
        hash = (hash + minutes) * 33;
        return hash;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }

    /**
     * Gives the time difference between the
     * passed parameter and current time.
     * Difference is calculated as hourAndMinutes - this.
     * @param hourAndMinutes
     * @return
     */
    public HourAndMinutes differenceFrom( HourAndMinutes hourAndMinutes ) {
        //TODO - be able to handle negative durations
        int hourDifference = hourAndMinutes.hour - this.hour;
        int minutesDifference = hourAndMinutes.minutes - this.minutes;
        if (minutesDifference < 0) {
            hourDifference -= 1;
            minutesDifference += 60;
        }
        return new HourAndMinutes(hourDifference, minutesDifference);
    }
}