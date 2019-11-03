package huangduValley.Workshop.processFactory.factory;

import huangduValley.Stdout;
import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.WareHouse.WareHouse;
import huangduValley.Workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Items;

import java.util.Vector;

//继承状态
public class NormalFactory implements FactoryState{
    //单例模式
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

    @Override
    public void runFactory() throws Exception {
        Stdout.print(this, "The Processing factory now is working!");
        for(WorkSpace workSpace:processVector){
            workSpace.doProcess();
            productsVector.add(workSpace.getIngredients());
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
}