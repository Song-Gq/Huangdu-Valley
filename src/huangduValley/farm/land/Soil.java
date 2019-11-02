package huangduValley.farm.land;

import huangduValley.farm.land.IHarvest;
import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Plant;
import huangduValley.farm.plant.Potato;

// part of "Decorator" design pattern
// representing an abstract "decorator" of class farm.land.Land
// inherited by farm.land.BlackSoil and farm.land.RedSoil
// scene "Farm", by Song Guanqun
public abstract class Soil implements IHarvest {

    // when constructing a concrete farm.land.Soil
    // this interface should be implemented by a farm.land.Land Object
    // this way, when calling harvest() of a concrete farm.land.Soil
    // the farm.land.Land's harvest() is available through the field iHarvest
    // and in the meanwhile, the concrete farm.land.Soil can do something to decorate it
    protected IHarvest iHarvest;

    // constructor
    // iHarvest should be implemented by a farm.land.Land Object
    public Soil(IHarvest iHarvest) {
        this.iHarvest = iHarvest;
    }

    // implemented by a concrete farm.land.Soil
    public abstract void harvest() throws Exception;

    // to be modified
    public abstract Plant getPlant();
    public abstract Carrot plantCarrot() throws Exception;
    public abstract Potato plantPotato() throws Exception;
    public abstract void water();
    public abstract void fertilize();
}
