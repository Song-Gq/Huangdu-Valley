package huangduValley.Workshop.processFactory.factory;

import huangduValley.Workshop.WareHouse.WareHouse;
import huangduValley.Workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//继承状态
public class NormalFactory implements FactoryState{
    //单例模式
    //private static NormalFactory INSTANCE=new NormalFactory();
    private NormalFactory(){}

    private static class NormalFactoryHolder{
        private static final NormalFactory INSTANCE = new NormalFactory();
    }

    public static NormalFactory getInstance(){
        return NormalFactoryHolder.INSTANCE;
    }

    private WareHouse wareHouse = WareHouse.getInstance();

    private Vector<WorkSpace> processVector;

    private Vector<Vector<Items>> productsVector = new Vector<>();

    //观察者模式
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void runFactory() throws Exception {
        System.out.println("the Processing factory now is working .");
        for(WorkSpace workSpace:processVector){
            workSpace.doProcess();
            productsVector.add(workSpace.getIngredients());
            for (Observer observer: observers) {
                observer.update(getProductsVector());
            }
            System.out.println("Update observers");
            workSpace.doExit();
        }
    }

    public Vector<Vector<Items>> getProductsVector() {
        return productsVector;
    }

    public WareHouse getWareHouse(){
        return wareHouse;
    }

    public void setProcessVector(Vector<WorkSpace> processVector){
        this.processVector = processVector;
    }

    public void addObservers(Observer observer) {
        observers.add(observer);
    }

    public void delObservers(Observer observer) {
        observers.remove(observer);
    }
}