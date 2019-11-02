package huangduValley.farm.test;

import huangduValley.farm.plant.FlowerPlant;

public class Test_bridge {

    public static void main(String[] args)
    {
        FlowerPlant f1=new FlowerPlant("yellow");
        FlowerPlant f2=new FlowerPlant("red");
        FlowerPlant f3=new FlowerPlant("black", 20.0);

        f1.growUp();
        f2.growUp();
        f3.growUp();
    }
}
