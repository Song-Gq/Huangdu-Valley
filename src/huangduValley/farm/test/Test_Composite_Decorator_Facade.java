package huangduValley.farm.test;

import huangduValley.farm.land.*;
import huangduValley.farm.manager.Manager;
import huangduValley.farm.storage.Explorer;

// this includes main method for testing scene "Farm" by Song Guanqun
public class Test_Composite_Decorator_Facade {

    public static void main(String[] args) throws Exception
    {
        // composite and storage
        Explorer explorer = Explorer.getInstance();

        explorer.addItems("carrotSeed", 1);
        explorer.addItems("potatoSeed", 2);
        explorer.addBag("myLittleBag");
        explorer.into("myLittleBag");
        explorer.addBag("testBag");
        //explorer.addBag("testBag");
        explorer.into("testBag");
        //explorer.addItems("testItems", -1);
        explorer.addItems("testItems", 100);
        explorer.addItems("testItems", 3);
        explorer.getItems("testItems").setCount(99);
        //explorer.deleteItems("testItems");
        explorer.back();
        explorer.deleteBag("testBag");
        explorer.back();
        //explorer.back();
        //explorer.deleteBag("noBag");
        //explorer.deleteItems("noItems");
        explorer.getBag("myLittleBag").getItems("testItems");


        // decorator
        ILand iLand = new RedSoil(new DryLand());
        iLand.harvest();
        iLand = new BlackSoil(new FertileLand());
        iLand.harvest();
        iLand = new DryLand();
        iLand.harvest();

        // Facade
        Manager manager = Manager.getInstance();
        manager.doAll();
        explorer.addItems("Fertilizer", 1);
        explorer.addItems("Water", 100);
        manager.doAll();
    }

}
