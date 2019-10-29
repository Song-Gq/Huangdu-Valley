package huangduValley.farm.land;

// part of "Decorator" design pattern
// implemented by class huangduValley.farm.land.Land and huangduValley.farm.land.Soil
// scene "The huangduValley.farm.Farm", by Song Guanqun
public interface IHarvest {

    // you can call it through an huangduValley.farm.land.IHarvest implemented by a huangduValley.farm.land.Land Object
    // without decorations of huangduValley.farm.land.Soil
    // or, call harvest() through an huangduValley.farm.land.IHarvest implemented by
    // a concrete huangduValley.farm.land.Soil whose iHarvest field is initialized with a huangduValley.farm.land.Land Object
    public void harvest();

    // for the convenience of calling these methods
    // through one unified interface
    // to be modified
    public void plant(Object obj);
    public Object getPlant();
}
