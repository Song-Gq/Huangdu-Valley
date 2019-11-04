package huangduValley.farm.plant;

import huangduValley.Stdout;

/**
 * @pattern Bridge Pattern
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
        Stdout.print(this, "The plant sprouts after "
                + growTime + " hours");
    }

    @Override
    protected void impGrowLeaves()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="leaves";
        Stdout.print(this, "The plant grows leaves after "
                + growTime + " hours");
    }

    @Override
    protected void impGrowBud()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="flower bud";
        Stdout.print(this, "The plant grows buds after "
                + growTime + " hours");
    }

    @Override
    protected void impBlossom()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="blossom";
        this.isMature=true;
        Stdout.print(this, "The plant begins to put forth their blossoms after "
                + growTime + " hours. It's mature and can be harvested");
    }

    @Override
    protected void impBearFruit()
    {
        double growTime=timePerStage;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="fruit";
        this.isMature=true;
        Stdout.print(this, "The plant has born fruit after "
                + growTime + " hours. It's mature and can be harvested");
    }
}
