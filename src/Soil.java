
// part of "Decorator" design pattern
// representing an abstract "decorator" of class Land
// inherited by BlackSoil and MagicSoil
// scene "The Farm", by Song Guanqun
public abstract class Soil implements IHarvest {

    // when constructing a concrete Soil
    // this interface should be implemented by a Land Object
    // this way, when calling harvest() of a concrete Soil
    // the Land's harvest() is available through the field iHarvest
    // and in the meanwhile, the concrete Soil can do something to decorate it
    public IHarvest iHarvest;

    // constructor
    // iHarvest should be implemented by a Land Object
    public Soil(IHarvest iHarvest) {
        this.iHarvest = iHarvest;
    }

    // implemented by a concrete Soil
    public abstract void harvest();
}
