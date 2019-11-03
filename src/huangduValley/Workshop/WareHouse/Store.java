package huangduValley.Workshop.WareHouse;

import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.processFactory.factory.Observer;
import huangduValley.farm.storage.Items;

import java.util.Vector;

public class Store implements Observer,Proxy {
    private Wallet wallet = Wallet.getInstance();
    private Vector<Vector<Items>> productsVector = new Vector<>();

    private WareHouse wareHouse = WareHouse.getInstance();

    private void preRequest() {
        System.out.println("Buy product proxy start.");
    }

    private void postRequest() {
        System.out.println("Buy product proxy finish.");
    }

    @Override
    public void update(Vector<Vector<Items>> products) {
        productsVector = products;
    }

    @Override
    public boolean buy(Product product) throws Exception {
        boolean flag;
        preRequest();
        flag = wareHouse.buy(product);
        postRequest();
        return flag;
    }

    public Vector<Vector<Items>> getProductsVector() {
        return productsVector;
    }
}
