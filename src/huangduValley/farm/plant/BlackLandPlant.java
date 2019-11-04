package huangduValley.farm.plant;

import huangduValley.Stdout;

/**
 * @pattern Bridge Pattern
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
        Stdout.print(this, "The plant sprouts after "
                + growTime + " hours");
    }

    @Override
    protected void impGrowLeaves()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="leaves";
        Stdout.print(this, "The plant grows leaves after "
                + growTime + " hours");
    }

    @Override
    protected void impGrowBud()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="flower bud";
        Stdout.print(this, "The plant grows buds after "
                + growTime + " hours");
    }

    @Override
    protected void impBlossom()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="blossom";
        this.isMature=true;
        Stdout.print(this, "The plant begins to put forth their blossoms after "
                + growTime + " hours. It's mature and can be harvested");
    }

    @Override
    protected void impBearFruit()
    {
        double growTime=timePerStage*0.6;
        //TimeUnit.HOURS.sleep(growTime);
        this.stage="fruit";
        this.isMature=true;
        Stdout.print(this, "The plant has born fruit after "
                + growTime + " hours. It's mature and can be harvested");
    }
}
