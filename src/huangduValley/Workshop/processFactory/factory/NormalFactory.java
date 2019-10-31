package huangduValley.Workshop.processFactory.factory;

import huangduValley.Workshop.WareHouse.WareHouse;
import huangduValley.Workshop.processFactory.workSpace.SequentialProcessing;
import huangduValley.Workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Items;

import java.util.Vector;

//继承状态
public class NormalFactory implements FactoryState{
    //单例模式
    private static NormalFactory factory=new NormalFactory();
    private NormalFactory(){}
    public static NormalFactory getInstance(){
        return factory;
    }

    private WareHouse wareHouse = WareHouse.getInstance();

    private Vector<WorkSpace> processVector;

    @Override
    public Vector<Vector<Items>> runFactory() throws Exception {
        System.out.println("the Processing factory now is working .");
        Vector<Vector<Items>> products = new Vector<>();
        for(WorkSpace workSpace:processVector){
            products.add(workSpace.doProcess());
            workSpace.doExit();
        }
        return products;
    }

    public WareHouse getWareHouse(){
        return wareHouse;
    }

    public void setProcessVector(Vector<WorkSpace> processVector){
        this.processVector = processVector;
    }
}