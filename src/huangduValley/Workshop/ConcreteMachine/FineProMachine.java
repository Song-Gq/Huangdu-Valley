package huangduValley.Workshop.ConcreteMachine;

import huangduValley.Stdout;
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

    /**
     * Get name of rough processing machine
     * @return
     * name of rough processing machine
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Switch on machine.
     */
    @Override
    public void switchOn(){
        Stdout.print(this, "FineProMachine on!");
    }

    /**
     * Turn off machine.
     */
    @Override
    public void stop(){
        Stdout.print(this, "FineProMachine off!");
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
        Stdout.print(this, "FineProMachine is running!");
        Vector<Items> productVector = new Vector<>();
        for(Items items:materialVector){
            Thread.sleep(100*items.getCount());
            productVector.add(new FineProduct(items.getName(), items.getCount()));
            Stdout.print(this, String.format("Fine processing machine produces %d %s",items.getCount(),items.getName()));
        }
        return productVector;
    }

    /**
     *
     * @param v
     * Visitor operation object.
     * @return
     * Vector of items that the operation produces.
     * @throws Exception
     */
    @Override
    public Vector<Items> accept(Visitor v) throws Exception {
        return v.visit(this);
    }
}
