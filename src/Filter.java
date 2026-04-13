/**
 * The Filter class represents one air filter the user wants to track.
 * It stores the filter's name, its time limit, and how many hours
 * have already been used. This class does not handle countdown logic.
 * All java doc comments will be attributed to Mircosoft Copilot
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

    // under contruction, for the constructors.

}
