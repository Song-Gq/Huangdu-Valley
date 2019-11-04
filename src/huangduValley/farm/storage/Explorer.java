package huangduValley.farm.storage;

import huangduValley.Stdout;

// part of "Facade" design pattern
// a class to manage the storage system using Singleton
// scene "Farm", by Song Guanqun
public class Explorer {
    // current farm.storage.Bag which the player is in
    private Bag curBag;
    // the singleton instance
    private static Explorer instance;

    // private constructor
    private Explorer() {
        // initialize curBag with farm.storage.RootBag
        curBag = RootBag.getInstance();
    }

    // get the singleton instance
    public static Explorer getInstance() {
        if(instance == null) {
            instance = new Explorer();
        }
        return instance;
    }

    // change curBag into a new one
    public void into(String name) throws Exception {
        Bag bag = curBag.getBag(name);
        // farm.storage.Bag not found
        if(bag == null) {
            throw new Exception("Bag not found");
        }

        curBag = bag;
        Stdout.print(this, "Explorer is now into Bag \"" +
                curBag.getName() + "\"");
    }

    // back to the parent bag
    public void back() throws Exception {
        // already at root bag
        if(curBag.getOuterBag() == null)
            throw new Exception("back() at root");

        curBag = curBag.getOuterBag();
        Stdout.print(this, "Explorer is now back to Bag \"" +
                curBag.getName() + "\"");
    }

    // add a new farm.storage.Items Object in the current bag
    public void addItems(String name, int count) throws Exception {
        curBag.add(new Items(name, count));
        Stdout.print(this, "Addition of Items \"" +
                name + "\" with count " + count + " succeeds");
    }

    // add a new farm.storage.Bag Object in the current bag
    public void addBag(String name) throws Exception {
        curBag.add(new Bag(name, curBag));
        Stdout.print(this, "Addition of Bag \"" + name + "\" succeeds");
    }

    // delete farm.storage.Items in the current bag by name
    public void deleteItems(String name) throws Exception {
        curBag.deleteItems(name);
    }

    // delete farm.storage.Bag in the current bag by name
    public void deleteBag(String name) throws Exception {
        curBag.deleteBag(name);
    }

    // returns current farm.storage.Bag
    public Bag getCurBag() {
        return curBag;
    }

    // returns an farm.storage.Items Object by name in the current bag
    public Items getItems(String name) {
        return curBag.getItems(name);
    }

    // returns a farm.storage.Bag Object by name in the current bag
    public Bag getBag(String name) {
        return curBag.getBag(name);
    }

    // back to the root
    public void backRoot() {
        curBag = RootBag.getInstance();
        Stdout.print(this, "Explorer is now at root");
    }

}
