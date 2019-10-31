package huangduValley.Workshop.processFactory.workSpace;

import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.ConcreteVisitor.NormalRunVisitor;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class SequentialProcessing extends CompleteProcessing {
    /**
     * Processing in order of CleanMachine, RoughProMachine, FineProMachine
     * @return
     * Vector of products
     * @throws Exception
     */
    @Override
    protected Vector<Items> process() throws Exception {
        Vector<Items> ingredientsVector = ingredients;
        for(CleanMachine cleanMachine:cleanMachines){
            ingredientsVector = cleanMachine.accept(new NormalRunVisitor(ingredientsVector));
        }
        for(RoughProMachine roughProMachine:roughProMachines){
            ingredientsVector = roughProMachine.accept(new NormalRunVisitor(ingredientsVector));
        }
        for(FineProMachine fineProMachine:fineProMachines){
            ingredientsVector = fineProMachine.accept(new NormalRunVisitor(ingredientsVector));
        }
        return ingredientsVector;
    }

    @Override
    protected void exit() {
        System.out.println("huangduValley.Workshop.factory.processTable welcome back again :)");
    }
}