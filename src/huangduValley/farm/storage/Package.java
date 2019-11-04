package huangduValley.farm.storage;

// this class is part of "Composite" design pattern
// parent class of farm.storage.Items and farm.storage.Bag
// scene "Farm", by Song Guanqun
public abstract class Package {

    public abstract String getName();
    public abstract int getCount();
    public abstract void printList();
}
