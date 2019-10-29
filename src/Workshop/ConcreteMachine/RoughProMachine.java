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
public class RoughProMachine extends Machine {
    private String name;

    private MachineType machineType;

    public RoughProMachine(String name){
        this.name = name;
        this.machineType = MachineType.RoughProMachine;
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
        System.out.println("RoughProMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("RoughProMachine off!");
    }

    @Override
    public Vector<Product> run(){
        System.out.println("RoughProMachine is running!");
        Vector<Product> productVector = new Vector<Product>();
        return productVector;
    }

    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
