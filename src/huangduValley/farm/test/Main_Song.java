package huangduValley.farm.test;

import huangduValley.farm.land.*;
import huangduValley.farm.manager.Manager;
import huangduValley.farm.storage.Storage;

// this includes main method for testing scene "The huangduValley.farm.Farm" by Song Guanqun
public class Main_Song {

    public static void main(String[] args) throws Exception
    {
        // composite and storage
        Storage storage = Storage.getInstance();

        storage.addItems("carrotSeed", 1);
        storage.addItems("potatoSeed", 2);
        storage.addBag("myLittleBag");
        storage.into("myLittleBag");
        storage.addBag("testBag");
        //storage.addBag("testBag");
        storage.into("testBag");
        //storage.addItems("testItems", -1);
        storage.addItems("testItems", 100);
        storage.addItems("testItems", 3);
        storage.getItems("testItems").setCount(99);
        //storage.deleteItems("testItems");
        storage.back();
        storage.deleteBag("testBag");
        storage.back();
        //storage.back();
        //storage.deleteBag("noBag");
        //storage.deleteItems("noItems");
        storage.getBag("myLittleBag").getItems("testItems");


        // decorator
        IHarvest iHarvest = new BlackSoil(new DryLand());
        iHarvest.harvest();
        iHarvest = new MagicSoil(new FertileLand());
        iHarvest.harvest();
        iHarvest = new DryLand();
        iHarvest.harvest();

        // Facade
        Manager manager = Manager.getInstance();
        manager.doAll();
        storage.addItems("Fertilizer", 1);
        storage.addItems("Water", 100);
        manager.doAll();
    }

}
