import java.util.ArrayList;
import java.util.Scanner;


/**
* Main application for managing air filters and countdown timers.
* Stores filters in a 2D grid of 3 rows, each containing a dynamic list of
* filters.
* Java doc comments were made by Mircosoft Copilot.
*/
public class MainApp {


   /**
    * 2D grid of filters.
    * Each of the 3 rows contains a dynamic list of {@link Filter} objects.
    */
   private ArrayList<ArrayList<Filter>> filterGrid;


   /**
    * Timer manager responsible for countdown logic and updating filter usage.
    */
   private TimerManger timer;


   /**
    * Scanner used for reading user input from the console.
    */
   private Scanner input;


   /**
    * Constructs a new MainApp instance.
    * Initializes the 3-row filter grid, the timer manager, and the input scanner.
    */
   public MainApp() {
       filterGrid = new ArrayList<>();


       // Create 3 rows
       for (int row = 0; row < 3; row++) {
           filterGrid.add(new ArrayList<>());
       }


       timer = new TimerManger();
       input = new Scanner(System.in);
   }


   /**
    * Starts the main program loop.
    * Continuously displays the menu and processes user choices until exit.
    */
   public void run() {
       boolean running = true;


       while (running) {
           displayExpirationWarnings();
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
                   resetFilter();
                   break;
               case 6:
                   running = false;
                   System.out.println("\n✓ Exiting program...\n");
                   break;
               default:
                   System.out.println("Invalid choice.");
           }
       }
   }


   /**
    * Prints the main menu options to the console.
    */
   public void displayMenu() {
       System.out.println("\n╔════ AIR FILTER TRACKER ════╗");
       System.out.println("║ 1. Create a new filter     ║");
       System.out.println("║ 2. Start countdown timer   ║");
       System.out.println("║ 3. Pause countdown timer   ║");
       System.out.println("║ 4. View filter grid        ║");
       System.out.println("║ 5. Reset a filter          ║");
       System.out.println("║ 6. Exit                    ║");
       System.out.println("╚════════════════════════════╝");
       System.out.print("Choose an option: ");
   }


   /**
    * Reads and validates the user's menu choice.
    * Ensures the input is an integer.
    *
    * @return the integer value entered by the user
    */
   public int handleUserChoice() {
       while (!input.hasNextInt()) {
           System.out.print("Please enter a number: ");
           input.next();
       }
       return input.nextInt();
   }


   /**
    * Prompts the user until they enter a non-negative integer.
    *
    * @return a valid non-negative integer
    */
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


   /**
    * Creates a new filter by prompting the user for its name and time limit.
    * The filter is then placed into a user-selected row of the grid.
    */
   public void createFilter() {
       input.nextLine(); // clear buffer


       System.out.print("Enter filter name: ");
       String name = input.nextLine();


       System.out.print("Enter time limit (hours): ");
       int limit = getPositiveInt();


       System.out.print("Choose row (1, 2, or 3): ");
       int row = getPositiveInt() - 1;


       if (row < 0 || row >= filterGrid.size()) {
           System.out.println("Invalid row.");
           return;
       }


       Filter f = new Filter(name, limit);
       filterGrid.get(row).add(f);


       System.out.println("✓ Filter added to row " + (row + 1) + ": " + f);
   }


   /**
    * Starts a countdown timer for a selected filter.
    * Prompts the user to choose a row and a filter within that row.
    * Attaches the filter to the timer and begins the countdown.
    */
   public void startTimer() {
       System.out.print("Select row (1-3): ");
       int row = getPositiveInt() - 1;


       if (row < 0 || row >= filterGrid.size()) {
           System.out.println("Invalid row.");
           return;
       }


       ArrayList<Filter> rowList = filterGrid.get(row);


       if (rowList.isEmpty()) {
           System.out.println("No filters in this row.");
           return;
       }


       System.out.println("Select a filter:");
       for (int i = 0; i < rowList.size(); i++) {
           System.out.println((i + 1) + ". " + rowList.get(i).getName());
       }


       int choice = getPositiveInt() - 1;


       if (choice < 0 || choice >= rowList.size()) {
           System.out.println("Invalid filter selection.");
           return;
       }


       Filter selected = rowList.get(choice);
       timer.attachFilter(selected);


       System.out.print("Enter countdown value (hours): ");
       int countdown = getPositiveInt();
       timer.setCountdownValue(countdown);


       timer.startCountdown();
       System.out.println("✓ Timer started for filter: " + selected.getName());
   }


   /**
    * Pauses the currently running countdown timer.
    */
   public void pauseTimer() {
       timer.pauseCountdown();
       System.out.println("✓ Timer paused.");
   }


   /**
    * Displays expiration warnings for any filters that are expired or near expiration.
    * Called at the start of each main loop iteration.
    */
   public void displayExpirationWarnings() {
       ArrayList<Filter> warningFilters = new ArrayList<>();


       for (ArrayList<Filter> row : filterGrid) {
           for (Filter f : row) {
               if (f.isExpired()) {
                   warningFilters.add(f);
               } else {
                   int used = f.getHoursUsed();
                   int limit = f.getTimeLimit();
                   int percentage = (limit > 0) ? (used * 100) / limit : 0;
                   if (percentage >= 75) {
                       warningFilters.add(f);
                   }
               }
           }
       }


       if (!warningFilters.isEmpty()) {
           System.out.println("\n⚠️  FILTER ALERTS:");
           for (Filter f : warningFilters) {
               if (f.isExpired()) {
                   System.out.println("   🔴 '" + f.getName() + "' has EXPIRED!");
               } else {
                   int used = f.getHoursUsed();
                   int limit = f.getTimeLimit();
                   int percentage = (used * 100) / limit;
                   System.out.println("   🟠 '" + f.getName() + "' is " + percentage + "% used. Replace soon!");
               }
           }
           System.out.println();
       }
   }
    /**
     * Displays all filters in the 3-row grid.
     * Shows each row and the filters stored within it.
     */
    public void viewFilters() {
        System.out.println("\n=== FILTER GRID STATUS ===");

        for (int row = 0; row < filterGrid.size(); row++) {
            System.out.println("Row " + (row + 1) + ":");

            ArrayList<Filter> rowList = filterGrid.get(row);

            if (rowList.isEmpty()) {
                System.out.println("  (no filters)");
            } else {
                for (Filter f : rowList) {
                    System.out.println("  " + f);
                }
            }
        }
    }

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new MainApp().run();
    }
}
