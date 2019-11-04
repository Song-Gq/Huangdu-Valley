package huangduValley.workshop.processFactory.workSpace;

import huangduValley.Stdout;
import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
import huangduValley.workshop.concreteVisitor.NormalRunVisitor;

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
        Stdout.print(this, "Exit processing");
    }
}