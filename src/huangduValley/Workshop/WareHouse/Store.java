package huangduValley.Workshop.WareHouse;

import huangduValley.Stdout;
import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.processFactory.factory.Observer;
import huangduValley.farm.storage.Items;

import java.util.Vector;

public class Store implements Observer,Proxy {
    private Vector<Vector<Product>> productsVector = new Vector<>();

    private Store() {
        Stdout.print(this, "Store create.");
    }

    private static class StoreHolder {
        private static final Store INSTANCE = new Store();
    }

    public static Store getInstance() {
        Stdout.print(StoreHolder.INSTANCE.toString(), "Get store instance.");
        return StoreHolder.INSTANCE;
    }

    private WareHouse wareHouse = WareHouse.getInstance();

    private void preRequest() {
        Stdout.print(this, "Buy product proxy start.");
    }

    private void postRequest() {
        Stdout.print(this, "Buy product proxy finish.");
    }

    @Override
    public void update(Vector<Vector<Items>> products) {
        int length = products.size();
        for (int indexA = 0; indexA < length; indexA++) {
            Vector<Product> temp = new Vector<>();
            for (int indexB = 0; indexB < products.elementAt(indexA).size(); indexB++) {
                temp.add((Product) products.elementAt(indexA).elementAt(indexB));
            }
            productsVector.add(temp);
        }
    }

    //代理模式
    @Override
    public boolean buy(String name) throws Exception {
        boolean flag;
        preRequest();
        flag = wareHouse.buy(name);
        postRequest();
        return flag;
    }

    public Vector<Vector<Product>> getProductsVector() {
        return productsVector;
    }
}
