package huangduValley.workshop.wareHouse;

import huangduValley.Stdout;
import huangduValley.workshop.product.Product;
import huangduValley.workshop.processFactory.factory.Observer;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 * Observer Pattern, Proxy Pattern
 */

public class Store implements Observer,Proxy {
    private Vector<Vector<Product>> productsVector = new Vector<>();

    private Store() {
        Stdout.print(this, "Store create.");
    }

    /**
     * Singleton Pattern
     */
    private static class StoreHolder {
        private static final Store INSTANCE = new Store();
    }

    public static Store getInstance() {
        Stdout.print(StoreHolder.INSTANCE.toString(), "Get store instance.");
        return StoreHolder.INSTANCE;
    }

    private WareHouse wareHouse = WareHouse.getInstance();

    /**
     * Proxy Pattern
     * Start proxy
     */
    private void preRequest() {
        Stdout.print(this, "Buy product proxy start.");
    }

    /**
     * Proxy Pattern
     * Finish proxy
     */
    private void postRequest() {
        Stdout.print(this, "Buy product proxy finish.");
    }

    /**
     * Observer Pattern
     * Update the products vector in store
     * @param products: the products vector of factory
     */
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

    /**
     * Proxy Pattern
     * Buy things through proxy
     * @param name: the thing's name that you want to buy
     * @return boolean
     * @throws Exception
     */
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
