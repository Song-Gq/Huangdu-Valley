package huangduValley.Workshop.ConcreteMachine;

import huangduValley.Workshop.Machine;
import huangduValley.Workshop.Product.FineProduct;
import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.Visitor;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class FineProMachine extends Machine {
    private String name;

    /**
     *
     * @param name
     * Name of machine.
     */
    public FineProMachine(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void switchOn(){
        System.out.println("FineProMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("FineProMachine off!");
    }

    /**
     * The material processing operations
     * @param materialVector
     * Vector of materials to be processed
     * @return
     * Products produced by the fine processing machine
     * @throws Exception
     */
    @Override
    public Vector<Items> run(Vector<Items> materialVector) throws Exception {
        System.out.println("FineProMachine is running!");
        Vector<Items> productVector = new Vector<>();
        for(Items items:materialVector){
            Thread.sleep(100*items.getCount());
            productVector.add(new FineProduct(items.getName(), items.getCount()));
            System.out.println(String.format("Fine processing machine produces %d %s",items.getCount(),items.getName()));
        }
        return productVector;
    }

    @Override
    public Vector<Items> accept(Visitor v) throws Exception {
        return v.visit(this);
    }
}
