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
     *
     */
    public void pauseCountdown() {

    }

    /**
     *
     */
    public void tick() {

    }

    /**
     *
     */
    public void isFinshed() {

    }
}
