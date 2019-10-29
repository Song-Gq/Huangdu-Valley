package huangduValley.farm.plant;

/**
 * implementation of plants on YellowLand whose growing time is normal
 */

public class YellowLandPlant extends PlantImp {

    public YellowLandPlant()
    {
        super(10);
    }
    public YellowLandPlant(double time)
    {
        super(time);
    }

    @Override
    protected void impSprout()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="bud";
        System.out.println("The plant sprouts after "+growTime+" hours.Yellow land is good!");
    }

    @Override
    protected void impGrowLeaves()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="leaves";
        System.out.println("The plant grows leaves after "+growTime+" hours.Yellow land is good!");
    }

    @Override
    protected void impGrowBud()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="flower bud";
        System.out.println("The plant grows buds after "+growTime+" hours.Yellow land is good!");
    }

    @Override
    protected void impBlossom()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="blossom";
        this.isMature=true;
        System.out.println("The plant begins to put forth their blossoms after "+growTime+" hours.It's mature and can be harvest.Yellow land is good!");
    }

    @Override
    protected void impBearFruit()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="fruit";
        this.isMature=true;
        System.out.println("The plant has born fruit after "+growTime+" hours.It's mature and can be harvest.Yellow land is good!");
    }
}
