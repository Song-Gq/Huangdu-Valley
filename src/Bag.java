import java.util.ArrayList;

// this class is part of "Composite" design patter
// representing bags (like folders) in the player's storage
// scene "The Farm", by Song Guanqun
public class Bag extends Package {

    protected String name;
    // the list of items and child bags in the bag
    protected ArrayList<Package> itemList;
    // the parent bag
    private Bag outerBag;

    // default constructor
    public Bag(String name, Bag outerBag) throws Exception {
        // illegal name or outerBag
        if(name == null)
            throw new Exception("parameter \"name\" null");
        if(outerBag == null)
            throw new Exception("parameter \"outerBag\" null");

        this.name = name;
        this.outerBag = outerBag;
        itemList = new ArrayList<>();
    }

    // constructor for RootBag
    protected Bag() {
        this.name = "root";
        this.outerBag = null;
        itemList = new ArrayList<>();
    }

    // remove all Items and Bags in itemList
    // maybe no need
/*    private void removeAllContent() {
        while(!itemList.isEmpty()) {
            if (itemList.get(itemList.size() - 1) instanceof Items)
                itemList.remove(itemList.size() - 1);

                // an instance of Bag, delete its content first
                // and then remove it form itemList
            else {
                ((Bag) itemList.get(itemList.size() - 1)).removeAllContent();
                itemList.remove(itemList.size() - 1);
            }
        }
    }*/

    @Override
    public String getName() {
        return name;
    }

    // get total count of the items in the bag
    // items in the child bags not included
    @Override
    public int getCount() {
        int cnt = 0;
        for (Package p: itemList) {
            if(p instanceof Items) {
                cnt += p.getCount();
            }
        }
        return cnt;
    }

    // print the name of items and child bags in this bag
    @Override
    public void printList() {
        for (Package p: itemList) {
            System.out.println(p.getName());
        }
    }

    // add a bag or items
    public void add(Package newPack) throws Exception {
        // illegal package
        if(newPack == null)
            throw new Exception("parameter \"pack\" null");

        for (Package p: itemList) {
            // package of the same name already exists
            if(p.getName().equals(newPack.getName())) {
                // Items with the same name
                // add up the count
                if(newPack instanceof Items && p instanceof Items) {
                    ((Items) p).setCount(p.getCount() + newPack.getCount());
                }

                // Bag with the same name
                // throw an exception
                else if(newPack instanceof Bag && p instanceof Bag) {
                    throw new Exception("Bag name already exists");
                }
            }
        }

        itemList.add(newPack);
    }

    public void deleteItems(String name) throws Exception {
        for (Package p: itemList) {
            if(p instanceof Items && p.getName().equals(name)) {
                itemList.remove(p);
                // deleted
                return;
            }
        }

        // not found
        throw new Exception("Items not found");
    }

    public void deleteBag(String name) throws Exception {
        for (Package p: itemList) {
            if(p instanceof Bag && p.getName().equals(name)) {
                // delete its content first
                // and then remove it form itemList
                // maybe no need
                //((Bag) p).removeAllContent();
                itemList.remove(p);
                // deleted
                return;
            }
        }

        // not found
        throw new Exception("Bag not found");
    }

    // returns an Items Object by name
    public Items getItems(String name) {
        for (Package p: itemList) {
            if(p instanceof Items && p.getName().equals(name)) {
                // found
                return (Items) p;
            }
        }

        // not found
        return null;
    }

    // returns a Bag Object by name
    public Bag getBag(String name) {
        for (Package p: itemList) {
            if(p instanceof Bag && p.getName().equals(name)) {
                // found
                return (Bag) p;
            }
        }

        // not found
        return null;
    }

    // returns outerBag
    public Bag getOuterBag() {
        return outerBag;
    }

}
