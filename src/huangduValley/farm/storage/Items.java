package huangduValley.farm.storage;

// this is part of "Composite" design pattern
// representing items (like files) in the player's storage
// scene "Farm", by Song Guanqun
public class Items extends Package {

    private String name;
    private int count;

    // constructor
    public Items(String name, int count) throws Exception {
        // illegal count or name
        if(count <= 0)
            throw new Exception("parameter \"count\" < 0");
        if(name == null)
            throw new Exception("parameter \"name\" null");

        this.name = name;
        this.count = count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) throws Exception {
        // illegal count
        if(count <= 0)
            throw new Exception("parameter \"count\" <= 0");

        this.count = count;
    }

    // here the item list contains only the item itself
    @Override
    public void printList() {
        System.out.println(name);
    }
}
