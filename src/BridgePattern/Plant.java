package BridgePattern;

/**
 * base class of abstract hierarchy
 * implement function by calling methods of PlantImp.
 * @author :zdy
 */
public class Plant {
    private PlantImp impl;

    /**
     * constructor of Plant: three types
     * @param :none or the type of land or both land type and growing time of per stage
     */
    public Plant()
    {
        this.impl=new YellowLandPlant();//Default:to plant on the yellow land.
    }
    public Plant(String landType)
    {
        if(landType=="yellow")
            this.impl=new YellowLandPlant();
        else if(landType=="red")
            this.impl=new RedLandPlant();
        else if(landType=="black")
            this.impl=new BlackLandPlant();
        else
            System.out.println("Sorry,there isn't land of this type.");
    }
    public Plant(String landType,double time)
    {
        if(landType=="yellow")
            this.impl=new YellowLandPlant(time);
        else if(landType=="red")
            this.impl=new RedLandPlant(time);
        else if(landType=="black")
            this.impl=new BlackLandPlant(time);
        else
            System.out.println("Sorry,there isn't land of this type.");
    }

    protected void sprout()
    {
        impl.impSprout();
    }
    protected void growLeaves()
    {
        impl.impGrowLeaves();
    }
    protected void growBud()
    {
        impl.impGrowBud();
    }
    protected void blossom()
    {
        impl.impBlossom();
    }
    protected void bearFruit()
    {
        impl.impBearFruit();
    }
    protected void harvest()
    {
        impl.harvest();
    }
    protected void showStage()
    {
        impl.showStage();
    }
}
