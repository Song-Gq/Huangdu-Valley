package BridgePattern;

/**
 * the implementation of Plant
 * @author :zdy
 */
public abstract class PlantImp {
    protected double timePerStage;//time of per growing stage:default 10 hours
    protected String stage;//growth stage of plant: seed,bud,leaf,flower bud/blossom,blossom/fruit,dead
    protected boolean isMature=false;//whether a plant can be harvest

    /**
     * constructor
     * @param :null or time of per growing stage
     */
    public PlantImp()
    {
        this.stage="seed";
        this.timePerStage=10;
    }
    public PlantImp(double timePerStage)
    {
        this.timePerStage=timePerStage;
        this.stage="seed";
    }

    /**
     * the growing process of a plant
     */
    protected abstract void impSprout();
    protected abstract void impGrowLeaves();
    protected abstract void impGrowBud();
    protected abstract void impBlossom();
    protected abstract void impBearFruit();

    /**
     * harvest plant which is mature
     */
    public void harvest()
    {
        if(this.isMature)
        {
            this.stage="dead";
            System.out.println("Harvest! and the plant is dead after harvest");
        }
        else
            System.out.println("The plant is not mature enough to be harvest!");
    }

    /**
     * show the present growing stage of plant
     */
    public void showStage()
    {
        String stage=this.stage;
        System.out.println(stage);
    }
}
