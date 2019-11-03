package huangduValley.farm.land;

import huangduValley.farm.Stdout;
import huangduValley.farm.plant.*;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.RootBag;

// part of "Decorator" design pattern
// representing a concrete "decorator" of class farm.land.Land
// scene "Farm", by Song Guanqun
public class BlackSoil extends Soil {

    // constructor
    // refer to farm.land.Soil
    public BlackSoil(ILand iLand) {
        super(iLand);
    }
    // extra production
    public final static int production = 200;

    @Override
    public void harvest() throws Exception {
        RootBag rootBag = RootBag.getInstance();
        Plant plant = iLand.getPlant();

        if(plant != null && plant.isMature()) {
            // triple the production
            Stdout.print(this, "Invoke static methods in CalculateProduction");
            CalculateProduction.cal(plant, production, this);

            // then, call harvest() of normal Land's
            iLand.harvest();
        }
    }

    // simply call this method of class farm.land.Land's
    @Override
    public Plant getPlant() {
        return iLand.getPlant();
    }
    public void water() { iLand.water(); }
    public void fertilize() { iLand.fertilize(); }

    public Carrot plantCarrot() throws Exception { return ((Land) iLand).plantCarrot("black"); }
    public Potato plantPotato() throws Exception { return ((Land) iLand).plantPotato("black"); }
}
