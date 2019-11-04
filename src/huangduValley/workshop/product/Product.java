package huangduValley.workshop.product;

import huangduValley.farm.storage.Items;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class Product extends Items {
    
    private float price;

    /**
     *
     * @param name
     * Name of product
     * @param count
     * Number of product
     * @throws Exception
     */
    public Product(String name, int count)throws Exception{
        super(name, count);
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return this.price;
    }
}
