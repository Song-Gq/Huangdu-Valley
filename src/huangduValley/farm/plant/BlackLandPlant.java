package huangduValley.farm.plant;

/**
 * implementation of plants on BlackLand whose growing time is sixty percent of normal ones.
 */
public class BlackLandPlant extends PlantImp{
    public BlackLandPlant()
    {
        super(10);
    }
    public BlackLandPlant(double time)
    {
        super(time);
    }
    @Override
    protected void impSprout()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="bud";
        System.out.println("The plant sprouts after "+growTime+"hours.Black land is best!");
    }

    @Override
    protected void impGrowLeaves()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="leaves";
        System.out.println("The plant grows leaves after "+growTime+"hours.Black land is best!");
    }

    @Override
    protected void impGrowBud()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="flower bud";
        System.out.println("The plant grows buds after "+growTime+"hours.Black land is best!");
    }

    @Override
    protected void impBlossom()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="blossom";
        this.isMature=true;
        System.out.println("The plant begins to put forth their blossoms after "+growTime+"hours.It's mature and can be harvest.Black land is best!");
    }

    @Override
    protected void impBearFruit()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="fruit";
        this.isMature=true;
        System.out.println("The plant has born fruit after "+growTime+"hours.It's mature and can be harvest.Black land is best!\n");
    }
}
