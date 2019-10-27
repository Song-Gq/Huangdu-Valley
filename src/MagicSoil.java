
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
        System.out.println("production + 200!");
        // then
        iHarvest.harvest();
    }

    // simply call this method of class Land's
    @Override
    public Object getPlant() {
        return iHarvest.getPlant();
    }
    @Override
    public void plant(Object obj) {
        iHarvest.plant(obj);
    }
}
