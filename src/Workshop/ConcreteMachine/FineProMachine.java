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
public class FineProMachine extends Machine {
    private String name;

    private MachineType machineType;

    public FineProMachine(String name){
        this.name = name;
        this.machineType = MachineType.FineProMachine;
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
        System.out.println("FineProMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("FineProMachine off!");
    }

    @Override
    public Vector<Product> run(){
        System.out.println("FineProMachine is running!");
        Vector<Product> productVector = new Vector<Product>();
        return productVector;
    }

    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
