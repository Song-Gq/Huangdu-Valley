package huangduValley.workshop.processFactory.factory;

//设置状态
public class Context{
    private FactoryState state;
    public Context(){this.state=null;}
    public void setState(FactoryState state){
        this.state=state;
    }
    public FactoryState getState(){return this.state;}
    public void runState() throws Exception {this.state.runFactory();}
}