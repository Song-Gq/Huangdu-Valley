import java.util.ArrayList;

// a Singleton version of Bag
// representing the root bag (like root directory) in the player's storage
// scene "The Farm", by Song Guanqun
public class RootBag extends Bag {

    // the singleton instance
    private static RootBag instance;

    // private constructor
    private RootBag() {
        super();
    }

    // get the singleton instance
    public static RootBag getInstance() {
        if(instance == null) {
            instance = new RootBag();
        }
        return instance;
    }

}
