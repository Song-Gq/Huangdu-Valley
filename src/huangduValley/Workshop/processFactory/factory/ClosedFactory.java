package huangduValley.Workshop.processFactory.factory;

//继承状态，同时使用单例模式
public class ClosedFactory implements FactoryState{
    private static ClosedFactory factory=new ClosedFactory();
    private ClosedFactory(){}
    public static ClosedFactory getInstance(){
        return factory;
    }
    @Override
    public void runFactory(){
        System.out.println("Sorry,the factory has been closed");
    }
}