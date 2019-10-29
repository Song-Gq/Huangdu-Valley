package Workshop.ConcreteMachine;

import Workshop.Machine;
import Workshop.Product.Product;
import Workshop.Visitor;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/27
 */
public class CleanMachine extends Machine {
    private String name;

    private MachineType machineType;

    public CleanMachine(String name){
        this.name = name;
        this.machineType = MachineType.CleanMachine;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public MachineType getMachineType(){
        return this.machineType;
    }

    @Override
    public void switchOn(){
        System.out.println("CleanMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("CleanMachine off!");
    }

    @Override
    public Vector<Product> run(){
        System.out.println("CleanMachine is running!");
        Vector<Product> productVector = new Vector<Product>();
        return productVector;
    }

    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
