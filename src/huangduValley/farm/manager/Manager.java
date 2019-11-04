package huangduValley.farm.manager;

import huangduValley.Stdout;
import huangduValley.workshop.wareHouse.Wallet;
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
        // plant potato by default
        plantPotatoAll();

        waterAll();
        fertilizeAll();

        harvestAll();

        wakeupGuard();

        stopTheft();

        // lands.printList();
    }

    // wake up the guard
    public void wakeupGuard() {
        Stdout.print(this, "Invoke Guard's wakeup()");
        guard.wakeup();
    }

    // try to stop theft
    public void stopTheft() throws Exception {
        Stdout.print(this, "Invoke Guard's stopTheft()");
        guard.stopTheft();
    }

    // harvest all mature plants
    public void harvestAll() throws Exception {
        lands.harvestAll();
        Stdout.print(this, "Succeeds");
    }

    // plant carrots on all lands
    public void plantCarrotAll() throws Exception {
        Wallet wallet = Wallet.getInstance();

        // decrease balance by one
        if(wallet.decreaseBalance(1)) {
            lands.plantCarrotAll();
            Stdout.print(this, "Succeeds. Wallet balance - 1");
        }
        else
            Stdout.print(this, "Failed. Wallet balance is not enough");
    }

    // plant potatoes on all lands
    public void plantPotatoAll() throws Exception {
        Wallet wallet = Wallet.getInstance();

        // decrease balance by one
        if(wallet.decreaseBalance(1)) {
            lands.plantPotatoAll();
            Stdout.print(this, "Succeeds. Wallet balance - 1");
        }
        else
            Stdout.print(this, "Failed. Wallet balance is not enough");

    }

    // add a piece of dry land
    public void addDryLand() {
        lands.addDryLand();
        Stdout.print(this, "Succeeds");
    }

    // add a piece of fertile land
    public void addFertileLand() {
        lands.addFertileLand();
        Stdout.print(this, "Succeeds");
    }

    // upgrade a piece of land by index by one grade
    // index starts from 0
    public void upgradeLand(int... index) throws Exception {
        Wallet wallet = Wallet.getInstance();

        // decrease balance by one
        if(wallet.decreaseBalance(1)) {
            for(int i: index) {
                lands.upgradeLand(i);
            }
            Stdout.print(this, "Succeeds. Wallet balance - 1");
        }
        else
            Stdout.print(this, "Failed. Wallet balance is not enough");

    }

    // this consumes water
    public void waterAll() throws Exception{
        if(fetch("Water")) {
            lands.waterAll();
            Stdout.print(this, "Succeeds");

            putback("Water");
        }
    }

    // this consumes fertilizer
    public void fertilizeAll() throws Exception{
        if(fetch("Fertilizer")) {
            lands.fertilizeAll();
            Stdout.print(this, "Succeeds");

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
            Stdout.print(this, "No " + name + " left in root bag");
            return false;
        }
        // take away all
        else {
            Stdout.print(this, "Manager takes away " +
                    items.getCount() + " " + "\"" + name + "\" into his bag");

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

            Stdout.print(this, "Manager put back " +
                    items.getCount() + " " + "\"" + name + "\"");
        }
    }

}
