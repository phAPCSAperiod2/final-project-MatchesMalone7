import java.util.ArrayList;
import java.util.List;

public abstract class MainApp {

    List<Filter> filterList = new ArrayList<>();
    List<TimerManger> timerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("hello");
    }

    void MainApp.displayMenu()

    void MainApp.promptUserForFilter();

    void MainApp.handleUserChoice();

}
