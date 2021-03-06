package huangduValley.workshop.concreteMachine;

import huangduValley.Stdout;
import huangduValley.workshop.Machine;
import huangduValley.workshop.product.CleanProduct;
import huangduValley.workshop.Visitor;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 * Machine that do cleaning
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class CleanMachine extends Machine implements Prototype {
    private String name;

    /**
     *
     * @param name
     * Name of machine.
     */
    public CleanMachine(String name){
        this.name = name;
    }

    /**
     * Get name of clean machine
     * @return
     * name of clean machine
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
        Stdout.print(this, "CleanMachine on!");
    }

    /**
     * Turn off machine.
     */
    @Override
    public void stop(){
        Stdout.print(this, "CleanMachine off!");
    }

    /**
     * The material processing operations
     * @param materialVector
     * Vector of materials to be processed
     * @return
     * Products produced by the clean machine
     * @throws Exception
     */
    @Override
    public Vector<Items> run(Vector<Items> materialVector) throws Exception {
        Stdout.print(this,"CleanMachine is running!");
        Vector<Items> productVector = new Vector<>();
        for(Items items:materialVector){
            Thread.sleep(100*items.getCount());
            productVector.add(new CleanProduct(items.getName(), items.getCount()));
            Stdout.print(this, String.format("Clean machine produces %d %s",items.getCount(),items.getName()));
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

    /**
     * Prototype Pattern
     * Clone the clean machine
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Stdout.print(this, "Clone a clean machine.");
        return new CleanMachine(this.name);
    }

}
