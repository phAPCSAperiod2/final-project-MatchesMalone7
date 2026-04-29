import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    /** Stores multiple filters (simple 1D list version) */
    private ArrayList<Filter> filters;

    /** Timer manager for countdown logic */
    private TimerManger timer;

    /** Scanner for user input */
    private Scanner input;

    public MainApp() {
        filters = new ArrayList<>();
        timer = new TimerManger();
        input = new Scanner(System.in);
    }

    /** Starts the program loop */
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = handleUserChoice();

            switch (choice) {
                case 1:
                    createFilter();
                    break;
                case 2:
                    startTimer();
                    break;
                case 3:
                    pauseTimer();
                    break;
                case 4:
                    viewFilters();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /** Prints the menu */
    public void displayMenu() {
        System.out.println("\n=== AIR FILTER TRACKER ===");
        System.out.println("1. Create a new filter");
        System.out.println("2. Start countdown timer");
        System.out.println("3. Pause countdown timer");
        System.out.println("4. View filter status");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    /** Validates integer input */
    public int handleUserChoice() {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a number: ");
            input.next();
        }
        return input.nextInt();
    }

    /** Creates a new filter and adds it to the list */
    public void createFilter() {
        input.nextLine(); // clear buffer

        System.out.print("Enter filter name: ");
        String name = input.nextLine();

        System.out.print("Enter time limit (hours): ");
        int limit = getPositiveInt();

        Filter f = new Filter(name, limit);
        filters.add(f);

        System.out.println("Filter created: " + f);
    }

    /** Ensures user enters a positive integer */
    private int getPositiveInt() {
        int value = -1;
        while (value < 0) {
            while (!input.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                input.next();
            }
            value = input.nextInt();
            if (value < 0) {
                System.out.print("Number must be non-negative: ");
            }
        }
        return value;
    }

    /** Starts the timer for a selected filter */
    public void startTimer() {
        if (filters.isEmpty()) {
            System.out.println("No filters available. Create one first.");
            return;
        }
    }
}
