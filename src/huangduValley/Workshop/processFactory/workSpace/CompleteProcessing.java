package huangduValley.Workshop.processFactory.workSpace;

import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.ConcreteVisitor.NormalRunVisitor;

/**
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class CompleteProcessing extends SequentialProcessing {
    @Override
    protected void preProcess() throws Exception {
        for(CleanMachine cleanMachine:cleanMachines){
            ingredients = cleanMachine.accept(new NormalRunVisitor(ingredients));
        }
    }

    @Override
    protected void roughProcess() throws Exception {
        for(RoughProMachine roughProMachine:roughProMachines){
            ingredients = roughProMachine.accept(new NormalRunVisitor(ingredients));
        }
    }

    @Override
    protected void fineProcess() throws Exception {
        for(FineProMachine fineProMachine:fineProMachines){
            ingredients = fineProMachine.accept(new NormalRunVisitor(ingredients));
        }
    }

    @Override
    protected void exit() {
        System.out.println("HuangduValley.Workshop.factory.processTable welcome back again :)");
    }
}