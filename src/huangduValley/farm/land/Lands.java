package huangduValley.farm.land;

import java.util.ArrayList;

// part of "Facade" design pattern
// a Singleton class that manages all your lands
// scene "Farm", by Song Guanqun
public class Lands {

    // Singleton instance
    private static Lands instance;
    // all your lands
    private ArrayList<ILand> lands;

    // private constructor
    private Lands() {
        lands = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            this.addDryLand();
            this.addFertileLand();
        }
    }

    public static Lands getInstance() {
        if(instance == null) {
            instance = new Lands();
        }
        return instance;
    }

    // add a piece of ordinary dry land
    public void addDryLand() {
        lands.add(new DryLand());
    }

    // add a piece of ordinary fertile land
    public void addFertileLand() {
        lands.add(new FertileLand());
    }

    // upgrade a piece of land
    // index starts from 0
    public void upgradeLand(int index) throws Exception {
        // index out of range
        if(index < 0 || index > lands.size() - 1) {
            throw new Exception("index out of range");
        }

        ILand iLand = lands.get(index);
        // already Black Soil
        if(iLand instanceof BlackSoil) {
            System.out.println("Land "+ index +
                    " is already made up of Black Soil!");
        }
        // upgrade to Black Soil
        else if(iLand instanceof RedSoil) {
            lands.set(index, new BlackSoil(
                    ((RedSoil) iLand).iLand));
        }
        // upgrade to Red Soil
        else {
            lands.set(index, new RedSoil(iLand));
        }
    }

    // print info of all the lands
    public void printList() throws Exception {
        for(ILand iLand: lands) {
            // print index
            System.out.print(lands.indexOf(iLand));
            // print grade and plant
            if(iLand instanceof BlackSoil) {
                // print dry or fertile
                if(((BlackSoil) iLand).iLand instanceof DryLand)
                    System.out.print(" Dry Land with");
                else if(((BlackSoil) iLand).iLand instanceof FertileLand)
                    System.out.print(" Fertile Land with");
                else
                    throw new Exception("unknown land type");

                System.out.print(" Black Soil ");
            }
            else if(iLand instanceof RedSoil){
                if(((RedSoil) iLand).iLand instanceof DryLand)
                    System.out.print(" Dry Land with");
                else if(((RedSoil) iLand).iLand instanceof FertileLand)
                    System.out.print(" Fertile Land with");
                else
                    throw new Exception("unknown land type");

                System.out.print(" Red Soil ");
            }
            else {
                if(iLand instanceof DryLand)
                    System.out.print(" Dry Land with");
                else if(iLand instanceof FertileLand)
                    System.out.print(" Fertile Land with");
                else
                    throw new Exception("unknown land type");

                System.out.print(" Ordinary Soil ");
            }
            // print plant
            if(iLand.getPlant() == null)
                System.out.println("No Plant");
            else {
                String className = iLand.getPlant().getClass().getName();
                int dotIndex = className.lastIndexOf(".");
                System.out.println(className.substring(dotIndex+1));
            }
        }
    }

    // harvest all mature plants
    public void harvestAll() throws Exception {
        for (ILand iLand: lands) {
            // check if plant matured
            iLand.harvest();
        }
    }

    // plant carrots on all empty lands
    public void plantCarrotAll() throws Exception {
        for (ILand iLand: lands) {
            // land empty, plant carrot
            if(iLand.getPlant() == null)
                iLand.plantCarrot();
        }
    }

    // plant potatoes on all empty lands
    public void plantPotatoAll() throws Exception {
        for (ILand iLand: lands) {
            // land empty, plant potato
            if(iLand.getPlant() == null)
                iLand.plantPotato();
        }
    }

    // water all the plants
    public void waterAll() {
        // this will not consume water
        // manager will
        for (ILand iLand: lands) {
            iLand.water();
        }
    }

    // fertilize all the plants
    public void fertilizeAll() {
        // this will not consume fertilizer
        // manager will
        for (ILand iLand: lands) {
            iLand.fertilize();
        }
    }
}
