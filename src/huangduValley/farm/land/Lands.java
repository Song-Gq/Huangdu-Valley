package huangduValley.farm.land;

import java.util.ArrayList;

// part of "Facade" design pattern
// a Singleton class that manages all your lands
// scene "The huangduValley.farm.Farm", by Song Guanqun
public class Lands {

    // Singleton instance
    private static Lands instance;
    // all your lands
    private ArrayList<IHarvest> lands;

    // private constructor
    private Lands() {
        lands = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            this.addLand();
        }
    }

    public static Lands getInstance() {
        if(instance == null) {
            instance = new Lands();
        }
        return instance;
    }

    // add a piece of ordinary land
    public void addLand() {
        lands.add(new DryLand());   // to be modified
        lands.add(new FertileLand());
    }

    // upgrade a piece of land
    // index starts from 0
    public void upgradeLand(int index) throws Exception {
        // index out of range
        if(index < 0 || index > lands.size() - 1) {
            throw new Exception("index out of range");
        }

        IHarvest iLand = lands.get(index);
        // already Magic huangduValley.farm.land.Soil
        if(iLand instanceof MagicSoil) {
            System.out.println("huangduValley.farm.land.Land "+ index +
                    " is already made up of Magic huangduValley.farm.land.Soil!");
        }
        // upgrade to Magic huangduValley.farm.land.Soil
        else if(iLand instanceof BlackSoil) {
            lands.set(index, new MagicSoil(
                    ((BlackSoil) iLand).iHarvest));
        }
        // upgrade to Black huangduValley.farm.land.Soil
        else {
            lands.set(index, new BlackSoil(iLand));
        }
    }

    // print info of all the lands
    public void printList() {
        for(IHarvest iLand: lands) {
            // print index
            System.out.print(lands.indexOf(iLand));
            // print grade and plant
            if(iLand instanceof MagicSoil) {
                System.out.print(" Magic huangduValley.farm.land.Soil ");
            }
            else if(iLand instanceof BlackSoil){
                System.out.print(" Black huangduValley.farm.land.Soil ");
            }
            else {
                System.out.print(" Ordinary huangduValley.farm.land.Soil ");
            }
            // print plant
            System.out.println(iLand.getPlant());
        }
    }

    // harvest all mature plants
    public void harvestAll() {
        for (IHarvest iLand: lands) {
            iLand.harvest();
        }
    }

    // seed on all empty lands
    public void plantAll() {
        for (IHarvest iLand: lands) {
            iLand.plant("Sample");
        }
    }

    // water all the plants
    public void waterAll() {
        // consume water
        System.out.println("huangduValley.farm.land.Land all watered.");
    }

    // fertilize all the plants
    public void fertilizeAll() {
        // consume water
        System.out.println("huangduValley.farm.land.Land all fertilized.");
    }
}
