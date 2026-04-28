/**
 * Manages a countdown timer associated with a Filter.
 * Handles starting, pausing, and tracking countdown progress.
 * Java doc comments were made by Mircosoft Copilot.
 */
public class TimerManger {

    /**
     * The current countdown value in hours or minutes,
     * depending on how the program defines time units.
     */
    private int countdownValue;

    /**
     * Indicates whether the countdown timer is actively running.
     */
    private boolean isRunning;

    /**
     * The filter currently attached to this timer manager.
     * The timer updates this filter's usage as time passes.
     */
    private Filter currentFilter;

    /**
     * Creates a new TimerManager with no active filter,
     * a countdown value of zero, and a stopped timer.
     */
    public TimerManger() {
        this.countdownValue = 0;
        this.isRunning = false;
        this.currentFilter = null;
    }

    /**
     * Attaches a filter to the timer manager so that countdown
     * progress can update the filter's usage.
     *
     * @param filter the Filter object to attach
     */
    public void attachFilter(Filter filter) {
        this.currentFilter = filter;
    }

    /**
     * Starts the countdown timer if it is not already running
     * and the countdown value is greater than zero.
     */
    public void startCountdown() {
        if (!isRunning && countdownValue > 0) {
            isRunning = true;
        }
    }

    /**
     * Pauses the countdown timer by setting the running state to false.
     * Once paused, the timer will not decrement until restarted.
     */
    public void pauseCountdown() {
        isRunning = false;
    }

    /**
     * Performs one countdown step.
     * If the timer is running and time remains, this method:
     * - Decrements the countdown value by 1
     * - Applies the attached filter (if one exists)
     * - Stops the timer automatically when the countdown reaches zero
     *
     * This method should be called repeatedly (inside a loop or timer)
     * to simulate the passage of time.
     */
    public void tick() {
        if (isRunning && countdownValue > 0) {
            countdownValue--;

            if (currentFilter != null) {
                currentFilter.updateTimeUsed(1);
            }

            if (countdownValue == 0) {
                isRunning = false;
            }
        }
    }

    /**
     * Checks if the countdown has finished
     * 
     * @return true if countdownValue is 0, false otherwise
     */
    public boolean isFinished() {
        return countdownValue == 0;
    }

    // Getters and Setters

    /**
     * Returns the current countdown value.
<<<<<<< HEAD
     * 
     * @return the remaining countdown value
=======
     *
     * @return the countdown value as an integer
>>>>>>> 5381e5f90fb8a51d479a51805107902cead3e81c
     */
    public int getCountdownValue() {
        return countdownValue;
    }

    /**
<<<<<<< HEAD
     * Sets the countdown value if the provided value is non‑negative.
     * 
=======
     * Sets the countdown value, ensuring it is not negative.
     * Values below zero are ignored.
     *
>>>>>>> 5381e5f90fb8a51d479a51805107902cead3e81c
     * @param value the new countdown value to set
     */
    public void setCountdownValue(int value) {
        if (value >= 0) {
            this.countdownValue = value;
        }
    }

    /**
<<<<<<< HEAD
     * Indicates whether the countdown timer is currently running.
     * 
     * @return true if the timer is running, false otherwise
=======
     * Indicates whether the countdown or timer is currently running.
     *
     * @return true if running, false otherwise
>>>>>>> 5381e5f90fb8a51d479a51805107902cead3e81c
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
<<<<<<< HEAD
     * Returns the filter currently attached to the timer manager.
     * 
     * @return the active Filter, or null if none is attached
=======
     * Returns the currently active filter.
     *
     * @return the current {@code Filter} instance, or null if none is set
>>>>>>> 5381e5f90fb8a51d479a51805107902cead3e81c
     */
    public Filter getCurrentFilter() {
        return currentFilter;
    }
}

