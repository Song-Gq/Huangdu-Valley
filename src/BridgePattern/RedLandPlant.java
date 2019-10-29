package BridgePattern;
/**
 * implementation of plants on RedLand whose growing time is eighty percent of normal ones.
 */

import java.util.concurrent.TimeUnit;

public class RedLandPlant extends PlantImp{
    public RedLandPlant()
    {
        super(10);
    }
    public RedLandPlant(double time)
    {
        super(time);
    }
    @Override
    protected void impSprout()
    {
        double growTime=timePerStage*0.8;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="bud";
        System.out.println("The plant sprouts after "+growTime+" hours.Red land is better!");
    }

    @Override
    protected void impGrowLeaves()
    {
        double growTime=timePerStage*0.8;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="leaves";
        System.out.println("The plant grows leaves after "+growTime+" hours.Red land is better!");
    }

    @Override
    protected void impGrowBud()
    {
        double growTime=timePerStage*0.8;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="flower bud";
        System.out.println("The plant grows buds after "+growTime+" hours.Red land is better!");
    }

    @Override
    protected void impBlossom()
    {
        double growTime=timePerStage*0.8;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="blossom";
        this.isMature=true;
        System.out.println("The plant begins to put forth their blossoms after "+growTime+" hours.It's mature and can be harvest.Red land is better!");
    }

    @Override
    protected void impBearFruit()
    {
        double growTime=timePerStage*0.8;
        //TimeUnit.HOURS.sleep(growTime);
        this.isMature=true;
        this.stage="fruit";
        System.out.println("The plant has born fruit after "+growTime+" hours.It's mature and can be harvest.Red land is better!\n");
    }
}
