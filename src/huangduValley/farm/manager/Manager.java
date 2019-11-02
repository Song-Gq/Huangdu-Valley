package huangduValley.farm.manager;

import huangduValley.farm.land.Lands;
import huangduValley.farm.storage.Bag;
import huangduValley.farm.storage.Items;
import huangduValley.farm.storage.RootBag;

// part of "Facade" design pattern
// a singleton class representing a role that
// can do a lot as your request
// scene "The huangduValley.farm.Farm", by Song Guanqun
public class Manager {

    // Singleton instance
    private static Manager instance;
    // the manager's bag
    private Bag managerBag;
    // root bag instance
    private RootBag rootBag;
    // farm instance
    private Lands lands;
    // guard instance
    private Guard guard;

    // private constructor
    private Manager() throws Exception {
        rootBag = RootBag.getInstance();
        lands = Lands.getInstance();
        guard = Guard.getInstance();
        managerBag = new Bag("Manager's Bag", rootBag);
    }

    public static Manager getInstance() throws Exception {
        if(instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    // plant, water, fertilize, harvest the plants,
    // and wake up the guard for you
    public void doAll() throws Exception {
        lands.plantAll();

        waterAll();
        fertilizeAll();

        lands.harvestAll();

        guard.wakeup();

        lands.printList();
        lands.upgradeLand(1);
        lands.printList();
        lands.addDryLand();
        lands.addFertileLand();
    }

    // this consumes water
    public void waterAll() throws Exception{
        if(fetch("Water")) {
            lands.waterAll();
            putback("Water");
        }
    }

    // this consumes fertilizer
    public void fertilizeAll() throws Exception{
        if(fetch("Fertilizer")) {
            lands.fertilizeAll();
            putback("Fertilizer");
        }
    }

    // take something, like Water or Fertilizer
    // from rootBag of the huangduValley.farm.storage.Storage into the manager's bag
    // huangduValley.farm.storage.Items in child bags will not be fetched
    private boolean fetch(String name) throws Exception {
        Items items = rootBag.getItems(name);
        // none left
        if(items == null) {
            System.out.println("No " + name + " left in the root bag.");
            return false;
        }
        // take away all
        else {
            rootBag.deleteItems(name);
            managerBag.add(items);
            return true;
        }
    }

    private void putback(String name) throws Exception {
        Items items = managerBag.getItems(name);
        managerBag.deleteItems(name);
        if(items.getCount() > 1) {
            items.setCount(items.getCount() - 1);
            RootBag rootBag = RootBag.getInstance();
            rootBag.add(items);
        }
    }

}
