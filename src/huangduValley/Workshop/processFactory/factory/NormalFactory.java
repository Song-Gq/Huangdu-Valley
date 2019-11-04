package huangduValley.Workshop.processFactory.factory;

import huangduValley.Stdout;
import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.WareHouse.Store;
import huangduValley.Workshop.WareHouse.WareHouse;
import huangduValley.Workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//继承状态
public class NormalFactory implements FactoryState{
    //单例模式
    private NormalFactory(){
        addObservers(wareHouse);
        addObservers(store);
    }

    private static class NormalFactoryHolder{
        private static final NormalFactory INSTANCE = new NormalFactory();
    }

    public static NormalFactory getInstance(){
        return NormalFactoryHolder.INSTANCE;
    }

    private WareHouse wareHouse = WareHouse.getInstance();

    private Store store = Store.getInstance();


    private Vector<WorkSpace> processVector;

    private Vector<Vector<Items>> productsVector = new Vector<>();

    //观察者模式
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void runFactory() throws Exception {
        Stdout.print(this, "The Processing factory now is working!");
        for(WorkSpace workSpace:processVector){
            workSpace.doProcess();
            productsVector.add(workSpace.getIngredients());
            //更新观察者序列
            for (Observer observer: observers) {
                observer.update(getProductsVector());
            }
            Stdout.print(this, "Update observers");
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