package huangduValley.farm.storage;

// part of "Facade" design pattern
// a class to manage the storage system using Singleton
// scene "The huangduValley.farm.Farm", by Song Guanqun
public class Storage {
    // current huangduValley.farm.storage.Bag which the player is in
    private Bag curBag;
    // the singleton instance
    private static Storage instance;

    // private constructor
    private Storage() {
        // initialize curBag with huangduValley.farm.storage.RootBag
        curBag = RootBag.getInstance();
    }

    // get the singleton instance
    public static Storage getInstance() {
        if(instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    // change curBag into a new one
    public void into(String name) throws Exception {
        Bag bag = curBag.getBag(name);
        // huangduValley.farm.storage.Bag not found
        if(bag == null) {
            throw new Exception("huangduValley.farm.storage.Bag not found");
        }

        curBag = bag;
    }

    // back to the parent bag
    public void back() throws Exception {
        // already at root bag
        if(curBag.getOuterBag() == null)
            throw new Exception("back() at root");

        curBag = curBag.getOuterBag();
    }

    // add a new huangduValley.farm.storage.Items Object in the current bag
    public void addItems(String name, int count) throws Exception {
        curBag.add(new Items(name, count));
    }

    // add a new huangduValley.farm.storage.Bag Object in the current bag
    public void addBag(String name) throws Exception {
        curBag.add(new Bag(name, curBag));
    }

    // delete huangduValley.farm.storage.Items in the current bag by name
    public void deleteItems(String name) throws Exception {
        curBag.deleteItems(name);
    }

    // delete huangduValley.farm.storage.Bag in the current bag by name
    public void deleteBag(String name) throws Exception {
        curBag.deleteBag(name);
    }

    // returns current huangduValley.farm.storage.Bag
    public Bag getCurBag() {
        return curBag;
    }

    // returns an huangduValley.farm.storage.Items Object by name in the current bag
    public Items getItems(String name) {
        return curBag.getItems(name);
    }

    // returns a huangduValley.farm.storage.Bag Object by name in the current bag
    public Bag getBag(String name) {
        return curBag.getBag(name);
    }

    // collect seeds of the given count
/*    public ArrayList<huangduValley.farm.storage.Items> collectSeed(int count) {

    }*/
}
