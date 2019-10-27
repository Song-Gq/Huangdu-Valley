
// part of "Facade" design pattern
// a class to manage the storage system using Singleton
// scene "The Farm", by Song Guanqun
public class Storage {
    // current Bag which the player is in
    private Bag curBag;
    // the singleton instance
    private static Storage instance;

    // private constructor
    private Storage() {
        // initialize curBag with RootBag
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
        // Bag not found
        if(bag == null) {
            throw new Exception("Bag not found");
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

    // add a new Items Object in the current bag
    public void addItems(String name, int count) throws Exception {
        curBag.add(new Items(name, count));
    }

    // add a new Bag Object in the current bag
    public void addBag(String name) throws Exception {
        curBag.add(new Bag(name, curBag));
    }

    // delete Items in the current bag by name
    public void deleteItems(String name) throws Exception {
        curBag.deleteItems(name);
    }

    // delete Bag in the current bag by name
    public void deleteBag(String name) throws Exception {
        curBag.deleteBag(name);
    }

    // returns current Bag
    public Bag getCurBag() {
        return curBag;
    }

    // returns an Items Object by name in the current bag
    public Items getItems(String name) {
        return curBag.getItems(name);
    }

    // returns a Bag Object by name in the current bag
    public Bag getBag(String name) {
        return curBag.getBag(name);
    }

    // collect seeds of the given count
/*    public ArrayList<Items> collectSeed(int count) {

    }*/
}
