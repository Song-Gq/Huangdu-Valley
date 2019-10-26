
// part of "Decorator" design pattern
// representing a piece of field
// to be inherited by DryLand and FertileLand
// scene "The Farm", by Song Guanqun
public class Land implements IHarvest {

    // to be replaced by class Plant
    private Object plant;

    public void harvest() {
        // harvest!
        // with normal production
    }
}
