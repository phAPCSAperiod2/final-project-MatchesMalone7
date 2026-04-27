/**
 * The Filter class represents one air filter the user wants to track.
 * It stores the filter's name, its time limit, and how many hours
 * have already been used. This class does not handle
 * countdown logic (in TimerManger).
 * Java doc comments were made by Mircosoft Copilot.
 */
public class Filter {

    /** The name or label of the filter. */
    private String nameOfFilter;

    /** The total number of hours the filter should last. */
    private int timeLimit;

    /** The number of hours the filter has been used so far. */
    private int hoursUsed;

    /**
     * Constructs a new Filter with a name and a time limit.
     * hoursUsed starts at 0.
     *
     * @param nameOfFilter the name of the filter
     * @param timeLimit    the number of hours the filter should last
     */
    public Filter(String nameOfFilter, int timeLimit) {
        this.nameOfFilter = nameOfFilter;
        this.timeLimit = timeLimit;
        this.hoursUsed = 0;
    }

    /** @return the filter's name */
    public String getName() {
        return nameOfFilter;
    }

    /** Sets a new name for the filter. */
    public void setName(String newName) {
        this.nameOfFilter = newName;
    }

    /** @return the time limit of the filter */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * Sets a new time limit for the filter.
     *
     * @param newLimit the new number of hours the filter should last
     */
    public void setTimeLimit(int newLimit) {
        this.timeLimit = newLimit;
    }

    /** @return how many hours the filter has been used */
    public int getHoursUsed() {
        return hoursUsed;
    }

    /**
     * Adds usage hours to the filter.
     *
     * @param hours the number of hours to add
     */
    public void addUsage(int hours) {
        hoursUsed += hours;
    }

    /** Resets the filter's usage back to zero. */
    public void resetUsage() {
        hoursUsed = 0;
    }

    /**
     * Checks whether the filter has reached or exceeded its time limit.
     *
     * @return true if the filter is expired, false otherwise
     */
    public boolean isExpired() {
        return hoursUsed >= timeLimit;
    }

    /**
     * Returns a readable summary of the filter's status.
     *
     * @return a string describing the filter
     */
    @Override
    public String toString() {
        return "Filter: " + nameOfFilter +
                " | Used: " + hoursUsed + " / " + timeLimit + " hours" +
                (isExpired() ? " (EXPIRED)" : "");
    }

    /**
     * Updating the time of the filter being used.
     *
     * @param i
     */
    public void updateTimeUsed(int i) {
        addUsage(i);
    }
}
