package BridgePattern;

public class Test {

    public static void main(String[] args)
    {
        FlowerPlant f1=new FlowerPlant();
        FlowerPlant f2=new FlowerPlant("red");
        FlowerPlant f3=new FlowerPlant("black", 20.0);

        f1.growUp();
        f2.growUp();
        f3.growUp();
    }
}
