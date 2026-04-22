public class MainApp {
    public static void main(String[] args) {

        Filter airFilter = new Filter("Living Room Filter", 100);
        System.out.println("New filter created:");
        System.out.println(airFilter);
        System.out.println();

        System.out.println("Adding 30 hours of usage...");
        airFilter.addUsage(30);
        System.out.println(airFilter);
        System.out.println();

        System.out.println("Adding 50 more hours...");
        airFilter.addUsage(50);
        System.out.println(airFilter);
        System.out.println();

        System.out.println("Is the filter expired?");
        System.out.println(airFilter.isExpired());
        System.out.println();

        System.out.println("Adding 40 more hours...");
        airFilter.addUsage(40);
        System.out.println(airFilter);
        System.out.println("Expired now?");
        System.out.println(airFilter.isExpired());
        System.out.println();

        System.out.println("Resetting usage...");
        airFilter.resetUsage();
        System.out.println(airFilter);
    }
    // *****example for the one class*****
}
