package huangduValley.farm.land;

import huangduValley.farm.land.IHarvest;

// part of "Decorator" design pattern
// representing an abstract "decorator" of class huangduValley.farm.land.Land
// inherited by huangduValley.farm.land.BlackSoil and huangduValley.farm.land.MagicSoil
// scene "The huangduValley.farm.Farm", by Song Guanqun
public abstract class Soil implements IHarvest {

    // when constructing a concrete huangduValley.farm.land.Soil
    // this interface should be implemented by a huangduValley.farm.land.Land Object
    // this way, when calling harvest() of a concrete huangduValley.farm.land.Soil
    // the huangduValley.farm.land.Land's harvest() is available through the field iHarvest
    // and in the meanwhile, the concrete huangduValley.farm.land.Soil can do something to decorate it
    protected IHarvest iHarvest;

    // constructor
    // iHarvest should be implemented by a huangduValley.farm.land.Land Object
    public Soil(IHarvest iHarvest) {
        this.iHarvest = iHarvest;
    }

    // implemented by a concrete huangduValley.farm.land.Soil
    public abstract void harvest();

    // to be modified
    public abstract void plant(Object obj);
    public abstract Object getPlant();
}
