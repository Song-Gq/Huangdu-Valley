package huangduValley.farm.land;

import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Potato;

// part of "Decorator" design pattern
// representing a piece of field
// to be inherited by DryLand and FertileLand
// scene "The huangduValley.farm.Farm", by Song Guanqun
public abstract class Land implements IHarvest {

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

    public abstract Carrot plantCarrot();

    public abstract Potato plantPotato();

    public void water() {
        System.out.println("Watering...");
    }

    public void fertilize() {
        System.out.println("Fertiling...");
    }
}
