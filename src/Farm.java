import java.util.ArrayList;

// part of "Facade" design pattern
// a Singleton class that manages all your lands
// scene "The Farm", by Song Guanqun
public class Farm {

    // Singleton instance
    private static Farm instance;
    // all your lands
    private ArrayList<IHarvest> lands;

    // private constructor
    private Farm() {
        lands = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            this.addLand();
        }
    }

    public static Farm getInstance() {
        if(instance == null) {
            instance = new Farm();
        }
        return instance;
    }

    // add a piece of ordinary land
    public void addLand() {
        lands.add(new Land());
    }

    // upgrade a piece of land
    // index starts from 0
    public void upgradeLand(int index) throws Exception {
        // index out of range
        if(index < 0 || index > lands.size() - 1) {
            throw new Exception("index out of range");
        }

        IHarvest iLand = lands.get(index);
        // already Magic Soil
        if(iLand instanceof MagicSoil) {
            System.out.println("Land "+ index +
                    " is already made up of Magic Soil!");
        }
        // upgrade to Magic Soil
        else if(iLand instanceof BlackSoil) {
            lands.set(index, new MagicSoil(
                    ((BlackSoil) iLand).iHarvest));
        }
        // upgrade to Black Soil
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
                System.out.print(" Magic Soil ");
            }
            else if(iLand instanceof BlackSoil){
                System.out.print(" Black Soil ");
            }
            else {
                System.out.print(" Ordinary Soil ");
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
        System.out.println("Land all watered.");
    }

    // fertilize all the plants
    public void fertilizeAll() {
        // consume water
        System.out.println("Land all fertilized.");
    }
}
