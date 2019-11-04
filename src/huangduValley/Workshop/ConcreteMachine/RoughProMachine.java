package huangduValley.Workshop.ConcreteMachine;


import huangduValley.Stdout;
import huangduValley.Workshop.Machine;
import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.Product.RoughProduct;
import huangduValley.Workshop.Visitor;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class RoughProMachine extends Machine {
    private String name;

    /**
     *
     * @param name
     * Name of machine.
     */
    public RoughProMachine(String name){
        this.name = name;
    }

    /**
     * Get name of fine processing machine
     * @return
     * name of fine processing machine
     */
    @Override
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Switch on machine.
     */
    @Override
    public void switchOn(){
        Stdout.print(this, "RoughProMachine on!");
    }

    /**
     * Turn off machine.
     */
    @Override
    public void stop(){
        Stdout.print(this, "RoughProMachine off!");
    }

    /**
     * The material processing operations
     * @param materialVector
     * Vector of materials to be processed
     * @return
     * Products produced by the rough processing machine
     * @throws Exception
     */
    @Override
    public Vector<Items> run(Vector<Items> materialVector) throws Exception {
        Stdout.print(this, "RoughProMachine is running!");
        Vector<Items> productVector = new Vector<>();
        for(Items items:materialVector){
            Thread.sleep(100*items.getCount());
            productVector.add(new RoughProduct(items.getName(), items.getCount()));
            Stdout.print(this, String.format("Rough processing machine produces %d %s",items.getCount(),items.getName()));
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

    //原型模式
    @Override
    public Object clone() throws CloneNotSupportedException {
        Stdout.print(this, "Clone a rough process machine.");
        return super.clone();
    }
}
