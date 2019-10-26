
// part of "Decorator" design pattern
// representing a concrete "decorator" of class Land
// scene "The Farm", by Song Guanqun
public class BlackSoil extends Soil{

    // constructor
    // refer to Soil
    public BlackSoil(IHarvest iHarvest) {
        super(iHarvest);
    }

    @Override
    public void harvest() {
        // magic
        // double the production
        // then
        iHarvest.harvest();
    }
}
