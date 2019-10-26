
// part of "Decorator" design pattern
// implemented by class Land and Soil
// scene "The Farm", by Song Guanqun
public interface IHarvest {

    // you can call it through an IHarvest implemented by a Land Object
    // without decorations of Soil
    // or, call harvest() through an IHarvest implemented by
    // a concrete Soil whose iHarvest field is initialized with a Land Object
    public void harvest();
}
