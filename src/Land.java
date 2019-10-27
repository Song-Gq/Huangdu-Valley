
// part of "Decorator" design pattern
// representing a piece of field
// to be inherited by DryLand and FertileLand
// scene "The Farm", by Song Guanqun
public class Land implements IHarvest {

    // to be replaced by class Plant
    private Object plant;

    public void harvest() {
        // check if the plant exists and has matured
        if(plant != null) {
            // harvest!
            // with normal production
            System.out.println("production + 100!");
            plant = null;
        }
    }

    public Object getPlant() {
        plant = "testPlant";    // to be removed
        return plant;
    }

    public void plant(Object obj) {
        if(plant == null) {
            plant = obj;
        }
        // field not empty!
        else {

        }
    }
}
