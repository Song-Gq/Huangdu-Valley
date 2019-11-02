package huangduValley.farm.land;

import huangduValley.farm.plant.*;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.RootBag;

// part of "Decorator" design pattern
// representing a piece of field
// inherited by DryLand and FertileLand
// scene "Farm", by Song Guanqun
public abstract class Land implements ILand {

    // to be replaced by class Plant
    protected Plant plant;
    // default production
    public final static int production = 100;

    // do nothing if plant null
    // remove plant if it not matured
    // get ingredients and money
    public void harvest() throws Exception{
        // check if the plant exists
        if(plant != null) {
            RootBag rootBag = RootBag.getInstance();

            // check if plant matured
            if(plant.isMature()){
                // plant.harvest();

                // harvest with normal production
                // ingredients doubled if plant strong
                if(plant instanceof StrongCarrot) {
                    rootBag.add(new Ingredients("Carrot", production * 2));
                    System.out.println("You get Carrot X" + production * 2);
                }
                else if(plant instanceof CommonCarrot) {
                    rootBag.add(new Ingredients("Carrot", production));
                    System.out.println("You get Carrot X" + production);
                }
                else if(plant instanceof StrongPotato) {
                    rootBag.add(new Ingredients("Potato", production * 2));
                    System.out.println("You get Potato X" + production * 2);
                }
                else if(plant instanceof CommonPotato) {
                    rootBag.add(new Ingredients("Potato", production));
                    System.out.println("You get Potato X" + production);
                }
                // unknown plant
                else {
                    throw new Exception("unknown plant when harvest()");
                }

                // get money

            }
            // if not matured, get nothing

            // remove plant
            plant = null;
        }
        // plant null, do nothing
    }

    public Plant getPlant() { return plant; }

    public void water() {
        // not matured
        if(plant != null && !plant.isMature()) {
            System.out.println("Watering...");
            plant.growUp();
        }

        // matured, do nothing
    }
    public void fertilize() {
        // not matured
        if(plant != null && !plant.isMature()) {
            System.out.println("Fertilizng...");
            plant.growUp();
        }

        // matured, do nothing
    }

    public abstract Carrot plantCarrot() throws Exception;
    public abstract Potato plantPotato() throws Exception;

    // called by RedSoil or BlackSoil through their iLand
    // to create plants of proper land type
    protected abstract Carrot plantCarrot(String landType) throws Exception;
    protected abstract Potato plantPotato(String landType) throws Exception;
}
