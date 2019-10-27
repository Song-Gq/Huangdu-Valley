
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
        System.out.println("production + 100!");
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
