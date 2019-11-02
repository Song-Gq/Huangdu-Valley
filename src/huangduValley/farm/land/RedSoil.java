package huangduValley.farm.land;

import huangduValley.farm.plant.*;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.RootBag;

// part of "Decorator" design pattern
// representing a concrete "decorator" of class farm.land.Land
// scene "Farm", by Song Guanqun
public class RedSoil extends Soil {

    // constructor
    // refer to farm.land.Soil
    public RedSoil(IHarvest iHarvest) {
        super(iHarvest);
    }
    // extra production
    public final static int production = 100;

    @Override
    public void harvest() throws Exception {
        RootBag rootBag = RootBag.getInstance();
        Plant plant = iHarvest.getPlant();

        if(plant != null && plant.isMature()) {
            // double the production
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

            // then, call harvest() of normal Land's
            iHarvest.harvest();
        }
    }

    // simply call this method of class farm.land.Land's
    @Override
    public Plant getPlant() {
        return iHarvest.getPlant();
    }
    public Carrot plantCarrot() throws Exception { return iHarvest.plantCarrot(); }
    public Potato plantPotato() throws Exception { return iHarvest.plantPotato(); }
    public void water() { iHarvest.water(); }
    public void fertilize() {iHarvest.fertilize(); }
}
