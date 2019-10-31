package huangduValley.farm.storage;

// this class is part of "Composite" design pattern
// parent class of huangduValley.farm.storage.Items and huangduValley.farm.storage.Bag
// scene "The huangduValley.farm.Farm", by Song Guanqun
public abstract class Package {

    public abstract String getName();
    public abstract int getCount();
    public abstract void printList();
}
