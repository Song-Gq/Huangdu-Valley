package huangduValley.farm.manager;

import huangduValley.farm.Stdout;
import huangduValley.farm.storage.Items;
import huangduValley.farm.storage.RootBag;

// part of "Facade" design pattern
// a Singleton role that prevents you from being stolen when awake
// scene "Farm", by Song Guanqun
public class Guard {

    // Singleton instance
    private static Guard instance;
    private boolean sleeping;

    // private constructor
    private Guard() {
        sleeping = true;
    }

    public static Guard getInstance() {
        if(instance == null) {
            instance = new Guard();
        }
        return instance;
    }

    public void wakeup() {
        sleeping = false;
        Stdout.print(this, "Guard wakes up");
    }

    public void stopTheft() throws Exception {
        if(!sleeping) {
            Stdout.print(this, "Theft was stopped");
            sleeping = true;
        }
        else {
            RootBag rootBag = RootBag.getInstance();
            // steal carrot by default
            Items carrot = rootBag.getItems("Carrot");
            if(carrot != null) {
                if(carrot.getCount() > 100) {
                    Stdout.print(this, "Guard is sleeping, " +
                        "100" + " carrots were stolen");
                    carrot.setCount(carrot.getCount() - 100);
                }
                else {
                    Stdout.print(this, "Guard is sleeping, " +
                            carrot.getCount() + " carrots were stolen");
                    rootBag.deleteItems("Carrot");
                }

            }
            // no carrot left in root bag
            else {
                Stdout.print(this, "Guard is sleeping, " +
                        "but no carrot left, so no carrot was thieved");
            }
        }
    }
}
