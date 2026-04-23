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
     * This method should be called repeatedly (e.g., inside a loop or timer)
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
     * Determines whether the countdown has reached zero.
     *
     * @return true if no time remains in the countdown; false otherwise
     */
    public boolean isFinished() {
        return countdownValue == 0;
    }

}
