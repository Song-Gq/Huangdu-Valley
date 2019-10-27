
// part of "Facade" design pattern
// a Singleton role that prevents you from being stolen when awake
// scene "The Farm", by Song Guanqun
public class Guard {

    // Singleton instance
    private static Guard instance;
    private boolean sleeping;

    // private constructor
    private Guard() {
        sleeping = false;
    }

    public static Guard getInstance() {
        if(instance == null) {
            instance = new Guard();
        }
        return instance;
    }

    public void wakeup() {
        sleeping = false;
        System.out.println("Guard wakes up.");
    }

    public void stopTheft() {
        if(!sleeping) {
            System.out.println("Theft stopped!");
            sleeping = true;
        }
        else {
            System.out.println("Guard sleeping. Plants stolen!");
            System.out.println("Production - 100.");
        }
    }
}
