
// part of "Decorator" design pattern
// representing a concrete "decorator" of class Land
// scene "The Farm", by Song Guanqun
public class MagicSoil extends Soil{

    // constructor
    // refer to Soil
    public MagicSoil(IHarvest iHarvest) {
        super(iHarvest);
    }

    @Override
    public void harvest() {
        // magic
        // triple the production
        // then
        iHarvest.harvest();
    }
}
